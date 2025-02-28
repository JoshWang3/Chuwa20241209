package com.example.userservice.controller;

import com.example.userservice.payload.UserDTO;
import com.example.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO response = userService.register(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        UserDTO response = userService.updateUser(id, user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PostMapping("/user-name")
    public ResponseEntity<UserDTO> getUserByUserName(@RequestBody UserDTO user) {
        UserDTO response = userService.findByUserName(user.getUserName());
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/user-email")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestBody UserDTO user) {
        UserDTO response = userService.findByEmail(user.getEmail());
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/first-last-name")
    public ResponseEntity<UserDTO> getUserByFirstNameAndLastName(@RequestBody UserDTO user) {
        UserDTO response = userService.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
