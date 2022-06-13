package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sportyshoes.models.Order;
import com.sportyshoes.models.User;



public interface OrderDao {
	Integer createOrder(Order order) throws SQLException;
	
	ArrayList<Order> findAllOrdersByDateASC() throws SQLException;
	
	ArrayList<Order> findAllOrdersByDateDESC() throws SQLException;
	
	ArrayList<Order> findAllOrdersByOrderIdASC() throws SQLException;
	
	ArrayList<Order> findAllOrdersByOrderIdDESC() throws SQLException;
	
	Order findOrderByProductId(Integer productId) throws SQLException ;
	
	Order findOrderByUserId(Integer userId) throws SQLException ;
	
}
