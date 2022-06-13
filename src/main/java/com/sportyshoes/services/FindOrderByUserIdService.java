package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Order;
import com.sportyshoes.repositories.OrderRepository;

@Service
public class FindOrderByUserIdService {
	 @Autowired
     private OrderRepository orderRepository;
	 public Order findOrderByUserId(Integer userId) {
			Order order= new Order(userId);
			try {
				return orderRepository.findOrderByUserId(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
