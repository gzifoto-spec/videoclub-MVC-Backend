package org.example;

import org.example.controller.MovieController;
import org.example.repository.MovieRepositoryImpl;
import org.example.view.MovieView;

public class Main {
    public static void main(String[] args) {
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        MovieController movieController = new MovieController(movieRepository);
        MovieView movieView = new MovieView(movieController);

        movieView.createMovieView();
        movieView.showMovies();
        movieView.deleteMovieView();
    }
}