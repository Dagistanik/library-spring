package com.danik.bookstore.model;

import com.danik.project.random.MothsOfYear;

public class Newspaper extends Periodical{
    public Newspaper(int id, String title, MothsOfYear month) {
        super(id, title, month);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", month'" + month + '\'' +
                '}';
    }
}
