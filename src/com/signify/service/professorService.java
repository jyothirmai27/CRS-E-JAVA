package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.exception.NoApprovedStudentsException;

public class ProfessorService implements ProfessorInterface {
	
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	ProfessorDAOInterface professordataset = new ProfessorDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
	
	public void changeGrade(String studentId, String grade, String courseCode) {
		coursesDataset.addGrade(studentId, courseCode, grade);
	}
	public void viewEnrolledStudents() {
		try {
			studentDataset.view();
		} catch (NoApprovedStudentsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
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
		
		if(field == "5")
			UserLoginServices.showMenu("Proffessor", userId);
		else if(field =="4" || field =="3"|| field =="2" || field =="1")
			professordataset.update(correction, userId, field);
		else
			System.out.println("Enter valid numeric input.");
		
		
		//System.out.println("editing Details");
	}
	public void viewDetails() {
		System.out.println("viewing details");
	}
	
}
