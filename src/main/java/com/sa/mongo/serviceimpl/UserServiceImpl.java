package com.sa.mongo.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.UserDAO;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.User;
import com.sa.mongo.model.UserAccessReturnObject;
import com.sa.mongo.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;


	@Override
	public UserAccessReturnObject registerNewUser(User user) {
		
		UserAccessReturnObject userAccessObject = new UserAccessReturnObject();
		
		// assign username to unique userid
		user.setUserId(user.getUserName());
		
		// check if user already exists
		User verifyUser = userDAO.findByUserName(user.getUserName());
		if (verifyUser != null && verifyUser.getUserName().equalsIgnoreCase(user.getUserName())) {
			userAccessObject.setMsgReturned("User name Exists. Please try another");
			userAccessObject.setStudent(null);
			userAccessObject.setLoginSuccess(true);
			
			return userAccessObject;
		}
				
		try {
			User savedUser = userDAO.saveUser(user);
			if (savedUser != null) {
				userAccessObject.setMsgReturned("Registration Successful");
				userAccessObject.setStudent(null);
				userAccessObject.setLoginSuccess(true);
			}
		}
		catch(Exception e) {
			System.out.println();
		}
		
		return userAccessObject;
	}

	@Override
	public UserAccessReturnObject findUserByUserNameAndPassword(Student student) {
		
		UserAccessReturnObject userAccessObject = new UserAccessReturnObject();
		
		User user = userDAO.findUserByUserNameAndPassword(student);
		
		if (user != null) {
			
			Student s = new Student();
			s.setCourse(user.getCourse());
			s.setEmail(user.getEmail());
			s.setFirstName(user.getFirstName());
			s.setLastName(user.getLastName());
			s.setUserId(user.getUserId());
			s.setUserName(user.getUserName());
			
			userAccessObject.setLoginSuccess(true);
			userAccessObject.setStudent(s);
		} else {
			userAccessObject.setMsgReturned("No User found");
		}
		
		return userAccessObject;
	}
	

}
