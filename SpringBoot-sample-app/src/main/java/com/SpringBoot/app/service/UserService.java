package com.SpringBoot.app.service;

import com.SpringBoot.app.model.User;
import com.SpringBoot.app.standardControllers.UserRequest;

import java.util.List;

public interface UserService {
	User registerUser(UserRequest user);
	User findUserByNameAndPassword(String name, String password);
	List<User> getAllUsers();
	User getUserById(Long id);
}
