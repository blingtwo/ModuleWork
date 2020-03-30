package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(MappedStatement mappedStatement, Object... params) throws Exception {
        //将要去完成对simpleExecutor里的query方法的调用
        simpleExecutor simpleExecutor = new simpleExecutor();
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);

        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(MappedStatement mappedStatement, Object... params) throws Exception {

        List<Object> objects = selectList(mappedStatement, params);
        if(objects.size()==1){
            return (T) objects.get(0);
        }else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }


    }

    @Override
    public Integer insertOne(MappedStatement mappedStatement, Object... params) throws Exception {
        simpleExecutor simpleExecutor = new simpleExecutor();
        Integer insert = simpleExecutor.updateExecute(configuration, mappedStatement, params);
        return insert;
    }

    @Override
    public Integer updateOne(MappedStatement mappedStatement, Object... params) throws Exception {
        simpleExecutor simpleExecutor = new simpleExecutor();
        Integer update = simpleExecutor.updateExecute(configuration, mappedStatement, params);
        return update;
    }

    @Override
    public Integer deleteOne(MappedStatement mappedStatement, Object... params) throws Exception {
        simpleExecutor simpleExecutor = new simpleExecutor();
        Integer delete = simpleExecutor.updateExecute(configuration, mappedStatement, params);
        return delete;
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        // 使用JDK动态代理来为Dao接口生成代理对象，并返回

        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 底层都还是去执行JDBC代码 //根据不同情况，来调用selctList或者selectOne
                // 准备参数 1：statmentid :sql语句的唯一标识：namespace.id= 接口全限定名.方法名
                // 方法名：findAll
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();

                String statementId = className+"."+methodName;

                // 准备参数2：params:args
                // 获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();

                MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);

                switch (mappedStatement.getSqlCommandType()) {
                    case SELECT:
                        // 判断是否进行了 泛型类型参数化
                        if(genericReturnType instanceof ParameterizedType){
                            List<Object> objects = selectList(mappedStatement, args);
                            return objects;
                        } else {
                            return selectOne(mappedStatement,args);
                        }
                    case INSERT:
                        return insertOne(mappedStatement, args);
                    case UPDATE:
                        return updateOne(mappedStatement, args);
                    case DELETE:
                        return deleteOne(mappedStatement, args);
                    default:
                        throw new Exception("Unknown execution method for: " + mappedStatement.getSqlCommandType());
                }
            }
        });

        return (T) proxyInstance;
    }


}
