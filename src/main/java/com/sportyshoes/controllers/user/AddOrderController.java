package com.sportyshoes.controllers.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.ProductService;

import io.swagger.models.properties.StringProperty.Format;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user/{userId}")
public class AddOrderController {
	@Autowired
	  private OrderService orderService;
	
	    @PostMapping("/product/{productId}/order") 
		public Map <String, String> AddOrderByProductId(@RequestBody MultiValueMap<String, String> newOrderDetails) {
	    	Map <String, String> addOrderResponse=new HashMap<>();
	    	@SuppressWarnings("deprecation")
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Boolean orderAdded;
			try {
				orderAdded = orderService.AddOrder(Integer.parseInt(newOrderDetails.get("orderId").get(0)),Integer.parseInt(newOrderDetails.get("productId").get(0)),formatter.parse(newOrderDetails.get("date").get(0)), Integer.parseInt(newOrderDetails.get("userId").get(0)));
				 if(orderAdded) {
			    	  addOrderResponse.put("status", "True");
			    	  addOrderResponse.put("massege", "Order added successfully");
			      }else {
			    	  addOrderResponse.put("status", "False");
			    	  addOrderResponse.put("massege", "Order not added");
			      }
			     
			} catch (NumberFormatException | ParseException e) {
				
				e.printStackTrace();
			} return  addOrderResponse;
			}}
	     

