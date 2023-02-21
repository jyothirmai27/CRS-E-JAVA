package com.signify.service;

import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;

//import java.util.Date;

import com.signify.bean.Student;
import com.signify.bean.User;

import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.dao.GradeCardDAOImplementation;
import com.signify.dao.GradeCardDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;

public  class StudentServices implements StudentInterface {
	Student student = new Student();
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	UserDAOInterface userDataset = new UserDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	public void viewGrades(String userId) {
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
		gradecard.view(userId);
	}
	public void viewCatelogs() {
		courseDataset.view();
	}
	public void addCourse(String userId,String course) {
		
		coursesDataset.addCourse(userId, course);

	}
	public void dropCourse(String userId, String course) {
		
		coursesDataset.dropCourse(userId, course);
		
	}
	public void registerToCourse() {
		System.out.println("Registering to course. Waiting for admin approval.");
		
	}
	public void editDetails(String userId, String field, String correction){
		
		
		Student student = new Student();
		 String query ="";
		//System.out.println(student.getStudentName());
		switch(field) {
		case "1":query = "name = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Name Updated.");
		break;
		case "2":query = "address = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Address Upadated.");
		break;
		case "3":query = "branchName = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Branch Updated.");
		break;
		case "4":query = "batch = \""+correction+"\" WHERE studentId = "+userId;
		studentDataset.update(query);
			System.out.println("Batch Updated.");
		break;
		case "5":query = "phone_number = \""+correction+"\" WHERE studentId = "+userId;
			studentDataset.update(query);
			System.out.println("Phone Number Updated.");
		break;
		case "6":UserLoginServices.showMenu("Student", userId);
			//return;
		default : System.out.println("Enter valid numeric input.");
		}
		//StudentCollection.print();
		//System.out.println("student details edited");
	}
	public void makePayment(String userId) {
		// adding student to course if payment successful
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
		gradecard.update(userId);
	}
	@Override
	public boolean addStudent(Student student, User user) {
		// TODO Auto-generated method stub
		
		
		
		//System.out.println("Student name added = "+student.getStudentName());
		
		//System.out.println("Student added");
		//studentDataset.print();
		List<String> courses = new ArrayList<>();
		student.setRegisteredCourses(courses);
		student.setPaymentdone(false);
		student.setRegistered(false);
		student.setScholarship(false);
		student.setSeeGrades(false);
		int id = userDataset.add(user, 4);
		studentDataset.add(id, student);
		return true;
	}
	
}
