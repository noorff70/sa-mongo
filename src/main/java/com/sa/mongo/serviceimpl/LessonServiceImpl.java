package com.sa.mongo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.LessonDAO;
import com.sa.mongo.model.Lessons;
import com.sa.mongo.service.LessonService;


@Service("lessonService")
public class LessonServiceImpl implements LessonService{

	@Autowired
	private LessonDAO lessonDAO;
	

	@Override
	public Lessons getLessonByContentId(long id) {
		return lessonDAO.findByLessonId(id);
	}


	@Override
	public Lessons findItemByLessonTilte(String title) {
		// TODO Auto-generated method stub
		return null;
	}


}
