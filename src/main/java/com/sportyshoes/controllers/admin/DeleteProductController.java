package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.DeleteProductService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class DeleteProductController {
	@Autowired
	private DeleteProductService  deleteProductService;
	@DeleteMapping("{productId}/delete")
	public Map <String, String> DeleteProduct(@RequestBody MultiValueMap<String, String> deleteProduct) {
		Map <String, String> productDeleteResponse=new HashMap<>();
		Boolean productDeleted= deleteProductService.DeleteProduct(Integer.parseInt(deleteProduct.get("userId").get(0)));
	  if(productDeleted) {
		  productDeleteResponse.put("status", "True");
		  productDeleteResponse.put("massege", "The user  has been deleted successfully");
	  }else {
		  productDeleteResponse.put("status", "False");
		  productDeleteResponse.put("massege", "Invalid Id!");
	  }
	  return  productDeleteResponse;
}
}
