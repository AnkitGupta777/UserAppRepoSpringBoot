package com.user.dao;

import java.util.List;

import com.user.model.User;

public interface UserDao {
	 User addUser(User user);
	 User updateUser(User user);
	 User deleteUser(String userId);
	 List<User> getAllUser();
	 boolean isUserExist(String emailId);
}
