package org.example.view;

import org.example.controller.MovieController;
import org.example.model.Movie;

import java.sql.SQLException;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void CreateMovieView() throws SQLException {
        Movie movie = generateMovie();
        movieController.createMovieController(movie);
    }

    public Movie generateMovie() {
        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.println("Escriba el nombre de la película");
        String titulo = scanner.nextLine();

        System.out.println("Poner imagen del poster de la película");
        String poster = scanner.nextLine();

        System.out.println("Escriba la descripción de la película");
        String sinopsis = scanner.nextLine();

        System.out.println("Escriba el año de la película");
        Integer anio = scanner.nextInt();

        System.out.println("Escriba el rating de la película");
        double rating = scanner.nextDouble();

        Movie movie = new Movie(titulo, anio, rating, poster, sinopsis);

        scanner.close();

        return movie;
    }

}