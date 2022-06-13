package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.UpdateProductMSRPService;
import com.sportyshoes.services.UpdateQuantityInStockService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class UpdateQuantityInStockController {
	@Autowired
	private UpdateQuantityInStockService  updateQuantityInStockService ;
	@PatchMapping("{productId}/update/quantityInStock")
	public Map <String, String> UpdateMSRP(@RequestBody MultiValueMap<String, String> updateQuantityInStock) {
		Map <String, String> quantityInStockUpdateResponse=new HashMap<>();
		Boolean quantityInStockUpdated= updateQuantityInStockService.UpdateQuantityInStock(Integer.parseInt(updateQuantityInStock.get("productId").get(0)));
	  if( quantityInStockUpdated) {
		  quantityInStockUpdateResponse.put("status", "True");
		  quantityInStockUpdateResponse.put("massege", "The product quantity in stock has been updated successfully");
	  }else {
		  quantityInStockUpdateResponse.put("status", "False");
		  quantityInStockUpdateResponse.put("massege", "Invalid ProductId!");
	  }
	  return  quantityInStockUpdateResponse;



}
}
