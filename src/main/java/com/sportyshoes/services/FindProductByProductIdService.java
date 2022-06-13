package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;
import com.sportyshoes.repositories.ProductRepository;

@Service
public class FindProductByProductIdService {
	 @Autowired
     private ProductRepository productRepository;
	 public Product findProductByProductId(Integer productId) {
			Product product= new Product(productId);
			try {
				return productRepository.findProductByProductId(productId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
