package com.springboot.java9modules.service.domain;

public class Movies {

    private String id;

    private String title;

    private String genre;

    public Movies(String id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Movies() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
