package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.AdminDao;
import com.sportyshoes.models.Admin;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class AdminRepository implements AdminDao {
	 @Autowired
     private DatabaseConnection connection;

	@Override
	public Integer createAdmin(Admin admin) throws SQLException {
		String insertAdminFormat = "INSERT INTO admins (ADMIN_ID, PASSWORD, ADMIN_NAME) VALUES ( ?, ?, ?  )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertAdminFormat);) {
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getPassword());
			preparedStatement.setString(3, admin.getAdminName());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Admin findAdminByAdminNameandPassword(String adminName, String password) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
		String getAdminFormat = "SELECT *FROM admins WHERE  ADMIN_NAME = ? and PASSWORD=?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Admin admin = new Admin();
			while (rs.next()) {
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setPassword(rs.getString("PASSWORD"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				
			}
			return admin;
		}
	}

	

	@Override
	public ArrayList<Admin> findAllAdmin() throws SQLException {
		String getAdminsFormat = "SELECT *FROM admins";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminsFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Admin> admins = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return admins;
			}

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setPassword(rs.getString("PASSWORD"));
				admin.setAdminName(rs.getString("ADMIN_NAME"));
				
				admins.add(admin);
			}

			return admins;
			}
	}

	@Override
	public Integer updateAdmin(Admin admin) throws SQLException {
		String updateAdminFormat = "UPDATE admins SET  PASSWORD = ?, ADMIN_NAME = ?, WHERE  ADMIN_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateAdminFormat);) {
			preparedStatement.setString(1, admin.getPassword());
			preparedStatement.setString(2, admin.getAdminName());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateAdminName(Admin admin) throws SQLException {
		String updateAdminNameFormat = "UPDATE admins SET ADMIN_NAME = ?, WHERE  ADMIN_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateAdminNameFormat);) {
			preparedStatement.setString(1, admin.getAdminName());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateAdminPassword(Admin admin) throws SQLException {
		String updateAdminPasswodFormat = "UPDATE admins SET  PASSWORD = ?, WHERE  ADMIN_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateAdminPasswodFormat);) {
			preparedStatement.setString(1, admin.getPassword());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer deleteAdminByAdminId(Integer adminId) throws SQLException {
		String deleteAdminFormat = " DELETE FROM admins WHERE ADMIN_ID = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteAdminFormat);) {
			preparedStatement.setInt(1, adminId);
			return preparedStatement.executeUpdate();
		}
	}
	 

}
