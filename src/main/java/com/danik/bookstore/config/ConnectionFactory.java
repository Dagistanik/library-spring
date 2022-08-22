package com.danik.bookstore.config;

import javax.sql.DataSource;

public class ConnectionFactory {

    public static DataSource dataSource;

    public static void setDataSource(DataSource dataSource){
        ConnectionFactory.dataSource=dataSource;
    }

//    public static DataSource getDataSource(){
//            return dataSource;
//    }
}
