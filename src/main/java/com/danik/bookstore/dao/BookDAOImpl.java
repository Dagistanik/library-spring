package com.danik.bookstore.dao;

import com.danik.bookstore.model.Author;
import com.danik.bookstore.model.Book;
import com.danik.bookstore.model.BookWithAuthor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{
//    @Override
//    public List<Book> getAll() {
//        List<Book> books = new ArrayList<>();
//        ResultSet resultSet = null;
//        Statement statement=null;
//
//        try{
//            Connection connection = ConnectionFactory.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select b.id, b.title, b.year, b.pages, b.author_id\n" +
//                    "from books b");
//
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                int year = resultSet.getInt(3);
//                int pages = resultSet.getInt(4);
//                int authorId = resultSet.getInt(5);
//                Book book = new Book(id, title, authorId, year, pages);
//                books.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                resultSet.close();
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return books;
//    }

    @Override
    public List<BookWithAuthor> getBooksWithAuthors() {
        List<BookWithAuthor> result = new ArrayList<>();
        DataSource ds = ConnectionFactory.getDataSource();

        try(Connection con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select b.id, b.title, b.year, b.pages, a.id, a.name, a.birth_date, a.country_code\n" +
                    "from books b, authors a\n" +
                    "where a.id = b.author_id")
            ){
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
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(
                    "select b.id, b.title, b.year, b.pages, a.id, a.name, a.birth_date, a.country_code\n" +
                            "from books b, authors a\n" +
                            "where a.id = b.author_id\n"+
                            "and b.title like ?"
            );
            statement.setString(1, "%"+title+"%");
            resultSet = statement.executeQuery();


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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

//    @Override
//    public List<Book> searchByTitle(String title) {
//        List<Book> books = new ArrayList<>();
//        ResultSet resultSet = null;
//        Statement statement = null;
//
//        try{
//            Connection connection = ConnectionFactory.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select b.id, b.title, b.author_id, b.year, b.pages, a.name, a.birth_date, a.country_code\n" +
//                    "from books b, authors a\n" +
//                    "where a.id = b.author_id\n" +
//                    "and b.title like '%во%'");
//
//
//            while (resultSet.next()) {
//                int bookId = resultSet.getInt(1);
//                String bookTitle = resultSet.getString(2);
//                int bookYear = resultSet.getInt(4);
//                int bookPages = resultSet.getInt(5);
//                int authorId = resultSet.getInt(3);
//
//                Book book = new Book(bookId,bookTitle,authorId,bookYear,bookPages);
//                books.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                resultSet.close();
//                statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return books;


//    }

    @Override
    public List<Book> findByAuthor(int authorId) {
        return null;
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
