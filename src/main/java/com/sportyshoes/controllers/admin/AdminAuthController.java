package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.services.AdminAuthService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {
	 @Autowired
	  private AdminAuthService authService;
	
	    @PostMapping("/signIn") 
		public Map <String, String> signIn(@RequestBody MultiValueMap<String, String> credentials) {
	    	Map <String, String> signInResponse=new HashMap<>();
	    	com.sportyshoes.models.Admin adminAuthenticated= authService.SignInAdmin(credentials.get("adminName").get(0), credentials.get("password").get(0));
	      if(adminAuthenticated != null) {
	    	  signInResponse.put("status", "True");
	    	  signInResponse.put("massege", "The admin has been authenticated successfully");
	      }else {
	    	  signInResponse.put("status", "False");
	    	  signInResponse.put("massege", "Invalid credential!");
	      }
	      return  signInResponse;
   	  
	    
	    }
}
