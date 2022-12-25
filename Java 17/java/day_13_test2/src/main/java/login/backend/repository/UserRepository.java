package login.backend.repository;

import login.backend.database.UserDatabase;
import login.backend.model.User;
import login.backend.ultils.FileUltils;

import java.util.ArrayList;


public class UserRepository {
    public ArrayList<User> findAll() {
        return UserDatabase.users;
    }

    public void updateFiles(ArrayList<User> users) {
        FileUltils.setDataToFile("users.json", users);
    }


}
