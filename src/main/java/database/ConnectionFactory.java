package database;

import java.sql.Connection;
import java.sql.DriverManager;
import exception.DatabaseException;

public final class ConnectionFactory {

    private static final String URL = getEnv("DB_URL");
    private static final String USER = getEnv("DB_USER");
    private static final String PASSWORD = getEnv("DB_PASSWORD");

    private ConnectionFactory() {}

    private static String getEnv(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            throw new DatabaseException(
                    "Missing environment variable: " + key,
                    new IllegalStateException("Environment variable not set")
            );
        }
        return value;
    }

    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new DatabaseException("Failed to create database connection", e);
        }
    }
}
