package com.infocave.blog.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infocave.blog.models.UserListResponse;
import com.infocave.blog.models.UserLoginModel;
import com.infocave.blog.models.UserModel;
import com.infocave.blog.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get/all")
	public UserListResponse getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/get/{userId}")
	public Optional<UserModel> getUser(@PathVariable("userId") Long userId) throws Exception {
		return userService.getUser(userId);
	}
	
	@PostMapping("/add")
	public UserModel addUser(@RequestBody UserModel user) throws Exception {
		return userService.add(user);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserLoginModel userLogin) throws Exception {
		return userService.login(userLogin);
	}
	
	@DeleteMapping("/delete/{userId}")
	public Map<String, String> deleteUser(@PathVariable("userId") Long userId) throws Exception {
		return userService.deleteUser(userId);
	}

}
