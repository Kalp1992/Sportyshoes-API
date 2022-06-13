package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UpdateUserService {
	@Autowired
    private UserRepository userRepository;
	public Boolean UpdateUser(Integer userId) {
		User user= new User(userId);
		try {
			return userRepository.updateUser(user)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
		 
	
	 
}

