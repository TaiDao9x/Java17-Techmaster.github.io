package backend.database;

import backend.model.Admin;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class AdminDatabase {
    public static ArrayList<Admin> admins = FileUltils.getAdminDataFromFile("admin.json");

}
