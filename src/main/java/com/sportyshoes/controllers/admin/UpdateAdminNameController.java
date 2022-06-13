package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateAdminNameService;
import com.sportyshoes.services.UpdateUserNameService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class UpdateAdminNameController {
	@Autowired
	private UpdateAdminNameService  updateAdminNameService ;
	@PatchMapping("{adminId}/update/username")
	public Map <String, String> Updateusername(@RequestBody MultiValueMap<String, String> updateAdminname) {
		Map <String, String> adminnameUpdateResponse=new HashMap<>();
		Boolean adminnameUpdated= updateAdminNameService.UpdateAdminName(Integer.parseInt(updateAdminname.get("adminId").get(0)));
	  if(adminnameUpdated) {
		  adminnameUpdateResponse.put("status", "True");
		  adminnameUpdateResponse.put("massege", "The admin adminname has been updated successfully");
	  }else {
		  adminnameUpdateResponse.put("status", "False");
		  adminnameUpdateResponse.put("massege", "Invalid Id!");
	  }
	  return  adminnameUpdateResponse;
}}
