package database;

import java.sql.Connection;
import java.sql.DriverManager;

import exception.DatabaseException;

public final class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/studyapp";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Prevent instantiation
    private ConnectionFactory() {
    }


    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new DatabaseException(
                    "Failed to create database connection",
                    e
            );
        }
    }
}
