/**
 * 
 */
package com.signify.bean;

//import java.util.List;
import java.util.Map;

/**
 * @author BHAVISH
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
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public float getCpi() {
		return cpi;
	}
	public void setCpi(float cpi) {
		this.cpi = cpi;
	}
	public Map<String, String> getGrades() {
		return grades;
	}
	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}
	

}
