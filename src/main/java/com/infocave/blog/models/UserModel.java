package com.infocave.blog.models;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public UserModel() {
		super();
	}

	public UserModel(Long userId, String name, String authorName, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.authorName = authorName;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserModel(String name, String authorName, String email, String password) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", name=" + name + ", authorName=" + authorName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
