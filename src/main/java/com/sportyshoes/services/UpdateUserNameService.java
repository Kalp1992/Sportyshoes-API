package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UpdateUserNameService {
	@Autowired
    private UserRepository userRepository;
	public Boolean UpdateUserName(Integer userId) {
		User user= new User(userId);
		try {
			return userRepository.updateUserName(user)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
}
