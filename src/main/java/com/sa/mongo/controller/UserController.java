package com.sa.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mongo.model.RequestObject;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	/*
	 * get user by username and password
	 */
	@PostMapping("/mongo/login/findUserByUserNameAndPassword")
	public APIResponseObject findUserByUserNameAndPassword (@RequestBody Student student) {
		
		APIResponseObject  userStudent = userService.findUserByUserNameAndPassword(student);
		
		return userStudent;
	}
	
	@PostMapping("/mongo/findTutorByTutorId")
	public Tutor findTutorByTutorId (@RequestBody RequestObject req) {
		
		Tutor  t = userService.findTutorByTutorId(req.getTutorId());
		
		return t;
	}
	
	
	// add a new student
	@PostMapping("/mongo/registration/registerNewUser")
	public APIResponseObject registerNewUser(@RequestBody Student student) {
		
		APIResponseObject userAccessObject = new APIResponseObject();
		
		User user = student;

		userAccessObject = userService.registerNewUser(user);
		
		return userAccessObject;
		
	}
	
	// add a tutor- postman only
	@PostMapping("/mongo/registration/addTutor")
	public APIResponseObject addTutor(@RequestBody Tutor tutor) {
		
		APIResponseObject userAccessObject = new APIResponseObject();
		
		User user = tutor;
		
		userAccessObject = userService.addTutor(user);
		
		return userAccessObject;
	
	}
	
}
