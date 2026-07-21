package com.softara.mockker.authentication;

public class LoginRequest {
	private String email;
	private String password;

	LoginRequest(String email, String password){
		this.setEmail(email);
		this.setPassword(password);
	}
	
	LoginRequest(){}

	public String getEmail() {return email;}
	public String getPassword() {return password;}

	public void setEmail(String email) {this.email = email;}
	public void setPassword(String password) {this.password = password;}

}
