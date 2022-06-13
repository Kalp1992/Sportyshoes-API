package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the product")
public class Product {
	@ApiModelProperty(notes="The unique productId of the product")
    Integer productId;
	@ApiModelProperty(notes="The name of the product")
    String productName;
	@ApiModelProperty(notes="The MSRP of the product")
    Double MSRP;
	@ApiModelProperty(notes="The quantinty in stock of the product")
    Integer quantityInStock;
	@ApiModelProperty(notes="The product vendor ")
    String productVendor;
	public Product() {
		super();
	}
	
	public Product(Integer productId) {
		super();
		this.productId = productId;
	}
	

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Product(Double mSRP) {
		super();
		MSRP = mSRP;
	}

	public Product(Integer productId, String productName, Double mSRP, Integer quantityInStock, String productVendor) {
		super();
		this.productId = productId;
		this.productName = productName;
		MSRP = mSRP;
		this.quantityInStock = quantityInStock;
		this.productVendor = productVendor;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getMSRP() {
		return MSRP;
	}
	public void setMSRP(Double mSRP) {
		MSRP = mSRP;
	}
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", MSRP=" + MSRP
				+ ", quantityInStock=" + quantityInStock + ", productVendor=" + productVendor + "]";
	}
      
}
