package com.infocave.blog.models;

public class UserLoginModel {
	private String email;
	private String password;

	public UserLoginModel() {
		super();
	}

	public UserLoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "UserLoginModel [email=" + email + ", password=" + password + "]";
	}

}
