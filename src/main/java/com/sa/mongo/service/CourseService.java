package com.sa.mongo.service;

import java.util.List;


import com.sa.mongo.model.Course;
import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.UserAccessReturnObject;

public interface CourseService {
	
	public Lessons getLessonByContentId(long id);
	
	public List<Course> getCourseListByCourseDesc(String desc);
	public UserAccessReturnObject addCourseToUser(long courseId, String userName);
	
//	public Course findCourseByCourseName(long courseId);
	
//	public List<Course> findByCourseIds(List<Long> ids);

}
