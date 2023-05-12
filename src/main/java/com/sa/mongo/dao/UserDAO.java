package com.sa.mongo.dao;

import com.sa.mongo.model.Student;
import com.sa.mongo.model.User;


public interface UserDAO  {

	User findByUserName(String userName);
	User saveUser(User user);
	User findUserByUserNameAndPassword(Student student);

} 


