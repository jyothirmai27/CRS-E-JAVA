/**
 * 
 */
package com.signify.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.signify.bean.Admin;
import com.signify.bean.Course;


/**
 * @author BHAVISH
 *
 */
public class CatalogCollection {
	
	static Map<String, String> catalogDataset = new HashMap<>();
	static Map<String,Course> courseDataset = new HashMap<>();
	//Set<Integer> usersData = new HashSet<>();
	public static boolean assignCourse(String courseCode,String professorId )
	{
		if(courseDataset.containsKey(courseCode)) {

			
			Course course = CatalogCollection.get(courseCode);
			if(ProfessorCollection.getProfesssorName(professorId).equals("nil"))
				return false;
			course.setProfessorName(ProfessorCollection.getProfesssorName(professorId));
			ProfessorCollection.updateCourse(professorId, courseCode);
			CatalogCollection.updateCourse(course);
			catalogDataset.put(courseCode, professorId);
			return true;
		}
		return false;
		
	}
	public static boolean updateCourse(Course course) {
		if(courseDataset.containsKey(course.getCourseCode())) {
			courseDataset.put(course.getCourseCode(), course);
			return true;
		}
		else 
			return false;
		
	}
	public static boolean removeCourse(String courseCode) {
		if(courseDataset.containsKey(courseCode)) {
			courseDataset.remove(courseCode);
			return true;
		}
		else 
			return false;
	}
	public static Course get(String courseCode) {
		return courseDataset.getOrDefault(courseCode, null);
	}
	public static boolean addCourse(Course course)
	{
		if(courseDataset.containsKey(course.getCourseCode()))
			return false;
		else
		courseDataset.put(course.getCourseCode(), course);
		return true;
	}
	public static int totalCourses() {
		return courseDataset.size();
	}
	public static void printCourses()
	{
		if(courseDataset.isEmpty())
			System.out.println("No course yet.");
		else
			for (String key: courseDataset.keySet()) {  
			     
				Course course = courseDataset.getOrDefault(key, null);
				System.out.println(course.getCourseCode() +" \t\t "+course.getCourseName() +" \t\t "+course.getDepartmentName() +" \t\t "+course.getProfessorName());
			}
	}

}
