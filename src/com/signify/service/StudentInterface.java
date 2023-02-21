/**
 * 
 */
package com.signify.service;

import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.collection.StudentCollection;

/**
 * @author BHAVISH
 *
 */
public interface StudentInterface {
	public boolean addStudent(Student student, User user);
	public void viewGrades(String userid) ;
	public void viewCatelogs();
	public void addCourse(String userId, String course);
	public void dropCourse(String userId, String course);
	public void registerToCourse();
	public void editDetails(String userId, String field, String correction);
	public void makePayment();

}
