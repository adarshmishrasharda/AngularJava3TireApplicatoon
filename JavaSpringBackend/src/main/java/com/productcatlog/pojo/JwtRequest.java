package com.productcatlog.pojo;

public class JwtRequest {
	
	String username;
	String password;
	
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + "]";
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
	

}
