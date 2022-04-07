package com.infocave.blog.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infocave.blog.models.UserListResponse;
import com.infocave.blog.models.UserLoginModel;
import com.infocave.blog.models.UserModel;
import com.infocave.blog.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;
	
	// Gets all user detail
	public UserListResponse getAll() {
		List<UserModel> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		UserListResponse response = new UserListResponse(users);
		logger.info("Getting all users from DB");
		return response;
	}
	
	// Gets a single user
	public Optional<UserModel> getUser(Long userId) throws Exception {
		try {
			logger.info("Getting user " + userId + " from DB");
			return userRepo.findById(userId);
		} catch (Exception e) {
			throw new Exception("Something went wrong : " + e.getMessage());
		}
	}
	
	// Adds a new user
	public UserModel add(UserModel user) throws Exception {
		try {
			logger.info("Adding user to DB");
			return userRepo.save(user);
		} catch (Exception e) {
			throw new Exception("Something went wrong : " + e.getMessage());
		}
	}

	// Login with email and password
	public boolean login(UserLoginModel userLogin) throws Exception {
		try {
			String encodedUserPassword = Base64.getEncoder().encodeToString(userLogin.getPassword().getBytes());
			Optional<UserModel> user = userRepo.login(encodedUserPassword, userLogin.getEmail());
			
			if(user.isPresent()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception("Something went wrong : " + e.getMessage());
		}
	}
	
	// Deletes a user using user id
	public Map<String, String> deleteUser(Long userId) throws Exception {
		try {
			logger.info("Deleted user with userId " + userId);
			userRepo.deleteById(userId);
			Map<String, String> data = new HashMap<>();
			data.put("message", "user with id " + userId + " deleted");
			
			return data;
		} catch (Exception e) {
			throw new Exception("Something went wrong : " + e.getMessage());
		}
	}
}



