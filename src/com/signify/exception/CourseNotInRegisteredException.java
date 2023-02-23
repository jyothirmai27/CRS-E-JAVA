package com.signify.exception;

public class CourseNotInRegisteredException extends Exception{

	public CourseNotInRegisteredException() {
		// TODO Auto-generated constructor stub
		super();
			System.out.println("You have not added the course you are trying to drop");
	}

}
