/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServices;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;
import com.signify.service.SemesterRegistrationInterface;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;
import com.signify.service.UserLoginInterface;
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
		
	
        System.out.println("\t WELCOME TO CRS APPLICATION");
        
        
        //Object DeclarATION
        Scanner in = new Scanner (System.in);
        Student student = new Student();
        Professor professor = new Professor();
        Admin admin = new Admin();
        StudentInterface studentServices = new StudentServices();
        ProfessorInterface professorServices = new ProfessorService();
        AdminInterface adminServices = new AdminServices();
        UserLoginInterface userLoginService = new UserLoginServices();
        SemesterRegistrationInterface register = new SemesterRegistrationServices();   
    	
        
        
        boolean exit = true;
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("\t \t MAIN MENU\n"
        		+ "Press\n"
        		+ "1. CREATE NEW USER\r\n"
        		+ "2. EXISTING USER LOGIN\r\n"
        		+ "3. VIEW COURSE CATALOG\r\n"
        		+ "4. STUDENT REGISTRATION\r\n"
        		+ "5. EXIT PORTAL");
       
        String choice = in.next();
        switch(choice) {
        case "1":
			System.out.println("Enter user Id : ");
			String userId = in.next();
			System.out.println("Enter Name : ");
			String name = in.next();
			System.out.println("Enter Password : ");
			String password = in.next();
			System.out.println("Enter \n 1. FOR STUDENT\r\n 2. FOR PROFESSOR\r\n 3. FOR ADMIN\r\n ");
			String role = in.next();
			switch(role) {
			case "1":
				student.setUserId(userId);
				student.setPassword(password);
				student.setStudentName(name);
				studentServices.addStudent(student);
			break;
			case "2": 
					professor.setUserId(userId);
					professor.setPassword(password);
					professor.setProfessorName(name);
					professorServices.addProfessor(professor);
			break;
			case "3": 
				admin.setAdminId(userId);
				admin.setPassword(password);
				admin.setAdminName(name);
				adminServices.addAdmin(admin);
			break;
			default : System.out.println("Enter valid numeric input");
			}
        break;
        case "2": System.out.println("Enter user Id : ");
				String loginId = in.next();
				System.out.println("Enter Password");
				String loginPassword = in.next();
				System.out.println("Enter \n 1. FOR STUDENT\r\n 2. FOR PROFESSOR\r\n 3. FOR ADMIN\r\n ");
	        	String roles = in.next();
				userLoginService.login(loginId, loginPassword, roles);
				
        break;
        case "3": // code to view course catalog
        	System.out.println("Course Catalog will be displayed");
        break;
        case "4"://calls registration services 
        	register.registration();
        break;
        case "5": exit = false;
        	System.out.println("Exiting!");
        	System.exit(0);
        break;
        default : System.out.println("Wrong entry! Please enter valid numeric input.");
        
        }
        
        
      }

        in.close();         
	}

}
