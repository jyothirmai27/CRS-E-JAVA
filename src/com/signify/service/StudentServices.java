package com.signify.service;

//import java.util.Date;

import com.signify.bean.Student;

public  class StudentServices implements StudentInterface {
	Student student = new Student();
	
	
	public void viewGrades() {
		System.out.println("viewing grades in student");
	}
	public void viewCatelogs() {
		System.out.println("viewing catalog in student");
	}
	public void addCourse() {

       /* Scanner in = new Scanner (System.in);
		SemesterRegistrationInterface add = new SemesterRegistrationServices();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        add.addCourse(student.getUserId(), sem, code);
        in.close();*/
		
		System.out.println("course added by student");
	}
	public void dropCourse() {
		
		/*Scanner in = new Scanner (System.in);
		SemesterRegistrationInterface drop = new SemesterRegistrationServices();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        drop.dropCourse(student.getUserId(), sem, code);
        in.close();*/
		
		System.out.println("course dropped by student");
	}
	public void registerToCourse() {
		
	}
	public void editDetails(){
		///to be approved by admin
		/*Scanner in = new Scanner (System.in);
		 Student student = new Student();
	    	System.out.println("Enter new Password");
	    	String password = in.next();
			student.setPassword(password);
			in.close();
			System.out.println("Password changed!");*/
		System.out.println("student details edited");
	}
	public void makePayment() {
		System.out.println("trying to make payent by student");
	}
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
		System.out.println("Student added");
	}
	
}
