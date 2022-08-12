package com.library.project.products;

import java.util.Objects;

public class Book extends Publication {
    public String author;
    public int year;
    public int numberOfPage;

    public Book( int id, String title, String author, int year, int numberOfPage){
        super(id, title);
        this.author = author;
        this.year = year;
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() { return author; }

    public int getYear() { return year; }

    public int getNumberOfPage() { return numberOfPage; }



    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.author.equals(book.author) && this.year == book.year && this.numberOfPage == book.numberOfPage;
    }
    @Override
    public int hashCode(){
        return Objects.hash(author, year, numberOfPage);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", numberOfPage=" + numberOfPage +
                '}';
    }

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
