package com.example.manage_user_spring.controller;

import com.example.manage_user_spring.model.User;
import com.example.manage_user_spring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    UserService userService;

    @GetMapping
    public String getUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("dachSachUser", users);
        return "user-list";
    }

    @GetMapping("/create-form")
    public String fowardToCreateUserForm(Model model, User user) {
        model.addAttribute("userToiMuonTaoMoi", user);
        return "create-user";
    }

    @PostMapping
    public String createNewTeacher(@ModelAttribute("user") User user) {
        userService.createNewTeacher(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String forwardToEditUser(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("userToiMuonCapNhat", user);
        return "edit-user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
