package com.danik.bookstore.dao;

import com.danik.bookstore.model.Book;
import com.danik.bookstore.model.BookWithAuthor;

import java.util.List;

public interface BookDAO {
//    public List<Book> getAll();

    public void create(Book book);

    public List<BookWithAuthor> getBooksWithAuthors();

    public List<BookWithAuthor> getBooksWithAuthors(String title);

//    public List<Book> searchByTitle(String title);

    public List<Book> findByAuthor(int authorId);
}
