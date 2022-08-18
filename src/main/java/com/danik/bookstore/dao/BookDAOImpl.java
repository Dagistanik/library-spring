package com.danik.bookstore.dao;

import com.danik.bookstore.config.ConnectionFactory;
import com.danik.bookstore.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{
    @Override
    public List<BookWithAuthor> getBooksWithAuthors() {
        List<BookWithAuthor> result = new ArrayList<>();
        String query = "select b.id, b.title, b.year, b.pages, a.id, a.name, a.birth_date, a.country_code from books b, authors a where a.id = b.author_id";
        DataSource ds = ConnectionFactory.getDataSource();

        try(Connection con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query))
        {
            while (rs.next()) {
                //book
                int bookId = rs.getInt(1);
                String bookTitle = rs.getString(2);
                int bookYear = rs.getInt(3);
                int bookPages = rs.getInt(4);


                //author
                int authorId = rs.getInt("a.id");
                String authorName = rs.getString("a.name");
                Date authorBirthDate = rs.getDate("a.birth_date");
                String authorCountryCode = rs.getString("a.country_code");

                Book book = new Book(bookId,bookTitle,authorId,bookYear,bookPages);

                Author author = new Author(authorId,authorName,authorBirthDate,authorCountryCode);

                BookWithAuthor bookWithAuthor = new BookWithAuthor(book,author);

                result.add(bookWithAuthor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<BookWithAuthor> getBooksWithAuthors(String title) {
        List<BookWithAuthor> result = new ArrayList<>();
        String query = "select b.id, b.title, b.year, b.pages, a.id, a.name, a.birth_date, a.country_code from books b, authors a where a.id = b.author_id and b.title like ?";
        DataSource ds = ConnectionFactory.getDataSource();

        try(Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(query);
        ){
            st.setString(1, "%"+title+"%");

            try(ResultSet resultSet = st.executeQuery()
            ){
                while (resultSet.next()) {
                    //book
                    int bookId = resultSet.getInt(1);
                    String bookTitle = resultSet.getString(2);
                    int bookYear = resultSet.getInt(3);
                    int bookPages = resultSet.getInt(4);


                    //author
                    int authorId = resultSet.getInt("a.id");
                    String authorName = resultSet.getString("a.name");
                    Date authorBirthDate = resultSet.getDate("a.birth_date");
                    String authorCountryCode = resultSet.getString("a.country_code");

                    Book book = new Book(bookId,bookTitle,authorId,bookYear,bookPages);

                    Author author = new Author(authorId,authorName,authorBirthDate,authorCountryCode);

                    BookWithAuthor bookWithAuthor = new BookWithAuthor(book,author);

                    result.add(bookWithAuthor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(Book book) {
        DataSource ds = ConnectionFactory.getDataSource();
        String query = "INSERT INTO books (title, year, pages, author_id) VALUES (?, ?, ?, ?)";
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ){
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getYear());
            ps.setInt(3, book.getNumberOfPage());
            ps.setInt(4, book.getAuthorId());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Entry added!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
