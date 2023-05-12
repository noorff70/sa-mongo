package com.sa.mongo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sa.mongo.model.Course;

@Repository
public interface CourseDAO {
	

	List<Course> getCourseListByCourseDesc(String desc);
	Course getCourseByCourseId(long courseId);
	
}
