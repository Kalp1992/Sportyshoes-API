package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;

import com.sportyshoes.repositories.AdminRepository;


@Service
public class DeleteAdminService {
	@Autowired
    private AdminRepository adminRepository;
	public Boolean DeleteAdmin(Integer adminId) {
		Admin admin= new Admin(adminId);
		try {
			return adminRepository.deleteAdminByAdminId(adminId)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
}
