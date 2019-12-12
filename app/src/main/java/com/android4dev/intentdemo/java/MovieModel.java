package com.android4dev.intentdemo.java;

import java.io.Serializable;

public class MovieModel implements Serializable {
    private String movieName;
    private String description;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
