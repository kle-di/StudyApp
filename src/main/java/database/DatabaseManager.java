package database;

/**
 * Singleton database connection placeholder.
 */
public final class DatabaseManager {

    private static final DatabaseManager INSTANCE = new DatabaseManager();
    private boolean connected;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        return INSTANCE;
    }

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}
