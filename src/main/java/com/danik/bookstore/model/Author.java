package com.danik.bookstore.model;

import java.util.Date;

public class Author {
    private int id;
    private String name;
    private Date birthDate;
    private String countryCode;

    public Author(int id, String name, Date birthDate, String countryCode) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

}
