package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportyshoes.models.Product;

import com.sportyshoes.repositories.ProductRepository;

@Service
public class GetAllProductService {
	 @Autowired
     private ProductRepository productRepository;
	 public  ArrayList<Product> GetallProduct() {
			Product product= new Product();
			try {
				return productRepository.findAllProduct();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			 
		 }
}
