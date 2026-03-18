package org.example.repository;

import org.example.config.DBManager;
import org.example.model.Movie;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieRepositoryImpl {

    private Connection connection;
    public void createMovie(Movie movie) throws SQLException {
        String querySQLCreate = "INSERT INTO terror.json (titulo, anio, rating, poster, sinopsis) VALUES ('"+ movie.getTitulo() + "','"+ movie.getAnio() +"','" + movie.getRating() + "','"+ movie.getPoster() +"','"+ movie.getSinopsis() +"')";

    try {
        connection = DBManager.initConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(querySQLCreate);
        System.out.println("Película creada");
    } catch (Exception exception){
        System.out.println(exception.getMessage());
    } finally {
        DBManager.closeConnection();
    }
}

}
