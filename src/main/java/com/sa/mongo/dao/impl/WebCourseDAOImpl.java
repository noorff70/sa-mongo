package com.sa.mongo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sa.mongo.dao.WebCourseDAO;
import com.sa.mongo.model.WebAvailableCourse;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.model.WebCourseSchedule;


@Repository
public class WebCourseDAOImpl implements WebCourseDAO{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public WebCourse findByWebCourseName(String courseName) {

		Query query = new Query();
		query.addCriteria(Criteria.where("webCourseName").is(courseName));
		
		WebCourse course = mongoTemplate.findOne(query, WebCourse.class);
		
		return course;
		
	}

	// add a student to a schedule course
	@Override
	public String addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) {
		
		String result= null;
		
		// first find that webCourse
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(subjectId));
		WebCourse course = mongoTemplate.findOne(query, WebCourse.class);
		
		// get webavailablecourse
		WebAvailableCourse webAvailableCourse = null;
		List<WebAvailableCourse> webCourseList = course.getAvailableCourses();
		for (WebAvailableCourse webList: webCourseList) {
			if (webList.getCourseId()== webCourseId) {
				webAvailableCourse = webList;
				break;
			}
		}
		
		// get list of WebCourseDateList and then get the WebCourseScheduleDate
		WebCourseSchedule webCourseSchedule=null;
		List<WebCourseSchedule> list = webAvailableCourse.getWebCourseSchedule();
		for (WebCourseSchedule scheduleDate: list) {
			if (scheduleDate.getWebCourseOfferNumber() == webScheduleId) {
				List<Student> studentList = scheduleDate.getWebCourseStudentList();
				// check if student is present in the scheduled offer Date. if student present then return as already registered
				if (studentList != null) {
					for (Student st : studentList) {
						if (st.getUserName().equals(student.getUserName())) {
							return "You have enrolled already";
						}
					}
				}
				// get the scheduleDate, now need to register student to this course date
				webCourseSchedule = scheduleDate;
				break;
			}
		}
		
		// check if course has max number of enrollments
		if (webCourseSchedule.getWebCourseStudentList() != null && 
				webCourseSchedule.getWebCourseStudentList().size() > webAvailableCourse.getCourseSize()) {
			webAvailableCourse.setAvailable(false);
			mongoTemplate.save(webAvailableCourse);
			return "Course is Full";
		}
		
		// now add the student and we have got an updated webCourseDateList
		if (webCourseSchedule.getWebCourseStudentList()== null) {
			List<Student> studentList = new ArrayList<Student>();
			studentList.add(student);
			webCourseSchedule.setWebCourseStudentList(studentList);
		} else {
			webCourseSchedule.getWebCourseStudentList().add(student);
		}
		
		try {
			mongoTemplate.save(course);
			result = "You are registered.";
		} catch (Exception e) {
			result = "Could not be saved. Please contact admin";
			return result;
		}
		

		return result;
		
	}
	
	// add a new webcourse - only postman
	public void addWebCourse (WebCourse course) {
		try {
			mongoTemplate.save(course);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
