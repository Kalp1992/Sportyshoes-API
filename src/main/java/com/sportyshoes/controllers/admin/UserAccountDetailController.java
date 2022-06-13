package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.UserAccountDetailService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class UserAccountDetailController {
    @Autowired
	private UserAccountDetailService accountDetailService;
    @GetMapping("/{userid}") 
	public Map <String, String> userDetail(@RequestBody MultiValueMap<String, String> ACDetail) {
    	Map <String, String> DetailResponse=new HashMap<>();
    	User userfound= accountDetailService.AccountDetail(Integer.parseInt(ACDetail.get("userId").get(0)));
    	if( userfound != null) {
    		DetailResponse.put("status", "True");
    		DetailResponse.put("massege", "User account detail found");
  	  }else {
  		    DetailResponse.put("status", "False");
  		    DetailResponse.put("massege", "Invalid UserId!");
  	  }
      return  DetailResponse;
	  
    
    }
}
