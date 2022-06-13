package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.ProductDao;

import com.sportyshoes.models.Product;

import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class ProductRepository implements ProductDao{
	 @Autowired
     private DatabaseConnection connection;

	@Override
	public Integer createProduct(Product product) throws SQLException {
		String insertProductFormat = "INSERT INTO products (PRODUCT_ID, PRODUCT_NAME, MSRP, QUANITY_IN_STOCK, PRODUCT_VENDOR) VALUES ( ?, ?, ?, ?, ?  )";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertProductFormat);) {
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getMSRP());
			preparedStatement.setInt(4, product.getQuantityInStock());
			preparedStatement.setString(5, product.getProductVendor());
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Product findProductByName(String productName) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
		String getProductFormat = "SELECT *FROM products WHERE  PRODUCT_NAME = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductFormat);) {
			preparedStatement.setString(1, productName);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Product product = new Product();
			while (rs.next()) {
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setProductName(rs.getString("PRODUCT_NAME"));
				product.setMSRP(rs.getDouble("MSRP"));
				product.setQuantityInStock(rs.getInt("QUANTITY_IN_STOCK"));
				product.setProductVendor(rs.getString("PRODUCT_VENDOR"));
				
			}
			return product;
		}
	}

	@Override
	public Product findProductByProductId(Integer productId) throws SQLException {
		String getProductFormat = "SELECT *FROM products WHERE  PRODUCT_ID = ? ";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductFormat);) {
			preparedStatement.setInt(1, productId);
		    ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Product product = new Product();
			while (rs.next()) {
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setProductName(rs.getString("PRODUCT_NAME"));
				product.setMSRP(rs.getDouble("MSRP"));
				product.setQuantityInStock(rs.getInt("QUANTITY_IN_STOCK"));
				product.setProductVendor(rs.getString("PRODUCT_VENDOR"));
				
			}
			return product;
		}
	
	}

	@Override
	public ArrayList<Product> findAllProduct() throws SQLException {
		String getProductsFormat = "SELECT *FROM products";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductsFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<Product> products = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return products;
			}

			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setProductName(rs.getString("PRODUCT_NAME"));
				product.setMSRP(rs.getDouble("MSRP"));
				product.setQuantityInStock(rs.getInt("QUANTITY_IN_STOCK"));
				product.setProductVendor(rs.getString("PRODUCT_VENDOR"));
				
				
				products.add(product);
			}

			return products;
			}
	}

	@Override
	public Integer updateProductName(Product product) throws SQLException {
		String updateProductNameFormat = "UPDATE products SET  PRODUCT_NAME = ?, WHERE  PRODUCT_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateProductNameFormat);) {
			preparedStatement.setString(1, product.getProductName());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateProductMSRP(Product product) throws SQLException {
		String updateMSRPFormat = "UPDATE products SET  MSRP = ?, WHERE  PRODUCT_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateMSRPFormat);) {
			preparedStatement.setDouble(1, product.getMSRP());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateQuantityInStock(Product product) throws SQLException {
		String updateuantityInStockFormat = "UPDATE products SET QUANITY_IN_STOCK = ?, WHERE  PRODUCT_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateuantityInStockFormat);) {
			preparedStatement.setInt(1, product.getQuantityInStock());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateProductVendor(Product product) throws SQLException {
		String updateProductVendorFormat = "UPDATE products SET  PRODUCT_VENDOR = ?, WHERE  PRODUCT_ID = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateProductVendorFormat);) {
			preparedStatement.setString(1, product.getProductVendor());
		
			
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer deleteProductByProductId(Integer productId) throws SQLException {
		String deleteProductFormat = " DELETE FROM products WHERE PRODUCT_ID = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteProductFormat);) {
			preparedStatement.setInt(1, productId);
			return preparedStatement.executeUpdate();
		}
	}
	

}
