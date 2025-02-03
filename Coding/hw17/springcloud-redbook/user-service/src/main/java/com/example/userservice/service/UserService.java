package com.example.userservice.service;

import com.example.userservice.payload.UserDTO;

public interface UserService {

    UserDTO register(UserDTO user);

    UserDTO updateUser(Long id, UserDTO user);

    UserDTO getUserById(Long id);

    void deleteUser(Long id);

    UserDTO findByUserName(String username);

    UserDTO findByEmail(String email);

    UserDTO findByFirstNameAndLastName(String firstName, String lastName);
}
