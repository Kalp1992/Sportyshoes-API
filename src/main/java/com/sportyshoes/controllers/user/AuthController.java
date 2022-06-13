package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.UserAuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class AuthController {
	
	  @Autowired
	  private UserAuthService authService;
	
	    @PostMapping("/signIn") 
		public Map <String, String> signIn(@RequestBody MultiValueMap<String, String> credentials) {
	    	Map <String, String> signInResponse=new HashMap<>();
	    	User userAuthenticated= authService.SignInUser(credentials.get("userName").get(0), credentials.get("password").get(0));
	      if(userAuthenticated != null) {
	    	  signInResponse.put("status", "true");
	    	  signInResponse.put("massege", "The user has been authenticated successfully");
	      }else {
	    	  signInResponse.put("status", "false");
	    	  signInResponse.put("massege", "Invalid credential!");
	      }
	      return  signInResponse;
    	  
	    
	    }
}
