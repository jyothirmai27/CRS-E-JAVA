/**
 * 
 */
package com.signify.collection;

import java.util.HashMap;
import java.util.Map;

import com.signify.bean.Student;
import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public class StudentCollection {
	
		static Map<String, Student> unapprovedStudentDataset = new HashMap<>();
		static Map<String, Student> studentDataset = new HashMap<>();
		//Map<String, String> demo = new HashMap<>();
		public static void update(String userId, Student stu) {
			studentDataset.put(userId, stu);
		}
		public static Map<String, Student> getUnapproved(){
			return unapprovedStudentDataset;
		}
		public static boolean add(String userId, Student stu) {
			if(UserCollection.exists(userId))
				return false;
			unapprovedStudentDataset.put(userId, stu);
			return true;
		}
		public static boolean addApproved(String userId, Student stu)
		{
			//System.out.println("in add function ------>"+stu.getUserId());
			if(UserCollection.exists(userId))
				return false;
			studentDataset.put(userId, stu);
			unapprovedStudentDataset.remove(userId);
			User user = new User();
			user.setName(stu.getStudentName());
			user.setRole("Student");
			user.setUserId(stu.getUserId());
			user.setPassword(stu.getPassword());
			UserCollection.add(user);
			return true;
			//demo.put(stu.getUserId(),stu.getStudentName());
		}
		public static Student get(String key) {
			return studentDataset.getOrDefault(key, null);
		}
		public static Student getUnapproved(String key) {
			return unapprovedStudentDataset.getOrDefault(key, null);
		}
		public static void print()
		{
			 for (String key: studentDataset.keySet()) {  
				     
				Student stud = studentDataset.getOrDefault(key, null);
				System.out.println("Sr No. \t\t Name \t\t Address \t\t Branch   ");
				System.out.println(stud.getUserId() +" \t\t "+stud.getStudentName()+" \t\t "+stud.getAddress()+" \t\t "+stud.getBranchName());
				//System.out.println(demo.getOrDefault(key,"not working"));
			}
			
			//System.out.println(studentDataset);
		}
		public static void printUnapproved() {
			
			if(unapprovedStudentDataset.isEmpty())
				System.out.println("No Student left for approval!");
			for (String key: studentDataset.keySet()) {  
			     
				Student stud = studentDataset.getOrDefault(key, null);
				System.out.println("Sr No. \t\t Name \t\t Address \t\t Branch   ");
				System.out.println(stud.getUserId() +" \t\t "+stud.getStudentName()+" \t\t "+stud.getAddress()+" \t\t "+stud.getBranchName());
				//System.out.println(demo.getOrDefault(key,"not working"));
			}
			
		}

}
