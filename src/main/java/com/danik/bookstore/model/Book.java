package com.danik.bookstore.model;

import java.util.Objects;

public class Book extends Publication {
    public int authorId;
    public int year;
    public int numberOfPage;

    public Book( int id, String title, int authorId, int year, int numberOfPage){
        super(id, title);
        this.authorId = authorId;
        this.year = year;
        this.numberOfPage = numberOfPage;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getNumberOfPage() { return numberOfPage; }




//    @Override
//    public int compareTo(Book o) {
//        Integer id = this.id;
//        return id.compareTo(o.id) ;
//    }
//
//    public static Comparator<Book> titleComparator = new Comparator<Book>() {
//        @Override
//        public int compare(Book o1, Book o2) {
//            return o1.getTitle().compareTo(o2.getTitle());
//        }
//    };

}
