package com.sa.mongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sa.mongo.dao.WebCourseDAO;
import com.sa.mongo.model.WebAvailableCourse;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.model.WebCourseSchedule;


@Repository
public class WebCourseDAOImpl implements WebCourseDAO{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public WebCourse getWebCourseList(String courseName) {

		Query query = new Query();
		query.addCriteria(Criteria.where("webCourseName").is(courseName));
		
		WebCourse course = mongoTemplate.findOne(query, WebCourse.class);
		
		return course;
		
	}

	// add a student to a schedule course
	@Override
	public APIResponseObject addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) {
		
		APIResponseObject userAccess = new APIResponseObject();
		
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
							userAccess.setMsgReturned("You already have enrolled for this Training.");
							userAccess.setApiResponseStatus("STATUS_FAIL");
							return userAccess;
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
			userAccess.setMsgReturned("Course Enrollment is Full");
			userAccess.setApiResponseStatus("STATUS_FAIL");
			return userAccess;
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
			userAccess.setMsgReturned("You are Registered. We will send you Zoom link to attend.");
			userAccess.setApiResponseStatus("STATUS_SUCCESS");
		} catch (Exception e) {
			userAccess.setMsgReturned("Could not be saved. Please contact admin");
			userAccess.setApiResponseStatus("STATUS_FAIL");
		}
		

		return userAccess;
		
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
