package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.services.FindUserByNameService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class FindUserByNameController {
	@Autowired
	private FindUserByNameService findUserByNameService;
 @GetMapping("/search?name=<user>") 
	public Map <String, String> ProductDetail(@RequestBody MultiValueMap<String, String> searchUserbyName) {
    	Map <String, String> searchUserResponse=new HashMap<>();
    	com.sportyshoes.models.User userfound= findUserByNameService.findUserByName(searchUserbyName.get("name").get(0));
      if(userfound != null) {
    	  searchUserResponse.put("status", "true");
    	  searchUserResponse.put("massege", "User found");
      }else {
    	  searchUserResponse.put("status", "false");
    	  searchUserResponse.put("massege", "User not found");
      }
      return  searchUserResponse;
	  
    
    }
}
