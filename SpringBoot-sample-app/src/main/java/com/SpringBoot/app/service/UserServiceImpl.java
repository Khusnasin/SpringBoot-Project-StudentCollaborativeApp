package com.SpringBoot.app.service;

import com.SpringBoot.app.model.User;
import com.SpringBoot.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;

	@Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
	
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        //implementation to get a user by ID
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
