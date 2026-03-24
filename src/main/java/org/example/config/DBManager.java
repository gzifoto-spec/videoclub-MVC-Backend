package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/the_omen?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection connection;

    public static Connection initConnection() {
        try {
            connection=DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conectado a BBDD con éxito!");
        }
        catch (SQLException exception) {
            System.out.println("Conexión BBDD fallida" + exception.getMessage());
        }
        return connection;
    }

public static void closeConnection(){
        try {
            connection.close();
            System.out.println("Conexión cerrada!");
        }catch (SQLException exception){
            System.out.println("Error al cerrar la BBDD" + exception.getMessage());
        }
    }

}
