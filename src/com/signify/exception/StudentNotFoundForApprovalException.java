package com.signify.exception;

public class StudentNotFoundForApprovalException extends Exception {

	public StudentNotFoundForApprovalException() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("Student was not found for approval.");
	}

}
