package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.AdminService;
import com.sportyshoes.services.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class AddProductController {
	@Autowired
	  private ProductService productService;
	
	    @PostMapping("/add") 
		public Map <String, String> signUp(@RequestBody MultiValueMap<String, String> newProductDetails) {
	    	Map <String, String> addProductResponse=new HashMap<>();
	    	Boolean productAdded= productService.AddProduct(Integer.parseInt(newProductDetails.get("productId").get(0)),newProductDetails.get("productName").get(0), Double.parseDouble(newProductDetails.get("MSRP").get(0)),Integer.parseInt(newProductDetails.get("quantityInStock").get(0)),newProductDetails.get("productVendor").get(0));
	      if(productAdded) {
	    	  addProductResponse.put("status", "True");
	    	  addProductResponse.put("massege", "Product added successfully");
	      }else {
	    	  addProductResponse.put("status", "False");
	    	  addProductResponse.put("massege", "Product not added");
	      }
	      return  addProductResponse;
}
}