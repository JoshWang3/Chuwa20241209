package com.example.userservice.util.mapper;

import com.example.userservice.entity.User;
import com.example.userservice.payload.UserDTO;
import org.modelmapper.ModelMapper;

public class CustomizedMapper {
    public static UserDTO commentServiceMapperUtil(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }
}
