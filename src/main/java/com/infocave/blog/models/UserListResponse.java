package com.infocave.blog.models;

import java.util.List;

public class UserListResponse {
	private List<UserModel> users;

	public UserListResponse(List<UserModel> users) {
		super();
		this.users = users;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

}
