/**
 * 
 */
package com.signify.bean;

//import java.util.List;
import java.util.Map;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class GradeCard {
	
	private int studentId;
	private int semester;
	private float cpi;
	private Map<String,String> grades;
	private enum grade {A,B,C,D};
	public int getStudentId() {
		return studentId;
	}
	
	//method to set StudentId
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
//method to get Semester
	public int getSemester() {
		return semester;
	}
	//method to set Semester
	public void setSemester(int semester) {
		this.semester = semester;
	}
	//method to get cpi
	public float getCpi() {
		return cpi;
	}
	
	//method to set cpi
	public void setCpi(float cpi) {
		this.cpi = cpi;
	}
	
	//method to get grades
	public Map<String, String> getGrades() {
		return grades;
	}
	//method to set grades
	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}
	

}
