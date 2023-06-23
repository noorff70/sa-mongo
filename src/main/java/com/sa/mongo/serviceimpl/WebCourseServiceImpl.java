package com.sa.mongo.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.mongo.dao.WebCourseDAO;
import com.sa.mongo.model.Student;
import com.sa.mongo.model.WebAvailableCourse;
import com.sa.mongo.model.APIResponseObject;
import com.sa.mongo.model.WebCourse;
import com.sa.mongo.model.WebCourseSchedule;
import com.sa.mongo.service.WebCourseService;


@Service("webCourseService")
public class WebCourseServiceImpl implements WebCourseService{
	
	@Autowired
	private WebCourseDAO webCourseDAO;
	
	@Override
	public WebCourse getWebCourseList(String desc) {

		
		WebCourse webCourse = webCourseDAO.getWebCourseList(desc);
		
		for (WebAvailableCourse availableCourse: webCourse.getAvailableCourses()) {
			List <WebCourseSchedule> scheduleList =  availableCourse.getWebCourseSchedule();
			
			if (scheduleList != null && scheduleList.size()>=0) {
				Iterator<WebCourseSchedule> iter = scheduleList.iterator();
				while (iter.hasNext()) {
					WebCourseSchedule courseSchedule = iter.next();
				    if (courseSchedule.getWebCourseStudentList() != null && courseSchedule.getWebCourseStudentList().size() > availableCourse.getCourseSize()) {
				        iter.remove();
				    }
				}
				/*for (WebCourseSchedule courseSchedule: scheduleList) {
					
					if (courseSchedule.getWebCourseStudentList() != null && 
							courseSchedule.getWebCourseStudentList().size() > availableCourse.getCourseSize()) {
						scheduleList.remove(courseSchedule);
					}
				}*/
			}
		}
		return webCourse;
	}
	
	public APIResponseObject addStudentToScheduledCourse(int subjectId, int webScheduleId, int webCourseId, Student student) {
		return webCourseDAO.addStudentToScheduledCourse(subjectId, webScheduleId, webCourseId, student);
	}
	
	public void addWebCourse (WebCourse course) {
		webCourseDAO.addWebCourse(course);
	}

}
