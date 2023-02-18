/**
 * 
 */
package com.signify.service;

import com.signify.bean.Admin;
import com.signify.collection.StudentCollection;

/**
 * @author BHAVISH
 *
 */
public  class AdminServices implements AdminInterface{
	public void assignCourse(){
		System.out.println("course assigned by admin");
	}
	public void addCourse() {
		System.out.println("Course added by admin");
	}
	public void addAdmin(Admin admin) {
		System.out.println("ADMIN ADDED");
	}
	public void dropCourse(){
		System.out.println("COURSE DROPPED");
	}
	public  void generateReportCard(){
		System.out.println("REPORT CARD GENERATED");
		
	}
	public  void approveStudent(){
		System.out.println("student approved by admin");
	}
	public  void addProfessor(){
		System.out.println("Professor added by admin");		
	}
	public  void courseDetails(){
		System.out.println("viewing course details by admin");
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
		System.out.println("removed admin");
	}
}
