package backend.controler;

import backend.model.Address;
import backend.model.User;
import backend.request.UserRequest;
import backend.service.UserService;

import java.util.List;


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

    public void changeAddress(String email, Address newAddress) {
        userService.changeAddress(email, newAddress);
    }

    public void changePhone(String email, String newPhone) {
        userService.changePhone(email, newPhone);
    }

    public void deleteAcount(String emailToDelete) {
        userService.deleteAcount(emailToDelete);
    }


    public List<User> showAllUser() {
        return userService.showAllUser();
    }
}
