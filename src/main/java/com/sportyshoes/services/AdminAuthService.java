package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;

import com.sportyshoes.repositories.AdminRepository;


@Service
public class AdminAuthService {
	 @Autowired
     private AdminRepository adminRepository;
public Admin SignInAdmin(String adminName,String password) {
	  
			Admin admin= new Admin(adminName, password);
			try {
				return adminRepository.findAdminByAdminNameandPassword(adminName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;             
			 
}}
