package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
import java.util.List;

public class Course {
	private String courseName;
	private String courseCode;
	private String departmentName;
	private String professorName;
	private boolean isOffered;
	private String semester;
	private List<String> enrolledStudents;
	private int enrolledStudentCount;
	
	/**
	 * @param courseId
	 * @param courseName
	 * @param departmentName
	 * @param professorId
	 * @param studentCount
	 */
	?*public Course (String courseCode, String courseName, String departmentName, String semester) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.departmentName = departmentName;
		this.semester = semester;
				
	}*/
	
	//method to get Semester
	public String getSemester() {
		return semester;
	}
	
	//method to set Semester
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	//method to get courseName
	public String getCourseName() {
		return courseName;
	}
	
	//method to set courseName
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	//method to get courseCode
	public String getCourseCode() {
		return courseCode;
	}
	//method to set courseCode
	public void setCourseCode(String courseId) {
		this.courseCode = courseId;
	}
	//method to get Department Name
	public String getDepartmentName() {
		return departmentName;
	}
	
	//method to set Department Name
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//method to get ProfessorName
	public String getProfessorName() {
		return professorName;
	}
	
	//method to set ProfessorName
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	//method to get Enrolled Students
	public List<String> getEnrolledStudents() {
		return enrolledStudents;
	}
	
	//method to set Enrolled Students
	public void setEnrolledStudents(List<String> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	//method to get Enrolled Students Count
	public int getEnrolledStudentCount() {
		return enrolledStudentCount;
	}
	
	//method to set Enrolled Students
	public void setEnrolledStudentCount(int enrolledStudentCount) {
		this.enrolledStudentCount = enrolledStudentCount;
	}
	public boolean isOffered() {
		return isOffered;
	}
	
}
