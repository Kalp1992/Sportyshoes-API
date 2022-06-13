package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the user")
public class User {

	@ApiModelProperty(notes="The unique userId of the user")
	Integer userId;
	@ApiModelProperty(notes="The username of the user")
	String username;
	@ApiModelProperty(notes="The password of the user")
	String password;
	@ApiModelProperty(notes="The name of the user")
	String name;
	public User() {
		super();
	}
	public User(Integer userId, String username, String password, String name) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name=name;
	}
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(Integer userId) {
		super();
		this.userId = userId;
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ",name= "+ name +"]";
	}
	
}
