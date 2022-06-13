package com.sportyshoes.controllers.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Admin;
import com.sportyshoes.models.User;

import com.sportyshoes.services.GetAllUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class GetAllUserController {

	 @Autowired
		private GetAllUserService getAllUserService;
	 @GetMapping("/getAllUser") 
	 @ResponseBody
	 public List userDetail() {
		 List<User> allUser=getAllUserService.GetallUser();
		return allUser;
	 }	
	 
//	 public Map <String, String> userDetail(@RequestBody MultiValueMap<String, String> AllUserDetail) {
//	    	Map <String, String> AllUserResponse=new HashMap<>();
//	    	ArrayList<User> allUser= getAllUserService.GetallUser();
//	    	if(allUser != null) {
//	    		AllUserResponse.put("status", "true");
//	    		AllUserResponse.put("massege", "All user found ");
//		      }else {
//		    	  AllUserResponse.put("status", "False");
//		    	  AllUserResponse.put("massege", "user not found");
//		      }
//	      return  AllUserResponse;
//		  
//	    
//	    }
}
