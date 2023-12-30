package com.SpringBoot.app.controller;

import com.SpringBoot.app.model.User;
import com.SpringBoot.app.service.UserService;
import com.SpringBoot.app.standardControllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registeruser")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok("User Registered Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    @PostMapping("/loginuser")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest request) {
        try {
            User user = userService.findUserByNameAndPassword(request.getName(), request.getPassword());

            if (user != null) {
                UserResponse response = new UserResponse(
                    user.getName(),
                    user.getId()
                );
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(400).body(new ErrorResponse("Login failed"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
    
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);

            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(404).body(new ErrorResponse("User not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
        }
    }
    
    
}