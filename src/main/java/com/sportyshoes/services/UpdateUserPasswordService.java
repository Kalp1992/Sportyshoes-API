package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UpdateUserPasswordService {
	@Autowired
    private UserRepository userRepository;
	public Boolean UpdateUserPassword(Integer userId) {
		User user= new User(userId);
		try {
			return userRepository.updateUserPassword(user)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
}
