package com.sa.mongo.service;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;
import com.sa.mongo.model.APIResponseObject;


public interface UserService {
	
	public APIResponseObject registerNewUser(User user);
	public APIResponseObject findUserByUserNameAndPassword (Student student);
	public APIResponseObject addTutor(User tutor);
	public Tutor findTutorByTutorId (String tutorId);
	
}
