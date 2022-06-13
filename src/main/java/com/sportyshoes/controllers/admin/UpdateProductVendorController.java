package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateProductVendorService;
import com.sportyshoes.services.UpdateQuantityInStockService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class UpdateProductVendorController {
	@Autowired
	private UpdateProductVendorService  updateProductVendorService  ;
	@PatchMapping("{productId}/update/productVendor")
	public Map <String, String> UpdateMSRP(@RequestBody MultiValueMap<String, String> updateProductVendor) {
		Map <String, String> productVendorUpdateResponse=new HashMap<>();
		Boolean productVendorUpdated= updateProductVendorService.UpdateProductVendor(Integer.parseInt(updateProductVendor.get("productId").get(0)));
	  if( productVendorUpdated) {
		  productVendorUpdateResponse.put("status", "True");
		  productVendorUpdateResponse.put("massege", "The product quantity in stock has been updated successfully");
	  }else {
		  productVendorUpdateResponse.put("status", "False");
		  productVendorUpdateResponse.put("massege", "Invalid ProductId!");
	  }
	  return  productVendorUpdateResponse;



}
}
