package com.example.userservice.service.impl;

import com.example.userservice.dao.UserRepository;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.payload.UserDTO;
import com.example.userservice.service.UserService;
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

    @Override
    public UserDTO findByUserName(String username) {
        User userDB = userRepository.findByUserName(username);
        if (userDB == null) {
            return null;
        }

        return new UserDTO(userDB.getId(), userDB.getUserName(), userDB.getEmail(), userDB.getFirstName(), userDB.getLastName());
    }

    @Override
    public UserDTO findByEmail(String email) {
        User userDB = userRepository.findByEmail(email);
        if (userDB == null) {
            return null;
        }

        return new UserDTO(userDB.getId(), userDB.getUserName(), userDB.getEmail(), userDB.getFirstName(), userDB.getLastName());
    }

    @Override
    public UserDTO findByFirstNameAndLastName(String firstName, String lastName) {
        User userDB = userRepository.findByFirstNameAndLastName(firstName, lastName);
        if (userDB == null) {
            return null;
        }

        return new UserDTO(userDB.getId(), userDB.getUserName(), userDB.getEmail(), userDB.getFirstName(), userDB.getLastName());
    }
}
