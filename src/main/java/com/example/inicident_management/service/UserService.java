package com.example.inicident_management.service;

import com.example.inicident_management.dto.UserDto;
import com.example.inicident_management.entity.User;
import com.example.inicident_management.mapper.UserMapper;
import com.example.inicident_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDto createUser(UserDto userDto){
        User user = UserMapper.UserDtoToUser(userDto);
        userRepository.save(user);
        return userDto;


    }
}
