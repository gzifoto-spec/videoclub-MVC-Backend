package org.example.controller;

import org.example.model.Movie;
import org.example.repository.MovieRepository;
import org.example.repository.MovieRepositoryImpl;

import java.sql.SQLException;

public class MovieController {

    private MovieRepositoryImpl movieRepository;
    public MovieController(MovieRepositoryImpl movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovieController(Movie movie) throws SQLException {
        movieRepository.createMovie(movie);
    }

}
