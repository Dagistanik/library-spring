package com.danik.bookstore.dao;

import com.danik.bookstore.model.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getAll();

    public void save(Book book);
}
