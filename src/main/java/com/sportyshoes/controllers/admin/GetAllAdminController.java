package com.sportyshoes.controllers.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Admin;
import com.sportyshoes.models.Product;
import com.sportyshoes.services.GetAllAdminService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class GetAllAdminController {
	@Autowired
	private GetAllAdminService getAllAdminService;
 @GetMapping("/getAllAdmin") 
 public List AdminDetail() {
	 List<Admin> allAdmin=getAllAdminService.GetallAdmin();
	return allAdmin;
 }
//	public Map <String, String> adminDetail(@RequestBody MultiValueMap<String, String> AllAdminDetail) {
//    	Map <String, String> AllAdminResponse=new HashMap<>();
//    	ArrayList<com.sportyshoes.models.Admin> Alladmin= getAllAdminService.GetallAdmin();
//      
//      return  AllAdminResponse;
//	  
//    
//    }

}
