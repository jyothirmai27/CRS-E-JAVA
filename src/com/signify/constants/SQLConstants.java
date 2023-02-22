/**
 * 
 */
package com.signify.constants;

/**
 * @author BHAVISH
 *
 */
public class SQLConstants {

	// STUDENT Constnats Queries 
	public static final String REGISTER_STUDENT="insert into student values(?,?,?,?,?,?,?,?)";
	public static final String VIEW_ENROLLED_STUDENTS = "SELECT studentId, studentName, branchName FROM student WHERE approved = 1";
	public static final String UPDATE_ALL_STUDENTS = "UPDATE student SET approved = 1";
	public static final String UPDATE_STUDENT = "update student set approved = 1 where studentId = ";
	public static final String UPDATE_STUDENT_DETAILS = "update student set ";
	public static final String DELETE_STUDENT = "delete from student where userId =  ";
	
	//Admin
	
	public static final String ADD_ADMIN = "insert into admin values(?,?)";
	public static final String DELETE_ADMIN = "delete from admin where userid=";
	
	// Catelog Exception
	
	public static final String ADD_CP_IN_CATELOG = "insert into catelog(course_code, professorId) values(?,?)";
	public static final String DELETE_CP_IN_CATELOG = "delete from catelog where course_code=";
	public static final String GET_COURSE = "select course_code from catelog where professorId =";
	
	//Course Queries
	public static final String ADD_COURSE ="insert into course values(?,?,?,?)";
	public static final String DELETE_COURSE = "delete from course where courseCode= ?";
	public static final String VIEW_COURSES = "SELECT * FROM course";
	
	//course registration queries
	public static final String ADD_REGISTERED_COURSE = "insert into courseregistration(studentId, courseCode) values(?,?)";
	public static final String DELETE_REGISTERED_COURSE =  "delete from courseregistration where courseCode= ? and studentId = ?";
	// Professors Queries 
	
	
	

}
