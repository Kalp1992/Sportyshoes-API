package com.sportyshoes.controllers.user;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Order;
import com.sportyshoes.models.Product;
import com.sportyshoes.services.FindOrderByProductIdService;
import com.sportyshoes.services.FindOrderByUserIdService;
import com.sportyshoes.services.FindProductByProductIdService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class ViewUserAllOrdersController {
	@Autowired
	private FindOrderByUserIdService findOrderByUserIdService;
 @GetMapping("/{userId}/order/all") 
	public Map <String, String> FindProduct(@RequestBody MultiValueMap<String, String> searchOrdertbyUserId) {
    	Map <String, String> searchOrderResponse=new HashMap<>();
    	Order orderfound= findOrderByUserIdService.findOrderByUserId(Integer.parseInt(searchOrdertbyUserId.get("userId").get(0)));
      if(orderfound != null) {
    	  searchOrderResponse.put("status", "true");
    	  searchOrderResponse.put("massege", "Order found");
      }else {
    	  searchOrderResponse.put("status", "false");
    	  searchOrderResponse.put("massege", "Order not found");
      }
      return  searchOrderResponse;
	  
    
    }
}
