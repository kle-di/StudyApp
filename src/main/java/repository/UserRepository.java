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
    }

    public void add(User user) {
        users.add(user);
    }

    public void save(User user) {
        add(user);
    }

    public List<User> findAll() {
        return users;
    }

    public User findByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
}
