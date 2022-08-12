package com.library.project;

import com.library.exceptions.LibraryException;
import com.library.project.products.*;
import com.library.project.random.MonthRandom;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;

public class Library {
    private static final String URL = "jdbc:mysql://localhost:3306/bms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0950";
    private static Library INSTANCE;
    private static final int MAXBOOKS = 20;
    protected  List <Publication> publications;
    protected Map <Integer, Publication> publicationsMap;
    public Library(int maxBooks) {
        int id = 1;
        publications = new LinkedList<>();
        publicationsMap = new HashMap<>();
        for (int i = 1; i <= maxBooks ; i++) {
            double r = Math.random();
            Publication p = null;
            if (r<0.33){
                p = new Book(i,createTitle(), "TestAuthor", 2022, 24);
            }else if (r<0.66){
                r = Math.random();
                if (r<0.33){
                    p = new Journal(i, createTitle(), MonthRandom.randomMonth());
                } else if (r<0.66) {
                    p = new Newspaper(i, createTitle(), MonthRandom.randomMonth());
                } else {
                    p = new Periodical(i, createTitle(), MonthRandom.randomMonth());
                }
            }else {
                r = Math.random();
                if (r<0.33){
                    p =new Videogame(i, createTitle(), 456);
                }else if (r<0.66){
                    p =new Audiobook(i, createTitle(), 456);
                }else {
                    p =new DVD(i, createTitle(), 456);
                }
            }
            publications.add(p);
            publicationsMap.put(i, p);
        }
    }

    public void add(Publication publication) {
        publications.add(publication);
        publicationsMap.put(publication.getId(),publication);
    }
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        for (Publication p : publications){
            if (p.getClass().equals(Book.class)){
                books.add((Book) p);
            }
        }
        return books;
    }
    public List<Periodical> getPeriodicals(){
        List<Periodical> periodicals = new ArrayList<>();
        for (Publication p : publications){
            if (p instanceof Periodical){
                periodicals.add((Periodical) p);
            }
        }
        return periodicals;
    }
    public List<Journal> getJournals(){
        List<Journal> journals = new ArrayList<>();
        for (Publication p : publications){
            if (Journal.class.isAssignableFrom(p.getClass())){
                journals.add((Journal) p);
            }
        }
        return journals;
    }
    public List<Newspaper> getNewpapers(){
        List<Newspaper> newspapers = new ArrayList<>();
        for(Publication p : publications) {
            if (p instanceof Newspaper){
                newspapers.add((Newspaper) p);
            }
        }
        return newspapers;
    }
    public List<DVD> getDvds(){
        List<DVD> dvds = new ArrayList<>();
        for (Publication p : publications){
            if (p instanceof DVD){
                dvds.add((DVD) p);
            }
        }
        return dvds;
    }
    public List<Audiobook> getAudiobooks(){
        List<Audiobook> audiobooks = new ArrayList<>();
        for (Publication p : publications){
            if ( p instanceof Audiobook){
                audiobooks.add((Audiobook) p);
            }
        }
        return audiobooks;
    }
    public List<Videogame> getVideogames(){
        List<Videogame> videogames = new ArrayList<>();
        for (Publication p : publications) {
            if( p instanceof Videogame){
                videogames.add((Videogame) p);
            }
        }
        return videogames;
    }
    Book getBook(int id) throws LibraryException{
        //check if class matches, cast or throw exception
        Publication p = findById(id);
        if (p instanceof Book){
        } else {
            throw new LibraryException("there is no book with this id");
        }
        System.out.println(p);
        return (Book) p;
    }
    DVD getDVD(int id) throws LibraryException{
        //check if class matches, cast or throw exception
        Publication p = findById(id);
        if (p instanceof DVD){
        } else { throw new LibraryException("there is no DVD with this id");
        }
        System.out.println(p);
        return (DVD) p;
    }
    Periodical getPeriodical(int id) throws LibraryException{
        Publication p = findById(id);
        if (p instanceof Periodical){
        } else {
            throw new LibraryException("there is no Periodical with this id");
        }
        System.out.println(p);
        return (Periodical) p;
    }
    public static String createTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 100; // letter 'z'
        int targetStringLength = 3; // 10
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
    private Publication findById(int id){
        for (Publication p : publications){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void delete(int id) throws LibraryException {
        Publication p = findById(id);
        if(p==null){
            throw new LibraryException("Не существует записи с id = " + id);
        }
        publications.remove(p);
        publicationsMap.remove(id);
    }
    public synchronized static Library getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Library(MAXBOOKS);
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
//        Library l = Library.getInstance();
//        List<Book> booksList = l.getBooks();
//
//        System.out.println("Test");
//
//        System.out.print(StringUtils.rightPad("ID", 10, ""));
//        System.out.print(StringUtils.rightPad("TITLE", 12, ""));
//        System.out.print(StringUtils.rightPad("AUTHOR", 15, ""));
//        System.out.print(StringUtils.rightPad("YEAR", 10, ""));
//        System.out.println(StringUtils.rightPad("PAGE", 15, ""));
//
//        for (Book publication : booksList){
//            System.out.print(StringUtils.rightPad(String.valueOf(publication.getId()), 10, ""));
//            System.out.print(StringUtils.rightPad(String.valueOf(publication.getTitle()), 12, ""));
//            System.out.print(StringUtils.rightPad(String.valueOf(publication.getAuthor()), 15, ""));
//            System.out.print(StringUtils.rightPad(String.valueOf(publication.getYear()), 10, ""));
//            System.out.println(StringUtils.rightPad(String.valueOf(publication.getNumberOfPage()), 15, ""));
//        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено!");
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                String genre = resultSet.getString(4);
                System.out.println(id + ", "+ title + ", " + author + ",  " + genre);
            }

            connection.close();
            if (connection.isClosed()){
                System.out.println("Соединение с БД закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int size() {
        return Library.getInstance().size();
    }
}

