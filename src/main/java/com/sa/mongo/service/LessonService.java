package com.sa.mongo.service;

import com.sa.mongo.model.Lessons;

public interface LessonService {
	
	public Lessons getLessonByContentId(long id);
	
	public Lessons findItemByLessonTilte(String title);

}
