package com.sportyshoes.daos;


import java.sql.SQLException;
import java.util.ArrayList;

import com.sportyshoes.models.User;

public interface UserDao {
	
	// Create Operation
		Integer createUser(User user) throws SQLException ;
		
		// Read/Retrieve Operations
		User findUserByUserNameandPassword(String userName, String password) throws SQLException ;
		
		User findUserByName(String name) throws SQLException ;
		
		ArrayList<User> findAllUsers() throws SQLException;
		
		// Update Operations
		Integer updateUser(User user) throws SQLException ;
		
		// Delete Operations
		Integer deleteUserByUserId(Integer userId) throws SQLException;

		User findUserByUserId(Integer userId) throws SQLException;

		Integer updateUserName(User user) throws SQLException;

		Integer updateUserPassword(User user) throws SQLException;

		
		
}
