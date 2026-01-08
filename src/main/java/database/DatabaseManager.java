package database;

import exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Singleton access to the database connection.
 */
public final class DatabaseManager {

    private static final String URL = getEnv("DB_URL");
    private static final String USER = getEnv("DB_USER");
    private static final String PASSWORD = getEnv("DB_PASSWORD");

    private Connection connection;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = createConnection();
            }
            return connection;
        } catch (Exception e) {
            throw new DatabaseException("Failed to retrieve database connection", e);
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw new DatabaseException("Failed to close database connection", e);
        }
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new DatabaseException("Failed to create database connection", e);
        }
    }

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

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }
}
