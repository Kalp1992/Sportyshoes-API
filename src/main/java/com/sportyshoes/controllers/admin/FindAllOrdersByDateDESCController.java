package com.sportyshoes.controllers.admin;

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

import com.sportyshoes.services.FindAllOrdersByDateDESCService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/order")
public class FindAllOrdersByDateDESCController {
	 @Autowired
		private FindAllOrdersByDateDESCService FindAllOrdersByDateDESCService;
	 @GetMapping("/all/orderDate&orderingDESC") 
	// @ResponseBody
	 public List orderDetail() {
		 List<Order> allOrder=FindAllOrdersByDateDESCService.GetallOrderByDateDESC();
		return allOrder;
	 }	
//		public Map <String, String> orderDetail(@RequestBody MultiValueMap<String, String> AllOrderDetail) {
//	    	Map <String, String> AllOrderResponse=new HashMap<>();
//	    	ArrayList<Order> allOrder= FindAllOrdersByDateDESCService.GetallOrderByDateDESC();
//	    	if(allOrder != null) {
//	    		AllOrderResponse.put("status", "true");
//	    		AllOrderResponse.put("massege", "All order found ");
//		      }else {
//		    	  AllOrderResponse.put("status", "False");
//		    	  AllOrderResponse.put("massege", "order not found");
//		      }
//	      return  AllOrderResponse;
//	 }	  
}
