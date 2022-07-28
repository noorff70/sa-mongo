package com.sa.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sa.mongo.model.Lessons;

@Repository
public interface LessonDAO extends MongoRepository<Lessons, String> {

	Lessons findByLessonId(long lessonId);
	List<Lessons> findAll();
}

