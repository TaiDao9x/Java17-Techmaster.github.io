package backend.User.database;

import backend.User.model.Admin;
import backend.User.ultils.AdminFileUltils;

import java.util.ArrayList;

public class AdminDatabase {
    public static ArrayList<Admin> admins() {
        return AdminFileUltils.getDataFromFile("admin.json");
    }
}
