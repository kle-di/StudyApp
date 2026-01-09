package controller;

import model.User;
import service.UserService;

import java.util.List;

/**
 * Controller for user actions.
 */
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    public User findByEmail(String email) {
        return userService.getUserByEmail(email);
    }
}
