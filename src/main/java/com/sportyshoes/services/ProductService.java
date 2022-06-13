package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportyshoes.models.Product;

import com.sportyshoes.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Boolean AddProduct(Integer productId,String productName,Double MSRP, Integer quantityInStock,String productVendor ) {
		Product product= new Product(productId, productName, MSRP,quantityInStock,productVendor);
		try {
			return productRepository.createProduct(product)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		 
	 }
}
