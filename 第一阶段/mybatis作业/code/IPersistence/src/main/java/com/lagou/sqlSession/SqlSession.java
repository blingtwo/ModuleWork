package com.lagou.sqlSession;

import com.lagou.pojo.MappedStatement;

import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(MappedStatement mappedStatement, Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(MappedStatement mappedStatement,Object... params) throws Exception;

    //新增
    public Integer insertOne(MappedStatement mappedStatement,Object... params) throws Exception;

    //修改
    public Integer updateOne(MappedStatement mappedStatement,Object... params) throws Exception;

    //删除
    public Integer deleteOne(MappedStatement mappedStatement,Object... params) throws Exception;

    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);


}
