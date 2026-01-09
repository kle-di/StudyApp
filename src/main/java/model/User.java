package model;

import java.util.UUID;

/**
 * Application user account.
 */
public class User {

    private final String id;
    private String name;
    private final String email;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateName(String newName) {
        this.name = newName;
    }
}
