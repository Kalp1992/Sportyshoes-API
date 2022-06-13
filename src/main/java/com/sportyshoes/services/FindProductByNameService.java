package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;

import com.sportyshoes.repositories.ProductRepository;


@Service
public class FindProductByNameService {
	 @Autowired
     private ProductRepository productRepository;
	 public Product findProductByName(String productName) {
			Product product= new Product(productName);
			try {
				return productRepository.findProductByName(productName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			 
		 }
}
