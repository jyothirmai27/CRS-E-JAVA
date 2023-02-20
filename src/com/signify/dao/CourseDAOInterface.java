/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Course;

/**
 * @author BHAVISH
 *
 */
public interface CourseDAOInterface {
	
	public void add(Course course);
	public void remove(String courseCode);
	public void update(String query);
	public void view(String query);
	

}
