package com.danik.bookstore.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.sql.DataSource;

@Component
public class Initializer implements ServletContextListener {

    @Resource
    DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionFactory.setDataSource(dataSource);

        System.out.println("App initialized");
    }
}
