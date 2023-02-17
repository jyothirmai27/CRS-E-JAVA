package com.signify.service;

import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Professor;

public class ProfessorService implements ProfessorInterface {
	public void changeGrade() {
		System.out.println("grade added");
	}
	public void viewEnrolledStudents() {
		System.out.println("viewing enrolled students");
	}
	public void selectCourse() {
		/*Scanner in = new Scanner (System.in);
		System.out.println("Enter Name : ");
		String name = in.next();
        System.out.println("Enter Semester : ");
        int sem = in.nextInt();
        System.out.println("Enter course code : ");
        String code = in.next();
        Course course = new Course();
        course.setProfessorName(name);
        course.setCourseCode(code);
        course.setSemester(sem);
        //course catalog to add professor
        in.close();*/
		
		System.out.println("selecting course");
	}
	public void editDetails() {
		///to be approved by admin
		
		System.out.println("editing Details");
	}
	public void viewDetails() {
		System.out.println("viewing details");
	}
	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
		System.out.println("Professor added");
	}
	
}
