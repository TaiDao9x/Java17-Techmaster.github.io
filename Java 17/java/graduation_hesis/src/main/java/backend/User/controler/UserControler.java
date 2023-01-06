package backend.User.controler;

import backend.User.model.Address;
import backend.User.model.User;
import backend.User.request.UserRequest;
import backend.User.service.UserService;


public class UserControler {

    UserService userService = new UserService();


    public boolean checkEmailValid(String email) {
        return userService.checkEmailValid(email);
    }

    public boolean checkEmailExist(String email) {
        return userService.checkEmailExist(email);
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public boolean checkPasswordValid(String password) {
        return userService.checkPasswordValid(password);
    }

    public boolean checkPhoneValid(String phone) {
        return userService.checkPhoneValid(phone);
    }

    public void createNewUser(User newUser) {
        userService.createNewUser(newUser);
    }

    public void changePassword(UserRequest changePasswordRequest) {
        userService.changePassword(changePasswordRequest);
    }


    public void changeUsername(String email, String newUsername) {
        userService.changeUsername(email, newUsername);
    }

    public void changePassword(String email, String newPassword) {
        userService.changePassword(email, newPassword);
    }

    public void changeAddress(String email, Address newAddress) {
        userService.changeAddress(email,newAddress);
    }
}
