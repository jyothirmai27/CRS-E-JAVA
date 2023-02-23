/**
 * 
 */
package com.signify.service;

import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public interface StudentInterface {
	public boolean addStudent(Student student, User user);
	public void viewGrades(String userid) ;
	public void viewCatelogs();
	public void addCourse(String userId, String course, int sem);
	public void dropCourse(String userId, String course);
	public void registerToCourse(String userId);
	public void editDetails(String userId, String field, String correction);
	public void makePayment(String userId, Payment payment);
	public boolean validRegistration(Student student);

}
