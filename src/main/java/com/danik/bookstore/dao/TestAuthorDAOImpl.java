package com.danik.bookstore.dao;

import com.danik.bookstore.model.Author;

import java.util.Calendar;
import java.util.Date;

public class TestAuthorDAOImpl implements AuthorDAO{
    @Override
    public Author getById(int id) {
        if(id == 1){
            return new Author(1, "Лев Толстой", new Date(1800, Calendar.FEBRUARY, 1), "RU");
        }
        return null;
    }
}
