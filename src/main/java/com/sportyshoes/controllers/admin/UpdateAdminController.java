package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateAdminService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class UpdateAdminController {
	@Autowired
	private UpdateAdminService  updateService;
	@PostMapping("{adminid}/update")
	public Map <String, String> signUp(@RequestBody MultiValueMap<String, String> updateDetails) {
		Map <String, String> adminUpdateResponse=new HashMap<>();
		Boolean adminUpdated= updateService.UpdateAdmin(Integer.parseInt(updateDetails.get("adminId").get(0)));
	  if(adminUpdated) {
		  adminUpdateResponse.put("status", "True");
		  adminUpdateResponse.put("massege", "The admin has been updated successfully");
	  }else {
		  adminUpdateResponse.put("status", "False");
		  adminUpdateResponse.put("massege", "Invalid Info!");
	  }
	  return  adminUpdateResponse;
	}
}
