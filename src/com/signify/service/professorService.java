package com.signify.service;

import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Student;

public abstract class ProfessorService {
	public static void changeGrade() {
		
	}
	public static void viewEnrolledStudents() {
		
	}
	public void selectCourse() {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter Name : ");
		String name = in.next();
        System.out.println("Enter Semester : ");
        int sem = in.nextInt();
        System.out.println("Enter course code : ");
        String code = in.next();
        Course course = new Course();
        course.setProfessorName(name);
        //course catalog to add professor
        in.close();
	}
	public static void editDetails() {
		///to be approved by admin
	}
	public void viewDetails() {
		
	}
	
}
