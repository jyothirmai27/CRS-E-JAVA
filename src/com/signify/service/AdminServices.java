/**
 * 
 */
package com.signify.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.collection.AdminCollection;
import com.signify.collection.CatalogCollection;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;

/**
 * @author BHAVISH
 *
 */
public  class AdminServices implements AdminInterface{
	
	ProfessorDAOInterface professorDataset = new ProfessorDAOImplementation();
	AdminDAOInterface adminDataset = new AdminDAOImplementation();
	
	public void assignCourse(String courseCode, String professorId){
		if(CatalogCollection.assignCourse(courseCode, professorId))
			System.out.println("Course Assigned succesfully.");
		else
			System.out.println("There was some error. Either course or professor doesn't exist.");
	}
	
	
	public void addCourse(Course course) {
		List<String > students = new ArrayList<>();
		course.setEnrolledStudents(students);
		if(CatalogCollection.addCourse(course))
			System.out.println("Course successfully added.");
		else 
			System.out.println("Course already exists.");
	}
	
	
	public boolean addAdmin(Admin admin) {
		adminDataset.add(admin);
		return AdminCollection.add(admin);
			
	}
	
	
	public void dropCourse(String courseCode){
		if(CatalogCollection.removeCourse(courseCode))
		System.out.println("COURSE DROPPED");
		else
		System.out.println("No such Course exists.");
	}
	
	
	public  void generateReportCard(){
		Map<String, Course> courses = CatalogCollection.getCourseDetails();
		for (String key: courses.keySet()) {  
		     
			Course course = courses.getOrDefault(key, null);
			//System.out.println(course.getCourseCode() +" \t\t "+course.getCourseName() +" \t\t "+course.getDepartmentName() +" \t\t "+course.getProfessorName());
			List<String> students = course.getEnrolledStudents();
			Student student = new Student();
		for (String studentId : students) {
			student = StudentCollection.get(studentId);
			student.setSeeGrades(true);
			StudentCollection.update(student.getUserId(), student);
		
		}
		System.out.println("REPORT CARD GENERATED");
	}
	}
	
	
	public  void approveStudent(String userId){
		Student student= StudentCollection.get(userId);
		student.setRegistered(true);
		StudentCollection.addApproved(student.getUserId(),student);
		System.out.println("student approved by admin");
	}
	
	
	public  void addProfessor(String userId, Professor profesor){
		if(ProfessorCollection.add(userId, profesor))
		System.out.println("Professor has been added succesfully.");
		else
		System.out.println("This user Id already exists.");	
		
		professorDataset.insert(profesor);
		
	}
	
	
	public  void courseDetails(){

		System.out.println(" ===== VIEWING COURSE CATALOG ====== ");
		CatalogCollection.printCourses();;
		System.out.println(" ====================================== ");
	}
	
	
	@Override
	public void viewEnrolledStudents() {
		// TODO Auto-generated method stub

		System.out.println(" ===== VIEWING ENROLLED STUDENTS ====== ");
		StudentCollection.print();
		System.out.println(" ====================================== ");
	}
	
	
	@Override
	public void removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(AdminCollection.remove(admin))
			System.out.println("Admin Removed.");
		else
			System.out.println("There was some error.");
	}
	
	
	@Override
	public void editAdminDetails(Admin old, Admin admin) {
		// TODO Auto-generated method stub
		if(AdminCollection.update(old, admin))
			System.out.println("Admin updated.");
			else
			System.out.println("Wrong details.");
	}
	
	
	@Override
	public void viewProfesssors() {
		// TODO Auto-generated method stub
		ProfessorCollection.print();		
	}
	
	
	@Override
	public void approveAllStudents() {
		// TODO Auto-generated method stub
		Map<String, Student>unApproved =StudentCollection.getUnapproved();
		for(String key: unApproved.keySet()){
		Student student=unApproved.getOrDefault(key, null);
		if (student == null)
			System.out.println("There was some error");
		else {
		student.setRegistered(true);
		StudentCollection.addApproved(student.getUserId(), student);}
		
		}
		
	}
}
