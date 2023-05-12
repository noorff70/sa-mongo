package com.sa.mongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "user")
public class User {

	@Id
	private String userId;

	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private int userType;
	private List<Course> course;

}
