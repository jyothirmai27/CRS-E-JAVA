/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.UserLoginServices;

/**
 * @author BHAVISH
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
        System.out.println("WELCOME TO CRS APPLICATION");    
        System.out.println("---------------------- ");  
        Scanner in = new Scanner (System.in);
        boolean exit = true;
        while(exit) {
        System.out.println("Main Menu\r\n"
        		+ "Press\r\n "
        		+ "1. Login\r\n"
        		+ "2. Registration of student\r\n"
        		+ "3. Update password\r\n"
        		+ "4. Exit");
       
        String choice = in.next();
        switch(choice){
        	case "1": UserLoginServices login = new UserLoginServices();
        		String role = login.getDetails();
        		switch(role){
        			case "1": StudentMenu smenu = new StudentMenu();
        			smenu.display();
        			break;
        			case "2": CRSProfessorMenu pmenu = new CRSProfessorMenu();
        			pmenu.display();
        			break;
        			case "3": AdminMenu amenu = new AdminMenu();
        			amenu.display();
        			break;
        			case "4": System.out.println("Exiting.");
        			default : System.out.println("wrong choice");	
        		}
        	break;
        	case "2": SemesterRegistrationServices register = new SemesterRegistrationServices();   
        	register.registration();
        	break;
        	case "3":System.out.println("Enter 1 for Student \r\n Enter 2 for professor \r\n Enter 3 for admin");
    		        	String roles = in.next();
    		        	System.out.println("Enter new Password");
    		        	String password = in.next();
    		switch(roles) {
    		case "1": Student student = new Student();
    				student.setPassword(password);
    		break;
    		case "2": Professor professor = new Professor();
    					professor.setPassword(password);
    		break;
    		case "3": Admin admin = new Admin();
    				admin.setPassword(password);
    		break;
    		default : System.out.println("Wrong  Entry!! Enter valid numeric input");
    		}
    		break;
        	case "4" :
            	exit = false; System.out.println("Exiting!");
        	break;
        	default : System.out.println("Wrong entry! Please enter valid numeric input.");
        
        
        }
        }
        
        
		
        
	}

}
