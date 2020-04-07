package com.lagou.edu.factory;

import com.lagou.edu.annotation.DefineAutowired;
import com.lagou.edu.annotation.DefineService;
import com.lagou.edu.annotation.DefineTransactional;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

/**
 * 工厂类
 */
public class BeanFactoryAnnotation {
    // 保存对象
    private static Map<String,Object> map = new HashMap<>();
    // 保存@DefineService注释的类和id的对应关系
    private static Map<String, String> serviceIds = new HashMap<>();
    // 保持扫描到的类
    private static List<Class> allClass = new ArrayList<Class>();

    // 任务一：读取解析xml，扫描并获取@DefineService注解的类，通过反射技术实例化对象并且存储
    static {
        // 加载xml
        InputStream resourceAsStream = BeanFactoryAnnotation.class.getClassLoader().getResourceAsStream("beans.xml");
        // 解析xml
        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            List<Element> scanList = rootElement.selectNodes("//component-scan");
            for (int i = 0; i < scanList.size(); i++) {
                Element element = scanList.get(i);
                String scanPackage = element.attributeValue("base-package");
                // 扫描所有被注解的类
                scanAnnotation(scanPackage, DefineService.class);
                // 实例化对象
                executeDefineServiceInstantiate(allClass);
            }
            // 处理依赖@DefineAutoWired
            executeAutoWired(allClass);
            // 处理事务@DefineTransactional
            executeTransactional();
        } catch (DocumentException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void executeDefineServiceInstantiate(List<Class> allClass) throws IllegalAccessException, InstantiationException {
        for (Class clazz : allClass) {
            // 通过反射技术实例化对象
            Object obj = clazz.newInstance();
            DefineService annotation = (DefineService) clazz.getAnnotation(DefineService.class);
            // id就是@DefineService()中的value属性
            String id = annotation.value();
            // 处理id
            if (id.equals("")) {
                // 保存到map
                map.put(clazz.getSimpleName(), obj);
                serviceIds.put(clazz.getName(), clazz.getSimpleName());
            } else {
                // 保存map
                map.put(id, obj);
                serviceIds.put(clazz.getName(), id);
            }
        }
    }

    /**
     * 扫描指定包路径下注解的类
     * */
    public static void scanAnnotation(String scanPackage, Class<?> apiClass) throws ClassNotFoundException {
        String scanPackagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + scanPackage.replaceAll("\\.", "/");
        File pack = new File(scanPackagePath);

        File[] files = pack.listFiles();

        for(File file: files) {
            // 子包
            if(file.isDirectory()) {
                // 递归
                scanAnnotation(scanPackage + "." + file.getName(),apiClass);
            }else if(file.getName().endsWith(".class")) {
                String className = scanPackage + "." + file.getName().replaceAll(".class", "");
                Class clazz = Class.forName(className);
                if (null != clazz.getAnnotation(apiClass)) {
                    allClass.add(clazz);
                }
            }
        }
    }

    /*
     * 处理依赖@AutoWired
     */
    private static void executeAutoWired(List<Class> allClass) throws InvocationTargetException, IllegalAccessException {
        for (Class service : allClass) {
            // 从map中查找对象
            String parentId = serviceIds.get(service.getName());
            // 获取属性
            Field[] fields = service.getDeclaredFields();
            for (Field field : fields) {
                // 如果属性添加了@DefineAutowired注解，则注入
                if (field.isAnnotationPresent(DefineAutowired.class)) {
                    String name = null;
                    String className = null;
                    // 如果属性是一个接口类型，则遍历Class列表，找实现类
                    if (field.getType().isInterface()) {
                        for (Class aClass : allClass) {
                            //同一接口，且不是自己
                            if (field.getType().isAssignableFrom(aClass) && !field.getType().equals(aClass)) {
                                name = field.getType().getSimpleName();
                                className = aClass.getName();
                                break;
                            }
                        }
                    } else {
                        name = field.getType().getSimpleName();
                        className = field.getType().getName();
                    }
                    Object parentObject = map.get(parentId);
                    // 遍历父对象中的所有方法，找"set" + name
                    Method[] methods = parentObject.getClass().getMethods();
                    for (Method method : methods) {
                        // 使用set方式注入依赖
                        if (method.getName().equalsIgnoreCase("set" + name)) {
                            String fieldId = serviceIds.get(className);
                            method.invoke(parentObject, map.get(fieldId));
                        }
                    }
                    //重新保存至map
                    map.put(parentId, parentObject);
                }
            }
        }
    }

    /**
     * 处理事务@DefineTransactional
     */
    private static void executeTransactional() {
        ProxyFactory proxyFactory = (ProxyFactory) map.get("proxyFactory");
        for(Map.Entry<String,Object> entry: map.entrySet()) {
            String beanName = entry.getKey();
            Object obj = entry.getValue();
            Class<?> classz = entry.getValue().getClass();
            if(classz.isAnnotationPresent(DefineTransactional.class)) {
                Class<?>[] interfaces = classz.getInterfaces();
                if(interfaces != null && interfaces.length > 0) {
                    // 使用jdk动态代理
                    map.put(beanName,proxyFactory.getJdkProxy(obj));
                }else{
                    // 使用cglib动态代理
                    map.put(beanName,proxyFactory.getCglibProxy(obj));
                }
            }
        }
    }

    // 任务二：对外提供获取实例对象的接口（根据id获取）
    public static Object getBean(String id){
        return map.get(id);
    }
}
