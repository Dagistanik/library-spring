package com.library.listener;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.library.model.DBConnConfig;
import com.library.util.DBMangerUtil;

public class LibraryContextListener implements ServletContextListener {
    Connection conn = null;

    // Инициализация контекста
    public void contextInitialized(ServletContextEvent event){
        try {
            // Использование объекта конфигурации базы данных для инициализации класса инструмента подключения к базе данных
            DBConnConfig dbConfig = getDBConnConfig(event);
            if (dbConfig != null){
                DBMangerUtil.initDBMangerUtil(dbConfig);
            }

            // Создать соединение с базой данных
            conn = DBMangerUtil.getConnection();

            // Сохраняем соединение в контексте ServletContext
            event.getServletContext().setAttribute("dbConfig", conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Уничтожение контекста
    public void contextDestroyed(ServletContextEvent event){
        try{
            // Закрыть соединение с БД
            DBMangerUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Считать параметры инициализации базы данных в Web.xml, затем создать экземпляр и вернуть объект конфигурации базы данных
    private DBConnConfig getDBConnConfig(ServletContextEvent event){

        // Используем для получения параметров инициализации контекста веб-приложения
        ServletContext ctx = event.getServletContext();
        String driver = ctx.getInitParameter("driver");
        String  url = ctx.getInitParameter("url");
        String  username = ctx.getInitParameter("username");
        String  password = ctx.getInitParameter("password");

        DBConnConfig dbConfig = null;
        dbConfig = new DBConnConfig(driver, url, username, password);
        return dbConfig;
    }
}
