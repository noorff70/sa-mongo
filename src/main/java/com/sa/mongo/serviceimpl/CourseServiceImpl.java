package com.sa.mongo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.CourseDAO;
import com.sa.mongo.dao.LessonDAO;
import com.sa.mongo.dao.UserDAO;
import com.sa.mongo.model.Course;
import com.sa.mongo.model.Lessons;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.User;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.service.CourseService;


@Service("courseService")
public class CourseServiceImpl implements CourseService{
	

	@Autowired
	private LessonDAO lessonDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private UserDAO userDAO;
	

	@Override
	public Lessons getLessonByContentId(long id) {
		return lessonDAO.findByLessonId(id);
	}


	@Override
	public List<Course> getCourseListByCourseDesc(String desc ) {
		
		return courseDAO.getCourseListByCourseDesc(desc);
	}
	
	public APIResponseObject addCourseToUser(long courseId, String userName) {
		
		APIResponseObject userAccessObject = new APIResponseObject();
		
		// get course from course table
		Course course = courseDAO.getCourseByCourseId(courseId);
		User user = userDAO.findByUserName(userName);
		
		if (checkIfCourseDoesNotExists(courseId, user)) {

			if (user.getCourse() == null) {
				List<Course> courseList = new ArrayList<Course>();
				courseList.add(course);
				user.setCourse(courseList);
			} else {
				user.getCourse().add(course);
			}
			
			Student student = new Student();
			student.setCourse(user.getCourse());

			userDAO.saveUser(user);
			userAccessObject.setAddContentToUserSuccess(true);
			userAccessObject.setStudent(student);
		} else {
			userAccessObject.setAddContentToUserSuccess(false);
			userAccessObject.setMsgReturned("Couldn't add course. Please Contact");
		}
		
		
		return userAccessObject;
	}
	
	public boolean checkIfCourseDoesNotExists(long courseId, User user) {
		
		List<Course> courseList = user.getCourse();
		if (courseList != null && courseList.size()>0) {
			for (Course course: courseList) {
				if (courseId == course.getCourseId())
					return false;
			}
		}
		
		return true;
	}

}
