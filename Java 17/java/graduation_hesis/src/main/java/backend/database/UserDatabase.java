package backend.database;

import backend.model.User;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class UserDatabase {
    public static ArrayList<User> users = FileUltils.getUserDataFromFile("user.json");

}
