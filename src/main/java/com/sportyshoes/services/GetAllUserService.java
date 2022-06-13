package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class GetAllUserService {
	 @Autowired
     private UserRepository userRepository;
	 public  ArrayList<User> GetallUser() {
			User user= new User();
			try {
				return userRepository.findAllUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			 
		 }
}
