package controller;

import service.UserService;
import model.User;

import java.util.List;

public class usercontroller {

    private final UserService userService;

    public usercontroller(UserService userService) {
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
