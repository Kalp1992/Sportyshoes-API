package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportyshoes.models.User;

import com.sportyshoes.repositories.UserRepository;

@Service
public class FindUserByNameService {
	@Autowired
    private UserRepository userRepository;
	 public User findUserByName(String name) {
			User user= new User(name);
			try {
				return userRepository.findUserByName(name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
