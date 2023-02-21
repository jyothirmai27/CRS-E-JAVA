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
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.dao.CatelogDAOImplementation;
import com.signify.dao.CatelogDAOInterface;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.GradeCardDAOImplementation;
import com.signify.dao.GradeCardDAOInterface;
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
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	CatelogDAOInterface catelog = new CatelogDAOImplementation();
	//static int countProfessor = 0;
	public void assignCourse(String courseCode, String professorId){
		catelog.add(professorId, courseCode);
	}
	
	
	public void addCourse(Course course) {
		courseDataset.add(course);
	}
	
	
	public boolean addAdmin(Admin admin, User user) {
		
		int id = userDataset.add(user, 1);
		adminDataset.add(id,admin);
		return true;
			
	}
	
	
	public void dropCourse(String courseCode){
		courseDataset.remove(courseCode);
	}
	
	
	public  void generateReportCard(){
		GradeCardDAOInterface gradecard = new GradeCardDAOImplementation();
		gradecard.generate();
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
		int id = userDataset.add(user, 3);
		professorDataset.insert(id, prof);
		
	}
	
	
	public  void courseDetails(){

		System.out.println(" ===== VIEWING COURSE CATALOG ====== ");
		courseDataset.view();
		System.out.println(" ====================================== ");
	}
	
	
	@Override
	public void viewEnrolledStudents() {
		// TODO Auto-generated method stub

		System.out.println(" ===== VIEWING ENROLLED STUDENTS ====== ");
		//StudentCollection.print();
		studentDataset.view();
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
		System.out.println("admin details will be edited here.");
	}
	
	
	@Override
	public void viewProfesssors() {
		// TODO Auto-generated method stub
		userDataset.printProfessors();
	}
	
	
	
	@Override
	public void approveAllStudents() {
		// TODO Auto-generated method stub
		
		userDataset.approveAll();
		studentDataset.approveAll();
		
	}


	@Override
	public void removeProfessor(String userId) {
		// TODO Auto-generated method stub
		professorDataset.delete(userId);
	}
  }
