/**
 * 
 */
package com.signify.service;

import java.util.Date;

/**
 * @author BHAVISH
 *
 */
public interface SemesterRegistrationInterface {
	public void registerCourses(String studentId, int Semester, Date dateOfJoining);
	public void addCourse(String studentId, int Semester, String courseCode);
	public void dropCourse(String studentId, int Semester, String courseCode);
	public void viewCourseDetails();
	public void optCourse();
	public void registration();
	public void payfees();
	public void generateRegistionId();
	public void getSemesterDetails();
}
