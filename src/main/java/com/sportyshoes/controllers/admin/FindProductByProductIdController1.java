package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;

import com.sportyshoes.services.FindProductByProductIdService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class FindProductByProductIdController1 {
	@Autowired
	private FindProductByProductIdService findProductByProductIdService;
 @GetMapping("/product/{productId}") 
	public Map <String, String> FindProduct(@RequestBody MultiValueMap<String, String> searchProductbyProductId) {
    	Map <String, String> searchProductResponse=new HashMap<>();
    	Product productfound= findProductByProductIdService.findProductByProductId(Integer.parseInt(searchProductbyProductId.get("productId").get(0)));
      if(productfound != null) {
    	  searchProductResponse.put("status", "true");
    	  searchProductResponse.put("massege", "Product found");
      }else {
    	  searchProductResponse.put("status", "false");
    	  searchProductResponse.put("massege", "Product not found");
      }
      return  searchProductResponse;
	  
    
    }
}
