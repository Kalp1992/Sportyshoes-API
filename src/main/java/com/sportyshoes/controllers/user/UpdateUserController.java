package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UpdateUserController {
	@Autowired
	private UpdateUserService  updateService;
	@PostMapping("{userid}/update")
	public Map <String, String> signUp(@RequestBody MultiValueMap<String, String> updateDetails) {
		Map <String, String> userUpdateResponse=new HashMap<>();
		Boolean userUpdated= updateService.UpdateUser(Integer.parseInt(updateDetails.get("userId").get(0)));
	  if(userUpdated) {
		  userUpdateResponse.put("status", "True");
		  userUpdateResponse.put("massege", "The user has been updated successfully");
	  }else {
		  userUpdateResponse.put("status", "False");
		  userUpdateResponse.put("massege", "Invalid Info!");
	  }
	  return  userUpdateResponse;




}}