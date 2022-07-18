package com.sa.displayvideo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sa.mongo.dao.LessonDAO;
import com.sa.mongo.model.Lessons;

@SpringBootTest
public class LessonDAOTest {
	
	@Autowired
	LessonDAO dao;
	
	Lessons lesson;
	
	@Test
	public void findsByExampleTest() {
		
		lesson = dao.findByLessonId(1);
		System.out.println(" ");

		assertEquals(1, lesson.getLessonId());
	}
	
    @Test
    public void shouldBeNotEmpty() {
    	List <Lessons> list = new ArrayList<Lessons>();
    	list = 		dao.findAll();
        assertTrue(!list.isEmpty());
    }

}
