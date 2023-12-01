package com.SpringBoot.app.repository;

import com.SpringBoot.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByNameAndPassword(String name, String password);
		
	List<User> findAll();
}
