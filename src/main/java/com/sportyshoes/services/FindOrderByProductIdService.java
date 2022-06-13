package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Order;

import com.sportyshoes.repositories.OrderRepository;


@Service
public class FindOrderByProductIdService {
	 @Autowired
     private OrderRepository orderRepository;
	 public Order findOrderByProductId(Integer productId) {
			Order order= new Order(productId);
			try {
				return orderRepository.findOrderByProductId(productId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
