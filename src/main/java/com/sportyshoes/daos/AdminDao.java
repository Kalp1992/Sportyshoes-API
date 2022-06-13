package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sportyshoes.models.Admin;


public interface AdminDao {
	// Create Operation
			Integer createAdmin(Admin admin) throws SQLException ;
			
			// Read/Retrieve Operations
			Admin findAdminByAdminNameandPassword(String adminName, String password) throws SQLException ;
			
			
			ArrayList<Admin> findAllAdmin() throws SQLException;
			
			
			// Update Operations
			Integer updateAdmin(Admin admin) throws SQLException ;
			
			Integer updateAdminName(Admin admin) throws SQLException;
			
			Integer updateAdminPassword(Admin admin) throws SQLException;

			
			// Delete Operations
			Integer deleteAdminByAdminId(Integer adminId) throws SQLException;

		

			

}
