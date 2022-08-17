package com.danik.bookstore.model;

import java.util.Objects;

public class BookWithAuthor  {
    private Book book;
    private Author author;

    public BookWithAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public Author getAuthor() {
        return author;
    }
}
