package com.sa.mongo.service;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;
import com.sa.mongo.model.UserAccessReturnObject;


public interface UserService {
	
	public UserAccessReturnObject registerNewUser(User user);
	public UserAccessReturnObject findUserByUserNameAndPassword (Student student);
	public UserAccessReturnObject addTutor(User tutor);
	public Tutor findTutorByTutorId (String tutorId);
	
}
