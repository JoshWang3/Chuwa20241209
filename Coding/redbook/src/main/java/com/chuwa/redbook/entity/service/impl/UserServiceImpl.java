package com.chuwa.redbook.entity.service.impl;

import com.chuwa.redbook.dao.UserRepository;
import com.chuwa.redbook.entity.User;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.UserDTO;
import com.chuwa.redbook.entity.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO register(UserDTO user) {
        User userDB = new User();
        userDB.setUserName(user.getUserName());
        userDB.setEmail(user.getEmail());
        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());

        userDB = userRepository.save(userDB);

        user.setUserId(userDB.getId());

        return user;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        User userDB = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userDB.setEmail(user.getEmail());
        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());

        userDB = userRepository.save(userDB);

        return new UserDTO(userDB.getId(), userDB.getUserName(), userDB.getEmail(), userDB.getFirstName(), userDB.getLastName());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User userDB = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return new UserDTO(userDB.getId(), userDB.getUserName(), userDB.getEmail(), userDB.getFirstName(), userDB.getLastName());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}