/**
 * 
 */
package com.signify.service;


import java.io.IOException;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.client.CRSAdminMenu;
import com.signify.client.CRSProfessorMenu;
import com.signify.client.CRSStudentMenu;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;

/**
 * @author BHAVISH
 *
 */
public  class UserLoginServices implements UserLoginInterface{
	
	static CRSAdminMenu amenu = new CRSAdminMenu();
	static CRSProfessorMenu pmenu = new CRSProfessorMenu();
	static CRSStudentMenu smenu = new CRSStudentMenu();
	
	UserDAOInterface userDataset = new UserDAOImplementation();
	
	public static void showMenu(String role, String userId) {
		
	try {
		switch(role){
		case "Student": 
			smenu.display(userId);
		break;
		case "Professor": 
			pmenu.display(userId);
		break;
		case "Admin": 
			amenu.display();
		break;
		default : System.out.println("There was some error.");	
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	public String authenticate(User user) {
		switch(userDataset.authenticate(user.getPassword(),user.getUserId())){
		case 1: return "Admin";
		case 2: return "Student";
		case 3: return "Professor";
		case 4: return "unapproved";
		default :return "wrongPassword";
		}
			
	}

	public void login(User user) {
		
		try {

			 
			switch(authenticate(user)){
			case "Student": 
				System.out.println("! Login successful! \n");
				smenu.display(user.getUserId());
			break;
			case "Professor": 
				System.out.println("! Login successful! \n");
				pmenu.display(user.getUserId());
			break;
			case "Admin": 				
				System.out.println("! Login successful! \n");
				amenu.display();
			break;
			case "unapproved" : System.out.println("Waiting for admin's approval.");
			break;
			case "wrongPassword": System.out.println("Password Incorrect.");
			break;
			default : System.out.println("Invalid Details.");	
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

	@Override
	public void updatePassword(String userId, String old, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(userId);
		user.setPassword(old);
		String role = authenticate(user);
		if(role.equals("wrongPassword"))
			System.out.println("You have entered wrong credentials.");
		else
			userDataset.updatePassword(userId,password);
	}
}
