package controller;

import model.User;
import service.AuthService;

/**
 * Controller for authentication flows.
 */
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public void register(String name, String email, String password) {
        authService.register(name, email, password);
    }

    public User login(String email, String password) {
        return authService.login(email, password);
    }
}
