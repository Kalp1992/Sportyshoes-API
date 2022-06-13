package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UserAuthService {
	  @Autowired
      private UserRepository userRepository;
 public User SignInUser(String userName,String password) {
	  
			User user= new User(userName, password);
			try {
				return userRepository.findUserByUserNameandPassword(userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;             
			 
		 
	
	 
 }
}
