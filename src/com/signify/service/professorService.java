package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.collection.CatalogCollection;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;

public class ProfessorService implements ProfessorInterface {
	public void changeGrade(String userId) {
		Professor professor= ProfessorCollection.get(userId);
		String code  = professor.getAssignedCourse();
		if(code == null)
			System.out.println("Course is not assigned yet");
		Course course = CatalogCollection.get(code);
			//System.out.println(course.getCourseCode() +" \t\t "+course.getCourseName() +" \t\t "+course.getDepartmentName() +" \t\t "+course.getProfessorName());
			List<String> students = course.getEnrolledStudents();
			Student student = new Student();
		for (String studentId : students) {
			student = StudentCollection.get(studentId);
			//student.setSeeGrades(true);
			//set grade of student
			StudentCollection.update(student.getUserId(), student);
		
		}
		System.out.println("grade added");
	}
	public void viewEnrolledStudents() {
		StudentCollection.print();
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
	public void editDetails(String userId, String field, String correction) {
		///to be approved by admin
		
		Professor professor = new Professor();
		professor = ProfessorCollection.get(userId);
		//System.out.println(student.getStudentName());
		switch(field) {
		case "1": professor.setProfessorName(correction);
			System.out.println("Name Updated.");
		break;
		case "2":professor.setDesignation(correction);
			System.out.println("Designation Upadated.");
		break;
		case "3": professor.setDepartmentName(correction);
			System.out.println("Department Updated.");
		break;
		case "4":professor.setPassword(correction);
			System.out.println("Password changed.");
		break;
		case "5":professor.setPhoneNumber(correction);
			System.out.println("Phone Number Updated.");
		break;
		case "6":UserLoginServices.showMenu("Proffessor", userId);
			//return;
		default : System.out.println("Enter valid numeric input.");
		}
		ProfessorCollection.update(userId, professor);
		
		//System.out.println("editing Details");
	}
	public void viewDetails() {
		System.out.println("viewing details");
	}
	
}
