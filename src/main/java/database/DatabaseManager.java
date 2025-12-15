package database;

import java.sql.Connection;
import exception.DatabaseException;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() {
        this.connection = ConnectionFactory.createConnection();
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = ConnectionFactory.createConnection();
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
}