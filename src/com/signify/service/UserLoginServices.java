/**
 * 
 */
package com.signify.service;

import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;

/**
 * @author BHAVISH
 *
 */
public  class UserLoginServices {

	public String getDetails() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter user Id : ");
		String userId = in.next();
		System.out.println("Enter Password");
		String password = in.next();
		System.out.println("Enter 1 for Student/r/n Enter 2 for professor/r/n  Enter 3 for admin");
		String role = in.next();
		switch(role) {
		case "1": {Student student = new Student();
				student.setUserId(userId);
				student.setPassword(password);}
		break;
		case "2": {Professor professor = new Professor();
					professor.setUserId(userId);
					professor.setPassword(password);
			}
		break;
		case "3": {Admin admin = new Admin();
				admin.setAdminId(userId);
				admin.setPassword(password);}
		break;
		default : System.out.println("Enter valid numeric input");
		}
		return role;
		
	}

	public String checkUserDetails(	String userId, String password, String role) {
		return userId;
	}
}
