package com.SpringBoot.app.service;

import com.SpringBoot.app.model.User;
import java.util.List;

public interface UserService {
	User registerUser(User user);
	User findUserByNameAndPassword(String name, String password);
	List<User> getAllUsers();
}
