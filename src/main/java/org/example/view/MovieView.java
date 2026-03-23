package org.example.view;

import org.example.controller.MovieController;
import org.example.model.Movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void CreateMovieView() {
        Movie movie = generateMovie();
        movieController.createMovieController(movie);
    }

    public Movie generateMovie() {
        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.println("Escriba el título de la película");
        String titulo = scanner.nextLine();

        System.out.println("Escriba el año de la película");
        Integer anio = scanner.nextInt();

        System.out.println("Escriba el rating de la película");
        double rating = scanner.nextDouble();

        System.out.println("Poner la URL del poster de la película");
        String poster = scanner.nextLine();

        System.out.println("Escriba la sinopsis de la película");
        String sinopsis = scanner.nextLine();

        Movie movie = new Movie(titulo, anio, rating, poster, sinopsis);

        scanner.close();

        return movie;
    }

    public void showMovies() {
        List<Movie> movieList = movieController.findAllController();
        for (Movie movie : movieList) {
            System.out.println("Titulo: " + movie.getTitulo() + " | Año: ");
        }
    }

}