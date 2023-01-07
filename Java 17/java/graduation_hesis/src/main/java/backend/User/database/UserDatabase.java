package backend.User.database;

import backend.User.model.User;
import backend.User.ultils.UserFileUltils;

import java.util.ArrayList;

public class UserDatabase {
    public static ArrayList<User> users() {
        return UserFileUltils.getDataFromFile("user.json");
    }
}
