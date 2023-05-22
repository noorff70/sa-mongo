package com.sa.mongo.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.UserDAO;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.service.UserService;
import com.sa.utility.UserType;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;


	@Override
	public APIResponseObject registerNewUser(User user) {
		
		APIResponseObject userAccessObject = new APIResponseObject();
		
		// assign username to unique userid
		user.setUserId(user.getUserName());
		// set user as student
		UserType type = UserType.STUDENT;
		user.setUserType(type.getUserType());
		
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
	public APIResponseObject findUserByUserNameAndPassword(Student student) {
		
		APIResponseObject userAccessObject = new APIResponseObject();
		
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
	
	public Tutor findTutorByTutorId (String tutorId) {
		
		Tutor tutor= userDAO.findTutorByTutorId(tutorId);
		tutor.setPassword(null);
		
		
		return tutor;
	}

	// add tutor postman only
	@Override
	public APIResponseObject addTutor(User tutor) {

		APIResponseObject userAccessObject = new APIResponseObject();
		
		// assign username to unique userid
		tutor.setUserId(tutor.getUserName());
		// set user as student
		UserType type = UserType.TUTOR;
		tutor.setUserType(type.getUserType());
		
		// check if user already exists
		User verifyUser = userDAO.findByUserName(tutor.getUserName());
		if (verifyUser != null && verifyUser.getUserName().equalsIgnoreCase(tutor.getUserName())) {
			userAccessObject.setMsgReturned("User name Exists. Please try another");
			userAccessObject.setStudent(null);
			userAccessObject.setLoginSuccess(true);
			
			return userAccessObject;
		}
				
		try {
			User savedUser = userDAO.saveUser(tutor);
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
	

}
