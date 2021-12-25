package com.cl.javaproject.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotNull
	@Size(min=8, max=50, message="Password must be between 8-50 characters!")
	private String password;
	
	///// Constructor
	public LoginUser() {
		
	}
	
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	///// Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

