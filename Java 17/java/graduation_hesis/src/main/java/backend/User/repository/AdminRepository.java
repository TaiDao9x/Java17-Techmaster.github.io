package backend.User.repository;

import backend.User.database.AdminDatabase;
import backend.User.model.Admin;
import backend.User.ultils.AdminFileUltils;

import java.util.ArrayList;

public class AdminRepository {
    public ArrayList<Admin> findAll() {
        return AdminDatabase.admins();
    }

    public void updateFile(ArrayList<Admin> admin) {
        AdminFileUltils.setDataToFile("admin.json", admin);
    }

}
