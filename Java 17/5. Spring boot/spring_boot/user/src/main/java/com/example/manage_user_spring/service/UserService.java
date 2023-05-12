package com.example.manage_user_spring.service;

import com.example.manage_user_spring.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int ID = 10;

    static {
        for (int i = 1; i < 10; i++) {
            User u = User.builder()
                    .id(i)
                    .userName("Nguyen Van " + i)
                    .password("123456" + i)
                    .email(i + "@gmail.com")
                    .phone("09876632" + i)
                    .build();
            users.add(u);
        }
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void createNewTeacher(User user) {
        user.setId(ID);
        users.add(user);
        ID++;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public void updateUser(User userUpdate) {
        User user = findById(userUpdate.getId());
        user.setUserName(userUpdate.getUserName());
        user.setPhone(userUpdate.getPhone());
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
