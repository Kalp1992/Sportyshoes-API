package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateAdminPasswordService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class UpdateAdminPasswordController {
	@Autowired
	private UpdateAdminPasswordService  updatePasswordService ;
	@PatchMapping("{adminid}/update/password")
	public Map <String, String> Updateusername(@RequestBody MultiValueMap<String, String> updatePassword) {
		Map <String, String> passwordUpdateResponse=new HashMap<>();
		Boolean passwordUpdated= updatePasswordService.UpdateAdminPassword(Integer.parseInt(updatePassword.get("adminId").get(0)));
	  if(passwordUpdated) {
		  passwordUpdateResponse.put("status", "True");
		  passwordUpdateResponse.put("massege", "The admin password has been updated successfully");
	  }else {
		  passwordUpdateResponse.put("status", "False");
		  passwordUpdateResponse.put("massege", "Invalid Id!");
	  }
	  return  passwordUpdateResponse;

	}
}
