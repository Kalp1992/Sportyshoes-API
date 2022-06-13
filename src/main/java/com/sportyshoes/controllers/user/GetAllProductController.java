package com.sportyshoes.controllers.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Order;
import com.sportyshoes.models.Product;

import com.sportyshoes.services.GetAllProductService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class GetAllProductController {
	 @Autowired
		private GetAllProductService getAllProductService;
	 @GetMapping("/all") 
	 @ResponseBody
	 public List ProductDetail() {
		 List<Product> allProduct=getAllProductService.GetallProduct();
		return allProduct;
	 }	
//		public Map <String, String> ProductDetail(@RequestBody MultiValueMap<String, String> AllProductDetail) {
//	    	Map <String, String> AllProductResponse=new HashMap<>();
//	    	ArrayList<Product> allProduct= getAllProductService.GetallProduct();
//	    		if(allProduct != null) {
//	    		AllProductResponse.put("status", "true");
//	    		AllProductResponse.put("massege", "All product found ");
//		      }else {
//		    	  AllProductResponse.put("status", "false");
//		    	  AllProductResponse.put("massege", "Product not found");
//		      }
//	      return  AllProductResponse;
//		  
//	    
//	    }
}
