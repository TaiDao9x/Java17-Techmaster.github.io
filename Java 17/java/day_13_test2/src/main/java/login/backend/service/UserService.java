package login.backend.service;

import login.backend.exception.NotFoundException;
import login.backend.model.User;
import login.backend.repository.UserRepository;
import login.backend.request.Request;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserService {
    UserRepository userRepository = new UserRepository();
    ArrayList<User> ALL_USER = userRepository.findAll();

    public void checkLogin(Request loginRequest) {

        if (checkEmailValid(loginRequest.getEmail()) && checkEmailExists(loginRequest.getEmail())) {
            for (User user : ALL_USER) {
                if (user.getEmail().equals(loginRequest.getEmail()) &&
                        user.getPassword().equals(loginRequest.getPassword())) {
                    return;
                }
            }
        }
        throw new NotFoundException("Đăng nhập thất bại. Hãy đăng nhập lại!");
    }

    public boolean checkEmail(String email) {

        return checkEmailValid(email) && checkEmailExists(email);
    }


    public boolean checkEmailValid(String email) {
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]{5}+\\.[\\w]+|[\\w]{5}+\\.[\\w]{2,}\\.[\\w]{2,})$";

        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public boolean checkEmailExists(String email) {
        for (User user : ALL_USER) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password) {
        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public void updatePassword(Request updatePassword) {
        userRepository.updatePassword(updatePassword);
    }

    public void createUser(User newUser) {
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.createUser(user);

    }

    public User findUserByEmail(String email) {
        User findUser = new User();
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                findUser = user;
            }
        }
        return findUser;
    }

    public void updateUsername(String email, String newUsername) {
        userRepository.updateUsername(email, newUsername);
    }

    public void updateEmail(String email, String newEmail) {
        userRepository.updateEmail(email, newEmail);
    }
}
