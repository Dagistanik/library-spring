package com.danik.bookstore.model;

import java.util.Objects;

public class DVD extends Publication {
    public int sizeMegabytes;
    public DVD (int id, String title, int sizeMegabytes){
        super(id, title);
        this.sizeMegabytes = sizeMegabytes;
    }

    public int getSizeMegabytes() {
        return sizeMegabytes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return this.sizeMegabytes == dvd.sizeMegabytes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeMegabytes);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sizeMegabytes=" + sizeMegabytes +
                '}';
    }
}
