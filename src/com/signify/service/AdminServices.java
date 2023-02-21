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
import com.signify.bean.User;
import com.signify.collection.AdminCollection;
import com.signify.collection.CatalogCollection;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;

/**
 * @author BHAVISH
 *
 */
public  class AdminServices implements AdminInterface{
	
	ProfessorDAOInterface professorDataset = new ProfessorDAOImplementation();
	AdminDAOInterface adminDataset = new AdminDAOImplementation();
	UserDAOInterface userDataset = new UserDAOImplementation();
	StudentDAOInterface studentDataset = new StudentDAOImplementation();
	static int countProfessor = 0;
	public void assignCourse(String courseCode, String professorId){
		if(CatalogCollection.assignCourse(courseCode, professorId))
			System.out.println("Course Assigned succesfully.");
		else
			System.out.println("There was some error. Either course or professor doesn't exist.");
	}
	
	
	public void addCourse(Course course) {
		userDataset.getUnapproved();
		List<String > students = new ArrayList<>();
		course.setEnrolledStudents(students);
		if(CatalogCollection.addCourse(course))
			System.out.println("Course successfully added.");
		else 
			System.out.println("Course already exists.");
	}
	
	
	public boolean addAdmin(Admin admin, User user) {
		
		int id = userDataset.add(user, 1);
		adminDataset.add(id,admin);
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
		studentDataset.approve(userId);
		userDataset.updateStudent(Integer.parseInt(userId));
	}
	
	
	public  void addProfessor(String userId, Professor prof){
		
		User user = new User();
		user.setName(prof.getProfessorName());
		user.setRole("Professor");
		user.setUserId(prof.getUserId());
		user.setPassword(prof.getPassword());
		int id = userDataset.add(user, countProfessor);
		professorDataset.insert(id, prof);
		
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
		//StudentCollection.print();
		userDataset.getUnapproved();
		System.out.println(" ====================================== ");
	}
	
	
	@Override
	public void removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		adminDataset.remove(admin.getAdminId());
	}
	
	
	@Override
	public void editAdminDetails(Admin old, Admin admin) {
		// TODO Auto-generated method stub
		if(AdminCollection.update(old, admin))
			System.out.println("Admin updated.");
			else
			System.out.println("Wrong details.");
		
		adminDataset.update(admin.getAdminId());;
	}
	
	
	@Override
	public void viewProfesssors() {
		// TODO Auto-generated method stub
		userDataset.printProfessors();
	ProfessorCollection.print();		
	}
	
	
	@Override
	public void approveAllStudents() {
		// TODO Auto-generated method stub
		studentDataset.approveAll();
		userDataset.approveAll();
		
	}
}
