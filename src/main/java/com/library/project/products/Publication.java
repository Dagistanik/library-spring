package com.library.project.products;

import java.util.Objects;

public class Publication {
    protected int id;
    protected String title;

    public Publication(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publication publication = (Publication) o;
        return this.id == publication.id && this.title.equals(publication.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
