package com.danik.bookstore.dao;

import com.danik.bookstore.model.Author;

public class AuthorDAOImpl implements AuthorDAO{
    @Override
    public Author getById(String authorId) {
        int id = Integer.parseInt(authorId);
        return null;
    }
}
