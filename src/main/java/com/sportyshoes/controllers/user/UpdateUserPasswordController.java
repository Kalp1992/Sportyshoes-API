package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateUserPasswordService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UpdateUserPasswordController {
	@Autowired
	private UpdateUserPasswordService  updatePasswordService ;
	@PatchMapping("{userid}/update/password")
	public Map <String, String> Updateusername(@RequestBody MultiValueMap<String, String> updatePassword) {
		Map <String, String> passwordUpdateResponse=new HashMap<>();
		Boolean passwordUpdated= updatePasswordService.UpdateUserPassword(Integer.parseInt(updatePassword.get("userId").get(0)));
	  if(passwordUpdated) {
		  passwordUpdateResponse.put("status", "True");
		  passwordUpdateResponse.put("massege", "The user password has been updated successfully");
	  }else {
		  passwordUpdateResponse.put("status", "False");
		  passwordUpdateResponse.put("massege", "Invalid Id!");
	  }
	  return  passwordUpdateResponse;



}
}
