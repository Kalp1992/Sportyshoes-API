package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;

import com.sportyshoes.repositories.AdminRepository;

@Service
public class UpdateAdminPasswordService {
	@Autowired
    private AdminRepository adminRepository;
	public Boolean UpdateAdminPassword(Integer adminId) {
		Admin admin= new Admin(adminId);
		try {
			return adminRepository.updateAdminPassword(admin)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
	
}
