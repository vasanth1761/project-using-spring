package com.spring.demo.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDetails {
	public UserDetails(String userName, String password, String email,int id) {
		super();
		this.id=id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public UserDetails() {
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String userName;
	String password;
	String email;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}


