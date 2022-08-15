package com.danik.bookstore.dao;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/bms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0950";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection error");
        }
    }
}
