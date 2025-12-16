package controller;

import service.AuthService;
import model.User;

public class authcontroller {

    private final AuthService authService;

    public authcontroller(AuthService authService) {
        this.authService = authService;
    }

    public void register(String name, String email, String password) {
        authService.register(name, email, password);
    }

    public User login(String email, String password) {
        return authService.login(email, password);
    }
}
