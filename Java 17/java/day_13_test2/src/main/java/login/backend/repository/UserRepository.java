package login.backend.repository;

import login.backend.database.UserDatabase;
import login.backend.model.User;
import login.backend.request.Request;
import login.backend.ultils.FileUltils;

import java.util.ArrayList;

import static login.backend.database.UserDatabase.users;

public class UserRepository {
    public ArrayList<User> findAll() {
        return UserDatabase.users;
    }

    public void updatePassword(Request updatePassword) {
        for (User user : UserDatabase.users) {
            if (user.getEmail().equals(updatePassword.getEmail())) {
                user.setPassword(updatePassword.getPassword());
            }
        }
        FileUltils.setDataToFile("users.json", UserDatabase.users);
    }

    public void createUser(User user) {
        users.add(user);
        FileUltils.setDataToFile("users.json", UserDatabase.users);
    }

    public void updateUsername(String email, String newUsername) {
        for (User user : UserDatabase.users) {
            if (user.getEmail().equals(email)) {
                user.setUserName(newUsername);
            }
        }
        FileUltils.setDataToFile("users.json", UserDatabase.users);
    }

    public void updateEmail(String email, String newEmail) {
        for (User user : UserDatabase.users) {
            if (user.getEmail().equals(email)) {
                user.setEmail(newEmail);
            }
        }
        FileUltils.setDataToFile("users.json", UserDatabase.users);
    }
}
