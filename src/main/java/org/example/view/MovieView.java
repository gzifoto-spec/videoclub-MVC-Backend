package org.example.view;

import org.example.controller.MovieController;
import org.example.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void createMovieView() {
        Movie movie = generateMovie();
        movieController.createMovieController(movie);
    }

    public Movie generateMovie() {
        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.println("Escriba el título de la película");
        String titulo = scanner.nextLine();

        System.out.println("Escriba el año de la película");
        Integer anio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escriba el rating de la película");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Poner la URL del poster de la película");
        String poster = scanner.nextLine();

        System.out.println("Escriba la sinopsis de la película");
        String sinopsis = scanner.nextLine();

        return new Movie(titulo, anio, rating, poster, sinopsis);
    }

    public void showMovies() {
        List<Movie> movieList = movieController.findAllController();
        for (Movie movie : movieList) {
            System.out.println("ID: " + movie.getId() + " | Titulo: " + movie.getTitulo() + " | Año: " + movie.getAnio() + " | Rating: " + movie.getRating() + " | Poster: " + movie.getPoster() + " | Sinopsis: " + movie.getSinopsis());
        }
    }

    public void deleteMovieView() {
        showMovies();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el ID de la película a eliminar");
        int id = scanner.nextInt();
        movieController.deleteMovieController(id);
    }
}