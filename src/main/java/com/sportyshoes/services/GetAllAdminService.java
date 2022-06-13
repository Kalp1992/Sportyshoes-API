package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;

import com.sportyshoes.repositories.AdminRepository;


@Service
public class GetAllAdminService {
	 @Autowired
     private AdminRepository adminRepository;
	 public  ArrayList<Admin> GetallAdmin() {
			Admin admin= new Admin();
			try {
				return adminRepository.findAllAdmin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			 
		 }
}
