package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Order;

import com.sportyshoes.repositories.OrderRepository;


@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Boolean AddOrder(Integer orderId,Integer productId,Date date, Integer userId) {
		Order order= new Order(orderId, productId, (java.sql.Date) date, userId);
		try {
			return orderRepository.createOrder(order)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		 
	 }
}
