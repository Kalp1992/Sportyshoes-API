package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.models.User;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class UserRepository implements UserDao{
      @Autowired
      private DatabaseConnection connection;

	@Override
	public Integer createUser(User user) throws SQLException {
		String insertUserFormat = "INSERT INTO users (USER_ID, PASSWORD, USER_NAME, NAME) VALUES ( ?, ?, ?. ? )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertUserFormat);) {
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getName());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public User findUserByUserNameandPassword(String userName, String password) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
				String getUserFormat = "SELECT *FROM users WHERE  USER_NAME = ? and PASSWORD=?";
				try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
					preparedStatement.setString(1, userName);
					preparedStatement.setString(2, password);
					ResultSet rs = preparedStatement.executeQuery();

					if (!rs.isBeforeFirst()) {
						return null;
					}

					User user = new User();
					while (rs.next()) {
						user.setUserId(rs.getInt("USER_ID"));
						user.setPassword(rs.getString("PASSWORD"));
						user.setUsername(rs.getString("USER_NAME"));
						user.setName(rs.getString("NAME"));
						
					}
					return user;
				}
	}
	@Override
	public User findUserByUserId(Integer userId) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
				String getUserFormat = "SELECT *FROM users WHERE  USER_ID = ? ";
				try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
					preparedStatement.setInt(1, userId);
				    ResultSet rs = preparedStatement.executeQuery();

					if (!rs.isBeforeFirst()) {
						return null;
					}

					User user = new User();
					while (rs.next()) {
						user.setUserId(rs.getInt("USER_ID"));
						user.setPassword(rs.getString("PASSWORD"));
						user.setUsername(rs.getString("USER_NAME"));
						user.setName(rs.getString("NAME"));
						
					}
					return user;
				}
	}
	@Override
	public User findUserByName(String name) throws SQLException {
		String getUserFormat = "SELECT *FROM users WHERE  NAME = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
			preparedStatement.setString(1, name);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			User user = new User();
			while (rs.next()) {
				user.setUserId(rs.getInt("USER_ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setName(rs.getString("NAME"));
				
			}
			return user;
		}
	}
	
	@Override
	public ArrayList<User> findAllUsers() throws SQLException {
		String getUsersFormat = "SELECT *FROM users";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUsersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<User> users = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return users;
			}

			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("User_ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setName(rs.getString("NAME"));
				
				users.add(user);
			}

			return users;
			}
		}

	@Override
	public Integer updateUser(User user) throws SQLException {
		String updateUserFormat = "UPDATE users SET  PASSWORD = ?, USER_NAME = ?, WHERE  USER_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserFormat);) {
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getUsername());
			
			return preparedStatement.executeUpdate();
		}
	}
	@Override
	public Integer updateUserPassword(User user) throws SQLException {
		String updateUserPasswodFormat = "UPDATE users SET  PASSWORD = ?, WHERE  USER_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserPasswodFormat);) {
			preparedStatement.setString(1, user.getPassword());
		
			
			return preparedStatement.executeUpdate();
		}
	}
	@Override
	public Integer updateUserName(User user) throws SQLException {
		String updateUserNameFormat = "UPDATE users SET USER_NAME = ?, WHERE  USER_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserNameFormat);) {
			preparedStatement.setString(1, user.getUsername());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer deleteUserByUserId(Integer userId) throws SQLException {
		String deleteUserFormat = " DELETE FROM users WHERE USER_ID = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteUserFormat);) {
			preparedStatement.setInt(1, userId);
			return preparedStatement.executeUpdate();
		}
	}

	
      
}
