package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.User;
import com.sa.mongo.model.UserAccessReturnObject;
import com.sa.mongo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	/*
	 * get user by username and password
	 */
	@PostMapping("/mongo/login/findUserByUserNameAndPassword")
	public UserAccessReturnObject findUserByUserNameAndPassword (@RequestBody Student student) {
		
		UserAccessReturnObject  userStudent = userService.findUserByUserNameAndPassword(student);
		
		return userStudent;
	}
	
	
	
	@PostMapping("/mongo/registration/registerNewUser")
	public UserAccessReturnObject registerNewUser(@RequestBody Student student) {
		
		UserAccessReturnObject userAccessObject = new UserAccessReturnObject();
		
		User user1 = student;

		userAccessObject = userService.registerNewUser(user1);
		
		return userAccessObject;
		
	}
	
}
