package com.sportyshoes.controllers.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Order;
import com.sportyshoes.services.FindOrderByProductIdService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class ViewOrderByProductIdController {
	@Autowired
	private FindOrderByProductIdService findOrderByProductIdService;
 @GetMapping("/{productId}/order/all") 
	public Map <String, String> FindProduct(@RequestBody MultiValueMap<String, String> searchOrdertbyProductId) {
    	Map <String, String> viewOrderResponse=new HashMap<>();
    	Order orderfound= findOrderByProductIdService.findOrderByProductId(Integer.parseInt(searchOrdertbyProductId.get("productId").get(0)));
      if(orderfound != null) {
    	  viewOrderResponse.put("status", "true");
    	  viewOrderResponse.put("massege", "Order found");
      }else {
    	  viewOrderResponse.put("status", "false");
    	  viewOrderResponse.put("massege", "Order not found");
      }
      return  viewOrderResponse;
	  
    
    }
}
