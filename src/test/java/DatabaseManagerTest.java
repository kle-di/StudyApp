import database.DatabaseManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseManagerTest {

    @Test
    void singletonInstanceIsStable() {
        DatabaseManager first = DatabaseManager.getInstance();
        DatabaseManager second = DatabaseManager.getInstance();

        assertSame(first, second);
    }

    @Test
    void connectAndDisconnectToggleState() {
        DatabaseManager manager = DatabaseManager.getInstance();

        manager.disconnect();
        assertFalse(manager.isConnected());

        manager.connect();
        assertTrue(manager.isConnected());

        manager.disconnect();
        assertFalse(manager.isConnected());
    }
}
