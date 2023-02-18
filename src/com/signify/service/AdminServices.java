/**
 * 
 */
package com.signify.service;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.collection.AdminCollection;
import com.signify.collection.CatalogCollection;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;

/**
 * @author BHAVISH
 *
 */
public  class AdminServices implements AdminInterface{
	public void assignCourse(String courseCode, String professorId){
		if(CatalogCollection.assignCourse(courseCode, professorId))
			System.out.println("Course Assigned succesfully.");
		else
			System.out.println("There was some error. Either course or professor doesn't exist.");
	}
	public void addCourse(Course course) {
		if(CatalogCollection.addCourse(course))
			System.out.println("Course successfully added.");
		else 
			System.out.println("Course already exists.");
	}
	public boolean addAdmin(Admin admin) {
		return AdminCollection.add(admin);
			
	}
	public void dropCourse(String courseCode){
		if(CatalogCollection.removeCourse(courseCode))
		System.out.println("COURSE DROPPED");
		else
		System.out.println("No such Course exists.");
	}
	public  void generateReportCard(){
		System.out.println("REPORT CARD GENERATED");
		
	}
	public  void approveStudent(){
		System.out.println("student approved by admin");
	}
	public  void addProfessor(String userId, Professor profesor){
		if(ProfessorCollection.add(userId, profesor))
		System.out.println("Professor has been added succesfully.");
		else
		System.out.println("This user Id already exists.");	
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
}
