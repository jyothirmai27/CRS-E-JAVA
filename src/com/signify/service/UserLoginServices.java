/**
 * 
 */
package com.signify.service;


import java.io.IOException;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.client.CRSAdminMenu;
import com.signify.client.CRSProfessorMenu;
import com.signify.client.CRSStudentMenu;

/**
 * @author BHAVISH
 *
 */
public  class UserLoginServices implements UserLoginInterface{

	public String getDetails() {
		/*Scanner in = new Scanner(System.in);
		System.out.println("Enter user Id : ");
		String userId = in.next();
		System.out.println("Enter Password");
		String password = in.next();
		System.out.println("Enter 1 for Student\r\n Enter 2 for professor\r\n Enter 3 for admin");
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
		}*/
		return "";
		
	}

	public void login(	String userId, String password, String role) {
		// role to be removed from input 
		// to be determined using user id
		
		
		//authenticate 
		// if true  get role 

		System.out.println("login successful!");
		// direct to that roles menu
		
		try {
			switch(role){
			case "1": CRSStudentMenu smenu = new CRSStudentMenu();
			smenu.display();
			break;
			case "2": CRSProfessorMenu pmenu = new CRSProfessorMenu();
			pmenu.display();
			break;
			case "3": CRSAdminMenu amenu = new CRSAdminMenu();
				amenu.display();
			break;
			case "4": System.out.println("Exiting.");
			default : System.out.println("wrong choice");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if false
		// print login invalid
		// direct back to main menu
		
		
	}
	public void logout(	String userId, String password) {
		// direct to main menu
	}
}
