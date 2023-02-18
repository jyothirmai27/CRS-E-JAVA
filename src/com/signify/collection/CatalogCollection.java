/**
 * 
 */
package com.signify.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.signify.bean.Course;


/**
 * @author BHAVISH
 *
 */
public class CatalogCollection {
	
	static Map<String, String> catalogDataset = new HashMap<>();
	static Set<Course> courseDataset = new HashSet<>();
	//Set<Integer> usersData = new HashSet<>();
	public static void assignCourse(String coursseCode,String professorId )
	{
		catalogDataset.put(coursseCode, professorId);
		//usersData.add(user.getUserId());
	}
	public static void addCourse(Course c)
	{
		courseDataset.add(c);
	}
	public static void printCourses()
	{
		for(Course c: courseDataset)
		{
			System.out.println(c.getCourseCode());
			System.out.println(c.getCourseName());
			System.out.println(c.getSemester());
		}
	}

}
