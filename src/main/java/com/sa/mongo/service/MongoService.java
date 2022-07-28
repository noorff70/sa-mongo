package com.sa.mongo.service;

import java.util.List;

import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.WebCourse;

public interface MongoService {
	
	public Lessons getLessonByContentId(long id);
	
	public Lessons findItemByLessonTilte(String title);
	
	public WebCourse getWebCourseList(String desc);

}
