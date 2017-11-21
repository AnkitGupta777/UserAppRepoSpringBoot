package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		boolean isUserExist=userDao.isUserExist(user.getEmailId());
		if(isUserExist){
			user.setUserDuplicate(true);
			return user;
		}else{
			return userDao.addUser(user);
		}
		
		
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
}
