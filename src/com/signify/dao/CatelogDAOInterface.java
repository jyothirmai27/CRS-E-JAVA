package com.signify.dao;

import com.signify.exception.CourseNotAssignedToProfessorException;
import com.signify.exception.CourseNotFoundException;

public interface CatelogDAOInterface {

	public void add (String profid, String courseCode) throws CourseNotFoundException;
	public void remove(String courseCode) throws CourseNotFoundException;
	public String getCourse(String prof) throws CourseNotAssignedToProfessorException;
}
