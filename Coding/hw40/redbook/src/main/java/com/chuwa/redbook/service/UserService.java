package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.UserDTO;

public interface UserService {

    UserDTO register(UserDTO user);

    UserDTO updateUser(Long id, UserDTO user);

    UserDTO getUserById(Long id);

    void deleteUser(Long id);
}
