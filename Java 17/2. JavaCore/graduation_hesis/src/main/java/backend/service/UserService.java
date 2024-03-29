package backend.service;

import backend.model.Address;
import backend.model.User;
import backend.repository.UserRepository;
import backend.request.UserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserService {
    UserRepository userRepository = new UserRepository();
    ArrayList<User> ALL_USER = userRepository.findAll();

    public ArrayList<User> allUser() {
        return userRepository.findAll();
    }

    public boolean checkEmailValid(String email) {
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]{5}+\\.[\\w]{3,}+|[\\w]{5}+\\.[\\w]{3,}\\.[\\w]{2,})$";

        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public boolean checkPasswordValid(String password) {
        String PASSWORD_PATTERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";

        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public boolean checkPhoneValid(String phone) {
        String PHONE_PATTERN =
                "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))" +
                        "(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

        return Pattern.matches(PHONE_PATTERN, phone);
    }

    public boolean checkEmailExist(String email) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByEmail(String email) {
        User user = new User();
        for (User users : ALL_USER) {
            if (users.getEmail().equalsIgnoreCase(email)) {
                user = users;
            }
        }
        return user;
    }

    public void createNewUser(User newUser) {
        ALL_USER.add(newUser);
        userRepository.updateFile(ALL_USER);
    }

    public void changePassword(UserRequest changePasswordRequest) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(changePasswordRequest.getEmail())) {
                user.setPassword(changePasswordRequest.getPassword());
            }
        }
        userRepository.updateFile(ALL_USER);
    }

    public Address getAddress(String email) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user.getAddress();
            }
        }
        return null;
    }

    public void changeUsername(String email, String newUsername) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                user.setUserName(newUsername);
            }
        }
        userRepository.updateFile(ALL_USER);
    }


    public void changeAddress(String email, Address newAddress) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                user.setAddress(newAddress);
            }
        }
        userRepository.updateFile(ALL_USER);
    }

    public void changePhone(String email, String newPhone) {
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                user.setPhone(newPhone);
            }
        }
        userRepository.updateFile(ALL_USER);
    }

    public void deleteAcount(String emailToDelete) {
        ArrayList<User> toRemove = new ArrayList<>();
        for (User user : ALL_USER) {
            if (user.getEmail().equalsIgnoreCase(emailToDelete)) {
                toRemove.add(user);
            }
        }
        ALL_USER.removeAll(toRemove);
        userRepository.updateFile(ALL_USER);
    }

    public List<User> showAllUser() {
        return ALL_USER;
    }
}
