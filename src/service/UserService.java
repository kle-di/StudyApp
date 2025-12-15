// service/AuthService.java
package service;

import model.User;
import repository.UserRepository;

public class AuthService {

    private final UserRepository userRepository;
    private int nextUserId = 1;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name, String email, String password) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
        if (userRepository.findByEmail(email) != null) throw new IllegalArgumentException("Email already exists");

        User user = new User(nextUserId++, name, email, password);
        userRepository.add(user);
        return user;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new IllegalArgumentException("User not found");
        if (!user.getPassword().equals(password)) throw new IllegalArgumentException("Wrong password");
        return user;
    }
}

