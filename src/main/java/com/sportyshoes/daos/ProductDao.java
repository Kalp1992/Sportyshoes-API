package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sportyshoes.models.Admin;
import com.sportyshoes.models.Product;

public interface ProductDao {
	// Create Operation
				Integer createProduct(Product product) throws SQLException ;
				
				// Read/Retrieve Operations
				Product findProductByName(String productName) throws SQLException ;
				
				Product findProductByProductId(Integer productId) throws SQLException ;
				
				
				ArrayList<Product> findAllProduct() throws SQLException;
				
				// Update Operations
				Integer updateProductName(Product product) throws SQLException ;
				
				Integer updateProductMSRP(Product product) throws SQLException;
				
				Integer updateQuantityInStock(Product product) throws SQLException;
				
				Integer updateProductVendor(Product product) throws SQLException;
				// Delete Operations
				Integer deleteProductByProductId(Integer productId) throws SQLException;

}
