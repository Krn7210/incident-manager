package com.example.inicident_management.mapper;

import com.example.inicident_management.dto.UserDto;
import com.example.inicident_management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User UserDtoToUser(UserDto dto){
        User user = new User();
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setPhone(dto.getPhone());
        user.setPinCode(dto.getPinCode());
        user.setUsername(dto.getUsername());
        return user;
    }

}
