package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.DeleteAdminService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class DeleteAdminController {
	@Autowired
	private DeleteAdminService  deleteService;
	@DeleteMapping("{adminid}/delete")
	public Map <String, String> Delete(@RequestBody MultiValueMap<String, String> delete) {
		Map <String, String> adminDeleteResponse=new HashMap<>();
		Boolean adminDeleted= deleteService.DeleteAdmin(Integer.parseInt(delete.get("adminId").get(0)));
	  if(adminDeleted) {
		  adminDeleteResponse.put("status", "True");
		  adminDeleteResponse.put("massege", "The admin  has been deleted successfully");
	  }else {
		  adminDeleteResponse.put("status", "False");
		  adminDeleteResponse.put("massege", "Invalid Id!");
	  }
	  return  adminDeleteResponse;
}
}
