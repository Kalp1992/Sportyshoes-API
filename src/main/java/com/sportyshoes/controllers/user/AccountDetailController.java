package com.sportyshoes.controllers.user;

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
@RequestMapping("/api/user")
public class AccountDetailController {
    @Autowired
	private UserAccountDetailService accountDetailService;
    @GetMapping("/{userid}") 
	public Map <String, String> userDetail1(@RequestBody MultiValueMap<String, String> ACDetail1) {
    	Map <String, String> DetailResponse1=new HashMap<>();
    	User userfound1= accountDetailService.AccountDetail(Integer.parseInt(ACDetail1.get("userId").get(0)));
    	if(userfound1 != null) {
    		DetailResponse1.put("status", "true");
    		DetailResponse1.put("massege", "User found");
        }else {
        	DetailResponse1.put("status", "false");
        	DetailResponse1.put("massege", "Invalid userId");
        }
      return  DetailResponse1;
	  
    
    }
}
