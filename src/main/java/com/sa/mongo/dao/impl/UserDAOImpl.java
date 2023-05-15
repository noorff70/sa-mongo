package com.sa.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sa.mongo.dao.UserDAO;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.Tutor;
import com.sa.mongo.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;


	public User findByUserName(String userName) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		
		User user = mongoTemplate.findOne(query, User.class);
		
		return user;
		
	}

	@Override
	public User findUserByUserNameAndPassword(Student student) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(student.getUserName()).and("password").is(student.getPassword()));        
		
		User user = mongoTemplate.findOne(query, User.class);
		
		return user;
	}
	
	public User saveUser (User user) {
		try {
			mongoTemplate.save(user);
			//mongoTemplate.save(user);
		} catch(Exception e) {
			return null;
		}
	
		return user;
		
	}

	@Override
	public Tutor findTutorByTutorId(String tutorId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(tutorId)); 
		
		User user = mongoTemplate.findOne(query, User.class);
		return (Tutor) user;

	}

}
