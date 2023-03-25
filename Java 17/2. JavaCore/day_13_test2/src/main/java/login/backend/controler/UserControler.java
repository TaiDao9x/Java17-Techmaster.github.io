package login.backend.controler;

import login.backend.model.User;
import login.backend.request.Request;
import login.backend.service.UserService;

import java.util.ArrayList;

public class UserControler {

    UserService userService = new UserService();

    public void checkLogin(Request loginRequest) {
        userService.checkLogin(loginRequest);
    }

    public boolean checkEmail(String email) {
        return userService.checkEmail(email);
    }

    public boolean checkEmailValid(String email) {
        return userService.checkEmailValid(email);
    }

    public boolean checkEmailExists(String email) {
        return userService.checkEmailExists(email);
    }

    public boolean checkPassword(String newPassword) {
        return userService.checkPassword(newPassword);
    }

    public void updatePassword(Request updatePassword) {
        userService.updatePassword(updatePassword);
    }

    public void createUser(User newUser) {
        userService.createUser(newUser);
    }

    public User findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    public void updateUsername(String email, String newUsername) {
        userService.updateUsername(email, newUsername);
    }

    public void updateEmail(String email, String newEmail) {
        userService.updateEmail(email, newEmail);
    }

    public ArrayList findAll() {
       return userService.findAll();
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
}
