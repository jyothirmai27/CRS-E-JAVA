package com.signify.dao;

import com.signify.exception.NoCourseRegisteredException;

public interface GradeCardDAOInterface {
	
	/*
	  method to count the number of students that are assigned to a course
	  @param student    represents the student
	 */
	public void update(String userId);
	
	/*
	 method to view the grade
	 @param userId   unique id to represent the user
	 */
	public void view(String userId) throws NoCourseRegisteredException;
	
	/*
	 method to generate the grade
	 */
	public void generate() throws NoCourseRegisteredException;
	
	/*
	 method to view the grades
	 @param userId   unique id to represent the user
	 @param cpi      represents grade point
	 */
	public void viewgrades(String userId,Double cpi);
}
