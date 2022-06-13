package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateUserService;
import com.sportyshoes.services.UpdateUserNameService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UpdateUsernameController {
	@Autowired
	private UpdateUserNameService  updateUserNameService ;
	@PatchMapping("{userId}/update/username")
	public Map <String, String> Updateusername(@RequestBody MultiValueMap<String, String> updateUsername) {
		Map <String, String> usernameUpdateResponse=new HashMap<>();
		Boolean usernameUpdated= updateUserNameService.UpdateUserName(Integer.parseInt(updateUsername.get("userId").get(0)));
	  if(usernameUpdated) {
		  usernameUpdateResponse.put("status", "True");
		  usernameUpdateResponse.put("massege", "The user username has been updated successfully");
	  }else {
		  usernameUpdateResponse.put("status", "False");
		  usernameUpdateResponse.put("massege", "Invalid Id!");
	  }
	  return  usernameUpdateResponse;



}}

