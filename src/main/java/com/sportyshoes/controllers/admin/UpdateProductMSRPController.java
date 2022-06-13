package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateProductMSRPService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class UpdateProductMSRPController {
	@Autowired
	private UpdateProductMSRPService  updateProductMSRPService ;
	@PatchMapping("{productId}/update/msrp")
	public Map <String, String> UpdateMSRP(@RequestBody MultiValueMap<String, String> updateProductMSRP) {
		Map <String, String> MSRPUpdateResponse=new HashMap<>();
		Boolean MSRPUpdated= updateProductMSRPService.UpdateProductMSRP(Integer.parseInt(updateProductMSRP.get("productId").get(0)));
	  if( MSRPUpdated) {
		  MSRPUpdateResponse.put("status", "True");
		  MSRPUpdateResponse.put("massege", "The product MSRP has been updated successfully");
	  }else {
		  MSRPUpdateResponse.put("status", "False");
		  MSRPUpdateResponse.put("massege", "Invalid ProductId!");
	  }
	  return  MSRPUpdateResponse;



}
}
