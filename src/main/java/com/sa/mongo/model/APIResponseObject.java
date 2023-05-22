package com.sa.mongo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponseObject {
	
	String msgReturned;
	String apiResponseStatus; // STATUS_OK, STATUS_FAIL
	boolean loginSuccess;
	boolean addContentToUserSuccess;
	Student student;
	Tutor tutor;
	List<ScheduleCourse> scheduleCourse;
}
