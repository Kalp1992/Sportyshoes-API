package com.sportyshoes.models;


import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the order")
public class Order {
	@ApiModelProperty(notes="The unique orderId of the order")
    Integer orderId;
	@ApiModelProperty(notes="The unique productId of the product")
    Integer productId;
	@ApiModelProperty(notes="Datetime of purchase of product")
    Date date;
	@ApiModelProperty(notes="The unique userId of the user")
    Integer userId;
	public Order() {
		super();
	}
	
	public Order(Integer productId) {
		super();
		this.productId = productId;
	}

	public Order(Integer orderId, Integer productId, Date date, Integer userId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.date = date;
		this.userId = userId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", date=" + date + ", userId=" + userId + "]";
	}
  
}
