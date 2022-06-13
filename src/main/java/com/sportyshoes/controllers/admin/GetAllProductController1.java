package com.sportyshoes.controllers.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;

import com.sportyshoes.services.GetAllProductService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/admin")
public class GetAllProductController1 {
	 @Autowired
		private GetAllProductService getAllProductService;
	 @GetMapping("/product/all") 
	 public List ProductDetail() {
		 List<Product> allProduct=getAllProductService.GetallProduct();
		return allProduct;
	 }
//		public Map <String, String> ProductDetail(@RequestBody MultiValueMap<String, String> AllProductDetail) {
//	    	Map <String, String> AllProductResponse=new HashMap<>();
//	    	ArrayList<Product> allProduct= getAllProductService.GetallProduct();
//	      
//	      return  AllProductResponse;
//		  
//	    
//	    }
}
