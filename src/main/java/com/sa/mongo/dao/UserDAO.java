package com.sa.mongo.dao;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;
import com.sa.mongo.model.UserAccessReturnObject;


public interface UserDAO  {

	User findByUserName(String userName);
	User saveUser(User user);
	User findUserByUserNameAndPassword(Student student);
	Tutor findTutorByTutorId (String tutorId);
} 


