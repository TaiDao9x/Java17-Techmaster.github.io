package backend.User.repository;

import backend.User.database.UserDatabase;
import backend.User.model.User;
import backend.User.ultils.UserFileUltils;

import java.util.ArrayList;

public class UserRepository {
    public ArrayList<User> findAll() {
        return UserDatabase.users();
    }

    public void updateFile(ArrayList<User> users){
        UserFileUltils.setDataToFile("user.json",users);
    }

}
