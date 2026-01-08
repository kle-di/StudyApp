package model;

import java.util.UUID;

/**
 * Application user account.
 */
public class User {

    private final String id;
    private String name;
    private final String email;
    private final String password;

    public User(String name, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void updateName(String newName) {
        this.name = newName;
    }
}
