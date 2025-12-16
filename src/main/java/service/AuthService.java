package service;

import model.User;
import repository.UserRepository;
import exception.AuthException;
import exception.ValidationException;
import util.PasswordHasher;
import util.Validator;

public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String name, String email, String password) {
        if (!Validator.isValidUsername(name)) {
            throw new ValidationException("Invalid name");
        }
        if (!Validator.isValidPassword(password)) {
            throw new ValidationException("Invalid password");
        }

        String hashedPassword = PasswordHasher.hash(password);
        User user = new User(name, email, hashedPassword);
        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new AuthException("User not found");
        }

        String hashedPassword = PasswordHasher.hash(password);
        if (!user.getPassword().equals(hashedPassword)) {
            throw new AuthException("Wrong password");
        }

        return user;
    }
}
