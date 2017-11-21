package com.user.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.APIResponse;
import com.user.model.User;
import com.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> addUser( @RequestBody  User user) {
		User updateUser = userService.addUser(user);
		APIResponse aPIResponse=new APIResponse();
		aPIResponse.setUserDetails(Arrays.asList(updateUser));
		if (updateUser.isUserDuplicate()) {
			aPIResponse.setMessage("UserId is already exist with the same emailId");
			aPIResponse.setStatusCode(HttpStatus.CONFLICT.toString());
			return new ResponseEntity<APIResponse>(aPIResponse, HttpStatus.CONFLICT);
		} else {
			aPIResponse.setStatusCode(HttpStatus.CREATED.toString());
			aPIResponse.setMessage("User Created Successfully");
			return new ResponseEntity<APIResponse>(aPIResponse, HttpStatus.CREATED);
		}

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<APIResponse> updateUser( @RequestBody User user) {
		APIResponse aPIResponse=new APIResponse();
		User updateUser = userService.updateUser(user);
		aPIResponse.setUserDetails(Arrays.asList(updateUser));
		aPIResponse.setMessage("User Updated Successfully");
		aPIResponse.setStatusCode(HttpStatus.ACCEPTED.toString());
		return new ResponseEntity<APIResponse>(aPIResponse, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<APIResponse> getAllUsers() {
		APIResponse aPIResponse=new APIResponse();
		List<User> users = userService.getAllUser();
		aPIResponse.setUserDetails(users);
		aPIResponse.setStatusCode(HttpStatus.OK.toString());
		return new ResponseEntity<APIResponse>(aPIResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public ResponseEntity<APIResponse> deleteUser(String userId) {
		APIResponse aPIResponse=new APIResponse();
		User updateUser = userService.deleteUser(userId);
		aPIResponse.setUserDetails(Arrays.asList(updateUser));
		aPIResponse.setMessage("User Deleted Successfully");
		aPIResponse.setStatusCode(HttpStatus.OK.toString());
		return new ResponseEntity<APIResponse>(aPIResponse, HttpStatus.OK);

	}
}
