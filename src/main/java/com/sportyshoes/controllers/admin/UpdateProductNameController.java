package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.services.UpdateProductNameService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class UpdateProductNameController {
	@Autowired
	private UpdateProductNameService  updateProductNameService ;
	@PatchMapping("{productId}/update/name")
	public Map <String, String> Updateusername(@RequestBody MultiValueMap<String, String> updateProductname) {
		Map <String, String> productNameUpdateResponse=new HashMap<>();
		Boolean productNameUpdated= updateProductNameService.UpdateProductName(Integer.parseInt(updateProductname.get("productId").get(0)));
	  if( productNameUpdated) {
		  productNameUpdateResponse.put("status", "True");
		  productNameUpdateResponse.put("massege", "The product name has been updated successfully");
	  }else {
		  productNameUpdateResponse.put("status", "False");
		  productNameUpdateResponse.put("massege", "Invalid Id!");
	  }
	  return  productNameUpdateResponse;
}
}
