package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.DeleteUserService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class DeleteUserController {
	@Autowired
	private DeleteUserService  deleteService;
	@DeleteMapping("{userId}/delete")
	public Map <String, String> Delete(@RequestBody MultiValueMap<String, String> delete) {
		Map <String, String> userDeleteResponse=new HashMap<>();
		Boolean userDeleted= deleteService.DeleteUser(Integer.parseInt(delete.get("userId").get(0)));
	  if(userDeleted) {
		  userDeleteResponse.put("status", "True");
		  userDeleteResponse.put("massege", "The user  has been deleted successfully");
	  }else {
		  userDeleteResponse.put("status", "False");
		  userDeleteResponse.put("massege", "Invalid Id!");
	  }
	  return  userDeleteResponse;
}}
