package com.signify.service;

//import java.util.Date;

import com.signify.bean.Student;
import com.signify.collection.CatalogCollection;
import com.signify.collection.StudentCollection;

public  class StudentServices implements StudentInterface {
	Student student = new Student();
	//StudentCollection studentDataset = new StudentCollection();
	
	public void viewGrades() {
		System.out.println("viewing grades in student");
	}
	public void viewCatelogs() {
		CatalogCollection.printCourses();
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
		System.out.println("trying to make payent by student");
	}
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		
		
		
		//System.out.println("Student name added = "+student.getStudentName());
		
		//System.out.println("Student added");
		//studentDataset.print();
		return StudentCollection.add(student.getUserId(), student);
	}
	
}
