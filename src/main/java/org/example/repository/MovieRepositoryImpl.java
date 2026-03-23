package org.example.repository;

import org.example.config.DBManager;
import org.example.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl {

    private Connection connection;
    public void createMovie(Movie movie) {
        String querySQLCreate = "INSERT INTO movies (titulo, anio, rating, poster, sinopsis) VALUES (?,?,?,?,?)";

    try {
        PreparedStatement statement = connection.prepareStatement(querySQLCreate);
        statement.setString(1, movie.getTitulo());
        statement.setInt(2, movie.getAnio());
        statement.setDouble(3, movie.getRating());
        statement.setString(4, movie.getPoster());
        statement.setString(5, movie.getSinopsis());
        statement.execute();

        System.out.println("Película creada");

    } catch (Exception exception){
        System.out.println(exception.getMessage());

    } finally {
        DBManager.closeConnection();
    }
}   public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();

        String querySQLSelectAll = "SELECT * FROM movies";

        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLSelectAll);
            ResultSet response = statement.executeQuery();

            while (response.next()){
                String titulo = response.getString("titulo");
                int anio = response.getInt("anio");
                double rating = response.getDouble("rating");
                String poster = response.getString("poster");
                String sinopsis = response.getString("sinopsis");

                Movie movie = new Movie(titulo,anio,rating,poster,sinopsis);
                movies.add(movie);

            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }

        return movies;
    }

}
