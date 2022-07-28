package com.sa.mongo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.LessonDAO;
import com.sa.mongo.dao.WebCourseDAO;
import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.service.MongoService;


@Service("mongoService")
public class MongoServiceImpl implements MongoService{

	@Autowired
	private LessonDAO lessonDAO;
	
	@Autowired
	private WebCourseDAO webCourseDAO;
	

	@Override
	public Lessons getLessonByContentId(long id) {
		return lessonDAO.findByLessonId(id);
	}


	@Override
	public Lessons findItemByLessonTilte(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WebCourse getWebCourseList(String desc) {
		return webCourseDAO.findByName(desc);
	}


}
