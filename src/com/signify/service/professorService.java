package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.collection.CatalogCollection;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;

public class ProfessorService implements ProfessorInterface {
	
	ProfessorDAOInterface professordataset = new ProfessorDAOImplementation();
	
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
		
		if(field == "6")
			UserLoginServices.showMenu("Proffessor", userId);
		else if(field == "5"||field =="4" || field =="3"|| field =="2" || field =="1")
			professordataset.update(correction, userId, field);
		else
			System.out.println("Enter valid numeric input.");
		
		
		//System.out.println("editing Details");
	}
	public void viewDetails() {
		System.out.println("viewing details");
	}
	
}
