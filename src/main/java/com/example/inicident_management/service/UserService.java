package com.example.inicident_management.service;

import com.example.inicident_management.dto.UserDto;
import com.example.inicident_management.entity.User;
import com.example.inicident_management.exception.UserException;
import com.example.inicident_management.mapper.UserMapper;
import com.example.inicident_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDto createUser(UserDto userDto){
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        if(user.isPresent()){
            throw new UserException("User is already there");
        }
        User newUser = UserMapper.UserDtoToUser(userDto);
        userRepository.save(newUser);
        return userDto;
    }
}
