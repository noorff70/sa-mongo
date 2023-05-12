package com.sa.mongo.dao.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sa.mongo.dao.CourseDAO;
import com.sa.mongo.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Course> getCourseListByCourseDesc(String desc) {
	
		Query query = new Query();
		Criteria criteria = Criteria.where("courseDesc").regex(desc, "i");
		query.addCriteria(criteria);
		List<Course> courseList = mongoTemplate.find(query, Course.class);
		
		return courseList;
	}
	
	public Course getCourseByCourseId(long courseId) {
			
		Query query = new Query();
		Criteria criteria = Criteria.where("courseId").is(courseId);
		query.addCriteria(criteria);
		
		Course course = mongoTemplate.findOne(query, Course.class);
		
		return course;
		
	}

}
