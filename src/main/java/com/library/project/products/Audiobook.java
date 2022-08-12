package com.library.project.products;

public class Audiobook extends DVD {
    public Audiobook(int id, String title, int sizeMegabytes) {
        super(id, title, sizeMegabytes);
    }

    @Override
    public String toString() {
        return "Audiobook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sizeMegabytes=" + sizeMegabytes +
                '}';
    }
}
