package com.library.project.products;

import com.library.project.random.MothsOfYear;

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
