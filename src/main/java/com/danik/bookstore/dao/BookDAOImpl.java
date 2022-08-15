package com.danik.bookstore.dao;

import com.danik.bookstore.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{
    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        ResultSet resultSet = null;

        try{
            Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select b.id, b.title, b.year, b.pages, a.name, a.birth_date, a.country_code\n" +
                    "from books b, authors a\n" +
                    "where a.id = b.author_id");


            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                int year = resultSet.getInt(3);
                int pages = resultSet.getInt(4);
                String authorName = resultSet.getString(5);
                Book book = new Book(id, title, authorName, year, pages);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public void save(Book book) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getYear());
            ps.setInt(5, book.getNumberOfPage());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("==");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
