package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for users.
 */
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Avery", "avery@example.com"));
        users.add(new User("Morgan", "morgan@example.com"));
        users.add(new User("Riley", "riley@example.com"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
