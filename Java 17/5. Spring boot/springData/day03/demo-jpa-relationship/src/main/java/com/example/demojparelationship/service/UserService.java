package com.example.demojparelationship.service;

import com.example.demojparelationship.dto.UserDto;
import com.example.demojparelationship.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    private UserRepository userRepository;

    public List<UserDto> findAllUsers() {
        return userRepository.findAllUserDto();
    }

}
