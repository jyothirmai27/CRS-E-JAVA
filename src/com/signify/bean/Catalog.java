/**
 * 
 */
package com.signify.bean;

import java.util.List;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class Catalog {
	private int totalCourses;
	private int totalDepartments;
	private String department;
	private List<String> courseCodes;
	private String proffesor;
	
	
	//method to get Total course
	public int getTotalCourses() {
		return totalCourses;
	}
	//method to set Total course
	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	//method to get Total departments
	public int getTotalDepartments() {
		return totalDepartments;
	}
	
	//method to set Total departments
	public void setTotalDepartments(int totalDepartments) {
		this.totalDepartments = totalDepartments;
	}
	
	//method to get department
	public String getDepartment() {
		return department;
	}
	//method to set department
	
	public void setDepartment(String department) {
		this.department = department;
	}
	//method to get CourseCode
	public List<String> getCourseCodes() {
		return courseCodes;
	}
	//method to set CourseCode
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}
	//method to get professorName
	public String getProffesor() {
		return proffesor;
	}
	//method to set professorName
	public void setProffesor(String proffesor) {
		this.proffesor = proffesor;
	}

}
