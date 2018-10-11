package com.example.hemant.myapplication.expandable;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    private List<Movie> movieList;
    private static final AppData ourInstance = new AppData();

    public static AppData getInstance() {
        return ourInstance;
    }

    private AppData() {
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovie() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        this.movieList.add(movie);
    }

    public Movie getMovie(int index) {
        return this.movieList.get(index);
    }
}
