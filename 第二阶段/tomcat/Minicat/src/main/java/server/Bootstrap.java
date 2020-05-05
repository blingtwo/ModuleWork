package server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import server.mapper.Context;
import server.mapper.Host;
import server.mapper.Mapper;
import server.mapper.Wrapper;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Minicat的主类
 */
public class Bootstrap {

    /**定义socket监听的端口号*/
    private int port = 8080;
    private Mapper mapper= new Mapper();
    private Map<String, HttpServlet> servletMap = new HashMap<>();
    private String appBase = null;
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Mapper getMapper() { return mapper; }

    public void setMapper(Mapper mapper) { this.mapper = mapper; }

    /**
     * Minicat启动需要初始化展开的一些操作mapper
     */
    public void start() throws Exception {

        //加载解析相关配置，server.xml (作业新增)
        loadServer();

        // 定义一个线程池
        int corePoolSize = 10;
        int maximumPoolSize =50;
        long keepAliveTime = 100L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(50);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("=====>>>Minicat start on port：" + port);

        System.out.println("=========>>>>>>使用线程池进行多线程改造");
        /*
            多线程改造（使用线程池）
         */
        while(true) {

            Socket socket = serverSocket.accept();
            RequestProcessor requestProcessor = new RequestProcessor(socket,mapper);
            threadPoolExecutor.execute(requestProcessor);
        }



    }

    /**
     * 解析加载server.xml文件
     */
    private void loadServer() {
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("server.xml");
            SAXReader reader = new SAXReader();
            Document document = null;
            document = reader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            //获取services
            List<Element> serviceElementList = rootElement.selectNodes("//services");
            for (Element serviceElement : serviceElementList) {
                //获取controller
                Element connector = (Element) serviceElement.selectSingleNode("connector");
                //获取port
                String portStr = connector.attributeValue("port");
                port = Integer.parseInt(portStr);
                //获取engine
                Element engine = (Element) serviceElement.selectSingleNode("engine");
                //获取host
                Element hostElement = (Element) engine.selectSingleNode("host");
                //获取hostName和AppBase
                String hostName = hostElement.attributeValue("name");
                appBase = hostElement.attributeValue("appBase");
                Host host = new Host();
                host.setHostName(hostName);
                mapper.setHost(host);
                //循环扫描webapps文件夹下所有应用
                File appsDir = new File(appBase);
                File[] files = appsDir.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {//即应用文件夹，如demo1
                        List<Context> contextList = host.getContextList();
                        Context context = new Context();
                        context.setAppName(file.getName());
                        contextList.add(context);
                        //加载web.xml
                        loadWebConfig(file, context);
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析并加载web.xml
     * @param file
     * @param context
     */
    private void loadWebConfig(File file, Context context) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (!file1.getName().equals("web.xml")) {
                continue;
            }
            //开始获取web.xml
            SAXReader reader = new SAXReader();
            try {
                Document document = reader.read(new FileInputStream(file1));
                Element rootElement = document.getRootElement();
                //获取servlet
                List<Element> selectNodes = rootElement.selectNodes("//servlet");
                Wrapper wrapper = new Wrapper();
                Map<String, HttpServlet> servletMap = wrapper.getServletMap();
                //URLClassLoader类加载器应用类
                String classPath = appBase + "/" + context.getAppName() + "/server";
                URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{
                        new File(classPath).toURI().toURL()
                });
                for (Element element : selectNodes) {
                    //获取servlet-name
                    Element servletNameElement = (Element) element.selectSingleNode("servlet-name");
                    String servletName = servletNameElement.getStringValue();
                    //获取servlet-class
                    Element servletClassElement = (Element) element.selectSingleNode("servlet-class");
                    String servletClassName = servletClassElement.getStringValue();
                    //根据servletName找servlet-mapping，以及url
                    Node servletMapping = rootElement.selectSingleNode("/web-app/servlet-mapping[servlet-name='" + servletName + "']");
                    String urlPattern = servletMapping.selectSingleNode("url-pattern").getStringValue();
                    //截取Servlet请求名
                    String[] split = urlPattern.split("/");
                    Class<?> aClass = urlClassLoader.loadClass(servletClassName);
                    servletMap.put(split[split.length - 1], (HttpServlet) aClass.newInstance());
                }

                context.getWrapperList().add(wrapper);
                urlClassLoader.close();

            } catch (DocumentException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Minicat 的程序启动入口
     * @param args
     */
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        try {
            // 启动Minicat
            bootstrap.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
