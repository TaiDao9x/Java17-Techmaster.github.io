package backend.repository;

import backend.database.AdminDatabase;
import backend.model.Admin;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class AdminRepository {
    public ArrayList<Admin> findAll() {
        return AdminDatabase.admins;
    }

    public void updateFile(ArrayList<Admin> admin) {
        FileUltils.setDataToFile("admin.json", admin);
    }

}
