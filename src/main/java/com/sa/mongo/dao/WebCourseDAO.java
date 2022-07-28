package com.sa.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.WebCourse;

@Repository
public interface WebCourseDAO extends MongoRepository<WebCourse, String> {

	//Lessons findByLessonId(long lessonId);
	//List<WebCourse> getWebCourseList(String desc);
	WebCourse findByName(String desc);
}
