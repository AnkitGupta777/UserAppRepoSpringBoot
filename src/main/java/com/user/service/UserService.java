package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
	 User addUser(User user);
	 User updateUser(User user);
	 User deleteUser(String userId);
	 List<User> getAllUser();
	
}
