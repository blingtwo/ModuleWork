package com.lagou.edu.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 应癫
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/bank?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&allowPublicKeyRetrieval=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMaxWait(3000);

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}
