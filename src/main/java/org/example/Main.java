package org.example;

import org.example.config.DBManager;
import org.example.controller.MovieController;
import org.example.model.Movie;
import org.example.repository.MovieRepositoryImpl;
import org.example.view.MovieView;

import java.sql.SQLException;


public class Main {
    static void main() throws SQLException {


        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        MovieController movieController = new MovieController(movieRepository);

        MovieView movieView = new MovieView(movieController);
        movieView.CreateMovieView();
    }

}
