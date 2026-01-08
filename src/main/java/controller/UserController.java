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

    public void createUser(User user) {
        userService.createUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }
}
