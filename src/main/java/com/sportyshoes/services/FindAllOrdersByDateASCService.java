package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Order;

import com.sportyshoes.repositories.OrderRepository;
;

@Service
public class FindAllOrdersByDateASCService {
	 @Autowired
     private OrderRepository orderRepository;
	 public  ArrayList<Order> GetallOrderByDateASC() {
			Order order= new Order();
			try {
				return orderRepository.findAllOrdersByDateASC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			 
		 }
}
