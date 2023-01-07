package backend.User.controler;

import backend.User.model.Admin;
import backend.User.service.AdminService;

public class AdminController {
    AdminService adminService = new AdminService();

    public boolean checkEmailExist(String email) {
        return adminService.checkEmailExist(email);
    }

    public boolean checkEmailValid(String email) {
        return adminService.checkEmailValid(email);
    }

    public Admin getAdminByEmail(String email) {
        return adminService.getAdminByEmail(email);
    }

    public void changeEmail(String email, String newEmail) {
        adminService.changeEmail(email, newEmail);
    }

    public void changePassword(String email, String newPassword) {
        adminService.changePassword(email,newPassword);
    }
}
