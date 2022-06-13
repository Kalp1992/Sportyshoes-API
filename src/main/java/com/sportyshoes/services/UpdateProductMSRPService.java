package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;
import com.sportyshoes.repositories.ProductRepository;

@Service
public class UpdateProductMSRPService {
	@Autowired
    private ProductRepository productRepository;
	public Boolean UpdateProductMSRP(Integer productId) {
		Product product= new Product(productId);
		try {
			return productRepository.updateProductMSRP(product)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	 }
}
