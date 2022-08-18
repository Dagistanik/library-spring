package com.danik.bookstore.config;

import com.danik.bookstore.dao.ConnectionFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

@Component
public class Initializer implements ServletContextListener {
    Connection connection;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        connection = ConnectionFactory.getConnection();
        ctx.setAttribute("connection", connection);
        System.out.println("App initialized");
    }
}
