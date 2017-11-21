package com.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private Map<String,User> userDetailsMap=new HashMap<>();
	private static long count=0;
	
	@Override
	public User addUser(User user) {
		String userId=String.valueOf(++count);
		user.setUserId(userId);
		userDetailsMap.put(userId, user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User persistedUserObj=userDetailsMap.get(user.getUserId());
		persistedUserObj.setDateOfBirth(user.getDateOfBirth());
		persistedUserObj.setAddress(user.getAddress());
		return persistedUserObj;
	}

	@Override
	public User deleteUser(String userId) {
		User user=userDetailsMap.get(userId);
		user.setDeleted(true);
		return user;
		 
	}

	@Override
	public List<User> getAllUser() {
		List<User> users=new ArrayList<>();
		userDetailsMap.values().forEach(action -> users.add(action));
		return users;
	}

	@Override
	public boolean isUserExist(String emailId) {
		
		for (Map.Entry<String, User> userEntryObj : userDetailsMap.entrySet())
		{
			if(emailId.equalsIgnoreCase(userEntryObj.getValue().getEmailId()) && userEntryObj.getValue().isDeleted()==false ){
				return true;
			}
			
		}
		return false;
		
	}

}
