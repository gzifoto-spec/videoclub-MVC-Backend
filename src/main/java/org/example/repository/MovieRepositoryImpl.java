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
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLCreate);
            statement.setString(1, movie.getTitulo());
            statement.setInt(2, movie.getAnio());
            statement.setDouble(3, movie.getRating());
            statement.setString(4, movie.getPoster());
            statement.setString(5, movie.getSinopsis());
            statement.execute();
            System.out.println("Película creada");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }

    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        String querySQLSelectAll = "SELECT * FROM movies";
        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLSelectAll);
            ResultSet response = statement.executeQuery();
            while (response.next()) {
                int id = response.getInt("id");
                String titulo = response.getString("titulo");
                int anio = response.getInt("anio");
                double rating = response.getDouble("rating");
                String poster = response.getString("poster");
                String sinopsis = response.getString("sinopsis");
                movies.add(new Movie(id, titulo, anio, rating, poster, sinopsis));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
        return movies;
    }

    public void deleteMovie(int id) {
        String querySQLDelete = "DELETE FROM movies WHERE id = ?";
        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLDelete);
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Película eliminada");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }
}