package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.AdminService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	  private AdminService adminService;
	
	    @PostMapping("/signUp") 
		public Map <String, String> signUp(@RequestBody MultiValueMap<String, String> newAdminDetails) {
	    	Map <String, String> signUpResponse=new HashMap<>();
	    	Boolean adminRegistered= adminService.AddAdmin(Integer.parseInt(newAdminDetails.get("adminId").get(0)),newAdminDetails.get("adminName").get(0), newAdminDetails.get("password").get(0));
	      if(adminRegistered) {
	    	  signUpResponse.put("status", "True");
	    	  signUpResponse.put("massege", "The admin has been registered successfully");
	      }else {
	    	  signUpResponse.put("status", "False");
	    	  signUpResponse.put("massege", "Invalid Info!");
	      }
	      return  signUpResponse;
	  
	    
	    }
}
