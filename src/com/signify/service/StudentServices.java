package com.signify.service;

import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;

//import java.util.Date;

import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.collection.CatalogCollection;
import com.signify.collection.StudentCollection;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;

public  class StudentServices implements StudentInterface {
	Student student = new Student();
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	UserDAOInterface userDataset = new UserDAOImplementation();
	
	public void viewGrades(String userId) {
		
		student = StudentCollection.get(userId);
		if(student.isSeeGrades())
			System.out.println("viewing grades in student");
		else
			System.out.println("Waiting for admin to approve grades.");
	}
	public void viewCatelogs() {
		CatalogCollection.printCourses();
	}
	public void addCourse(String userId,String course) {

       /* Scanner in = new Scanner (System.in);
		SemesterRegistrationInterface add = new SemesterRegistrationServices();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        add.addCourse(student.getUserId(), sem, code);
        in.close();*/
		
		student = StudentCollection.get(userId);
		
		List<String> selected = new ArrayList<String>();
		selected = student.getRegisteredCourses();
			if(selected.size()<6) {
				selected.add(course);
				Course c = CatalogCollection.get(course);
				List<String> newList = c.getEnrolledStudents();
				
			}
			else
				System.out.println("You already have 6 courses registered.");
			System.out.println("course added by student");
			student.setRegisteredCourses(selected);
			StudentCollection.update(student.getUserId(), student);
	}
	public void dropCourse(String userId, String course) {
		
		/*Scanner in = new Scanner (System.in);
		SemesterRegistrationInterface drop = new SemesterRegistrationServices();
        System.out.println("Enter Semester");
        int sem = in.nextInt();
        System.out.println("Enter course code");
        String code = in.next();
        drop.dropCourse(student.getUserId(), sem, code);
        in.close();*/
		
		student = StudentCollection.get(userId);
		
		List<String> selected = new ArrayList<String>();
		selected = student.getRegisteredCourses();
		
		selected.remove(course);
		
		student.setRegisteredCourses(selected);
		StudentCollection.update(userId, student);
		System.out.println("course dropped by student");
	}
	public void registerToCourse() {
		System.out.println("Registering to course. Waiting for admin approval.");
		
	}
	public void editDetails(String userId, String field, String correction){
		
		
		Student student = new Student();
		student = StudentCollection.get(userId);
		//System.out.println(student.getStudentName());
		switch(field) {
		case "1": student.setStudentName(correction);
			System.out.println("Name Updated.");
		break;
		case "2":student.setAddress(correction);
			System.out.println("Adress Upadated.");
		break;
		case "3":student.setBranchName(correction);
			System.out.println("Branch Updated.");
		break;
		case "4":student.setPassword(correction);
			System.out.println("Password changed.");
		break;
		case "5":student.setBatch(correction);
			System.out.println("Batch Updated.");
		break;
		case "6":student.setPhoneNumber(correction);
			System.out.println("Phone Number Updated.");
		break;
		case "7":UserLoginServices.showMenu("Student", userId);
			//return;
		default : System.out.println("Enter valid numeric input.");
		}
		StudentCollection.update(userId, student);
		//StudentCollection.print();
		//System.out.println("student details edited");
	}
	public void makePayment() {
		// adding student to course if payment successful
		System.out.println("trying to make payent by student");
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
		return StudentCollection.add(student.getUserId(), student);
	}
	
}
