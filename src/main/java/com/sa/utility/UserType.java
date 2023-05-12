package com.sa.utility;

public enum UserType {
	
	STUDENT (1), TUTOR (2);
	
	private int userType;
	
		
	UserType(int type) {
		this.userType = type;
	}
	
	public int getUserType() {
		return this.userType;
	}

}
