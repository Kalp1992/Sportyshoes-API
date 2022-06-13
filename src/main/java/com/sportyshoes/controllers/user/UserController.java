package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	  private UserService userService;
	
	    @PostMapping("/signUp") 
		public Map <String, String> signUp(@RequestBody MultiValueMap<String, String> newUserDetails) {
	    	Map <String, String> signUpResponse=new HashMap<>();
	    	Boolean userRegistered= userService.AddUser(Integer.parseInt(newUserDetails.get("userId").get(0)),newUserDetails.get("userName").get(0), newUserDetails.get("password").get(0),newUserDetails.get("name").get(0));
	      if(userRegistered) {
	    	  signUpResponse.put("status", "True");
	    	  signUpResponse.put("massege", "The user has been registered successfully");
	      }else {
	    	  signUpResponse.put("status", "False");
	    	  signUpResponse.put("massege", "Invalid Info!");
	      }
	      return  signUpResponse;
  	  
	    
	    }
	
}
