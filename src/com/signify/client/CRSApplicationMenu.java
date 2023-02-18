/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.collection.StudentCollection;
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
        //Student student = new Student();
        Professor professor = new Professor();
        Admin admin = new Admin();
        User user = new User();
        StudentInterface studentServices = new StudentServices();
        ProfessorInterface professorServices = new ProfessorService();
        AdminInterface adminServices = new AdminServices();
        UserLoginInterface userLoginService = new UserLoginServices();
        SemesterRegistrationInterface register = new SemesterRegistrationServices();  
    	CRSStudentMenu smenu = new CRSStudentMenu();
    	//StudentCollection studentDataset = new StudentCollection();
        
        
        boolean exit = true;
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("\t \t MAIN MENU\n"
        		+ "Press\n"
        		+ "1. EXISTING USER LOGIN\r\n"
        		+ "2. VIEW COURSE CATALOG\r\n"
        		+ "3. STUDENT REGISTRATION\r\n"
        		+ "4. EXIT PORTAL");
       
        String choice = in.next();
        switch(choice) {
        
        case "1": System.out.println("Enter user Id : ");
				String loginId = in.next();
				System.out.println("Enter Password");
				String loginPassword = in.next();
				
				//System.out.println("Enter \n 1. FOR STUDENT\r\n 2. FOR PROFESSOR\r\n 3. FOR ADMIN\r\n ");
	        	//String roles = in.next();
				user.setUserId(loginId);
				user.setPassword(loginPassword);
				userLoginService.login(user);
				
        break;
        case "2": // code to view course catalog
        	System.out.println("Course Catalog will be displayed");
        break;
        case "3":
        	Student student = new Student();
        	System.out.println("Enter user Id : ");
    		//String userId = in.next();
			student.setUserId(in.next());
    		System.out.println("Enter Name : ");
    		//String name = in.next();
    		student.setStudentName(in.next());
    		System.out.println("Enter Password : ");
    		//String password = in.next();
    		student.setPassword(in.next());
    		System.out.println("Enter Branch Name : ");
    		student.setBranchName(in.next());
    		System.out.println("Enter Address : ");
    		student.setAddress(in.next());
    		System.out.println("Enter Batch : (start year - end year) ");
    		student.setBatch(in.next());
    		System.out.println(" Enter phone number");
    		student.setPhoneNumber(in.next());
    		
    		smenu.register(student);
    		//studentServices.addStudent(student, studentDataset);
        	//register.registration();
        break;
        case "4": exit = false;
        	System.out.println("Exiting!");
        	System.exit(0);
        break;
        default : System.out.println("Wrong entry! Please enter valid numeric input.");
        
        }
        
        
      }

        in.close();         
	}

}

/*
case "1"://get input here 
	
	String address;
	String branchName;
	student = studentDataset.get(userId);
	if(student == null) {
		System.out.println("Some error occoured. Please retry after creating user.");
    	CRSApplicationMenu.main(null);}
	System.out.println("Hi, "+student.getStudentName());
	System.out.println("Enter Address : ");
	address = in.next();
	System.out.println("Enter Branch Name : ");
	branchName = in.next(); 
	studentServices.addStudent(student, studentDataset);
break;

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
		studentServices.addStudent(student, studentDataset);
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
*/