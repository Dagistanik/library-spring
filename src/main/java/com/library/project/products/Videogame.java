package com.library.project.products;

public class Videogame extends DVD{
    public Videogame(int id, String title, int sizeMegabytes) {
        super(id, title, sizeMegabytes);
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sizeMegabytes=" + sizeMegabytes +
                '}';
    }
}
