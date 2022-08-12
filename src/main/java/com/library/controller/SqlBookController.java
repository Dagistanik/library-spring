package com.library.controller;

import com.library.listener.LibraryContextListener;
import com.library.project.products.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sqlbook")
public class SqlBookController {
    private static final String URL = "jdbc:mysql://localhost:3306/bms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0950";


    @GetMapping("/list")
    public String books(HttpServletRequest req) {
        List<Book> books = new ArrayList<>();

//        Connection dBconn = (Connection) getServletContext().getAttribute("dbconn");
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            if(!connection.isClosed()){
//                System.out.println("Соединение с БД установлено!");
//            }
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
//            while(resultSet.next()){
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                String author = resultSet.getString(3);
//                int year = resultSet.getInt(4);
//                int pages = resultSet.getInt(5);
//                Book book = new Book(id, title, author, year, pages);
//                books.add(book);
//            }
//            req.setAttribute("books", books);
//            connection.close();
//            if (connection.isClosed()){
//                System.out.println("Соединение с БД закрыто.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return "view-sqlbook";
    }

    @GetMapping("/add")
    public String addBookView() {
        return "add-sqlbook";
    }

    @PostMapping("/add")
    public String addBook(
            @RequestParam(name="id",required = true) String id,
            @RequestParam(name="title",required = true) String title,
            @RequestParam(name="author",required = false) String author,
            @RequestParam(name="year",required = false) String year,
            @RequestParam(name="pages",required = false) String pages,
            HttpServletRequest req, HttpServletResponse resp){

        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено!");
            }
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, id);
                ps.setString(2, title);
                ps.setString(3, author);
                ps.setString(4, year);
                ps.setString(5, pages);
                int i = ps.executeUpdate();


                if(i == 1) {
                    System.out.println("==");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            connection.close();
            if (connection.isClosed()){
                System.out.println("Соединение с БД закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    return "redirect:list";
    }
}

