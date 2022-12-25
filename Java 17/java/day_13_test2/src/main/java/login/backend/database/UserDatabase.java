package login.backend.database;

import login.backend.model.User;
import login.backend.ultils.FileUltils;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    public static ArrayList<User> users = FileUltils.getDataFromFile("users.json");
}
