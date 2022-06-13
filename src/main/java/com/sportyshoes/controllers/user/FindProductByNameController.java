package com.sportyshoes.controllers.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.services.FindProductByNameService;
import com.sportyshoes.services.GetAllProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class FindProductByNameController {
	 @Autowired
		private FindProductByNameService findProductByNameService;
	 @GetMapping("/search?name=<product>") 
		public Map <String, String> ProductDetail(@RequestBody MultiValueMap<String, String> searchProductbyName) {
	    	Map <String, String> searchProductResponse=new HashMap<>();
	    	Product productfound= findProductByNameService.findProductByName(searchProductbyName.get("productName").get(0));
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
