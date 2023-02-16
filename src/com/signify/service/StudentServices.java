package com.signify.service;

import java.util.Scanner;

import com.signify.bean.Student;

public  class StudentServices {
	public void viewGrades() {
		
	}
	public void viewCatelogs() {
		
	}
	public static void addCourse() {

        Scanner in = new Scanner (System.in);
		CourseRegistrationService add = new CourseRegistrationService();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        add.addCourse(Student.getUserId(), sem, code);
        in.close();
	}
	public static void dropCourse() {
		
		Scanner in = new Scanner (System.in);
		CourseRegistrationService drop = new CourseRegistrationService();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        drop.dropCourse(Student.getUserId(), sem, code);
        in.close();
	}
	public static void registerToCourse() {
		
	}
	public static void editDetails(){
		///to be approved by admin
		Scanner in = new Scanner (System.in);
		 Student student = new Student();
	    	System.out.println("Enter new Password");
	    	String password = in.next();
			student.setPassword(password);
			in.close();
			System.out.println("Password changed!");
	}
	public void makePayment() {
		
	}
	
}
