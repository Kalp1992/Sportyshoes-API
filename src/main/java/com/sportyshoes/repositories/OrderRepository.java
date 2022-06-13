package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.OrderDao;
import com.sportyshoes.models.Order;
import com.sportyshoes.models.Product;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class OrderRepository implements OrderDao{
	 @Autowired
     private DatabaseConnection connection;
	
	 @Override
		public Integer createOrder(Order order) throws SQLException {
		 String insertOrderFormat = "INSERT INTO orders (ORDER_ID, REF_PRODUCT_ID, DATE, REF_USER_ID) VALUES ( ?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertOrderFormat);) {
				preparedStatement.setInt(1, order.getOrderId());
				preparedStatement.setInt(2, order.getProductId());
				preparedStatement.setDate(3, order.getDate());
				preparedStatement.setInt(4, order.getUserId());
								
				return preparedStatement.executeUpdate();
			}
		}




		@Override
		public ArrayList<Order> findAllOrdersByDateASC() throws SQLException {
			String getOrdersFormat = "SELECT *FROM orders ORDER BY DATE ASC";
			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
				ResultSet rs = preparedStatement.executeQuery();
				ArrayList<Order> orders = new ArrayList<>();

				if (!rs.isBeforeFirst()) {
					return orders;
				}

				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("ORDER_ID"));
					order.setProductId(rs.getInt("REF_PRODUCT_ID"));
					order.setDate(rs.getDate("DATE"));
					order.setUserId(rs.getInt("REF_USER_ID"));
					
					
					orders.add(order);
				}

				return orders;
				}
		}




		@Override
		public ArrayList<Order> findAllOrdersByDateDESC() throws SQLException {
			String getOrdersFormat = "SELECT *FROM orders ORDER BY DATE DESC";
			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
				ResultSet rs = preparedStatement.executeQuery();
				ArrayList<Order> orders = new ArrayList<>();

				if (!rs.isBeforeFirst()) {
					return orders;
				}

				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("ORDER_ID"));
					order.setProductId(rs.getInt("REF_PRODUCT_ID"));
					order.setDate(rs.getDate("DATE"));
					order.setUserId(rs.getInt("REF_USER_ID"));
					
					
					orders.add(order);
				}

				return orders;
				}
		
		}




		@Override
		public ArrayList<Order> findAllOrdersByOrderIdASC() throws SQLException {
			String getOrdersFormat = "SELECT *FROM orders ORDER BY ORDER_ID ASC";
			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
				ResultSet rs = preparedStatement.executeQuery();
				ArrayList<Order> orders = new ArrayList<>();

				if (!rs.isBeforeFirst()) {
					return orders;
				}

				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("ORDER_ID"));
					order.setProductId(rs.getInt("REF_PRODUCT_ID"));
					order.setDate(rs.getDate("DATE"));
					order.setUserId(rs.getInt("REF_USER_ID"));
					
					
					orders.add(order);
				}

				return orders;
				}
		}




		@Override
		public ArrayList<Order> findAllOrdersByOrderIdDESC() throws SQLException {
			String getOrdersFormat = "SELECT *FROM orders ORDER BY ORDER_ID DESC";
			try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
				ResultSet rs = preparedStatement.executeQuery();
				ArrayList<Order> orders = new ArrayList<>();

				if (!rs.isBeforeFirst()) {
					return orders;
				}

				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("ORDER_ID"));
					order.setProductId(rs.getInt("REF_PRODUCT_ID"));
					order.setDate(rs.getDate("DATE"));
					order.setUserId(rs.getInt("REF_USER_ID"));
					
					
					orders.add(order);
				}

				return orders;
				}
		}

	
	

	@Override
	public Order findOrderByProductId(Integer productId) throws SQLException {
		String getOrderFormat = "SELECT *FROM orders WHERE  REF_PRODUCT_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrderFormat);) {
			preparedStatement.setInt(1, productId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}
			Order order = new Order();
			while (rs.next()) {
			order.setOrderId(rs.getInt("ORDER_ID"));
			order.setProductId(rs.getInt("REF_PRODUCT_ID"));
			order.setDate(rs.getDate("DATE"));
			order.setUserId(rs.getInt("REF_USER_ID"));
				
			}
			return order;
		}
	}


	@Override
	public Order findOrderByUserId(Integer userId) throws SQLException {
		String getOrderFormat = "SELECT *FROM orders WHERE REF_USER_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrderFormat);) {
			preparedStatement.setInt(1, userId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}
			Order order = new Order();
			while (rs.next()) {
			order.setOrderId(rs.getInt("ORDER_ID"));
			order.setProductId(rs.getInt("REF_PRODUCT_ID"));
			order.setDate(rs.getDate("DATE"));
			order.setUserId(rs.getInt("REF_USER_ID"));
				
			}
			return order;
		}
	}





	
}
