package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UserAccountDetailService {
	 @Autowired
     private UserRepository userRepository;
	 public User AccountDetail(Integer userId) {
			User user= new User(userId);
			try {
				return userRepository.findUserByUserId(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
