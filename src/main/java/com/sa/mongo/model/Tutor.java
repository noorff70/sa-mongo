package com.sa.mongo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tutor extends User{
	
	private String tutorBio;
	private String imageLocation;

}
