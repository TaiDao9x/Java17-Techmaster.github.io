package backend.repository;

import backend.database.UserDatabase;
import backend.model.User;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class UserRepository {
    public ArrayList<User> findAll() {
        return UserDatabase.users;
    }

    public void updateFile(ArrayList<User> users) {
        FileUltils.setDataToFile("user.json", users);
    }

}
