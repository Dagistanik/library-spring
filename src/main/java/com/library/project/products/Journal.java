package com.library.project.products;

import com.library.project.random.MothsOfYear;

public class Journal extends Periodical{
    public Journal(int id, String title, MothsOfYear month) {
        super(id, title, month);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
