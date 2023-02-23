/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.User;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.NoCourseException;
import com.signify.exception.StudentNotFoundForApprovalException;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServices;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class CRSAdminMenu {
	public void display()  {
    System.out.println("\tWELCOME TO ADMIN PANEL");        
    
    Scanner in = new Scanner (System.in);
    AdminInterface adminServices = new AdminServices();
    CRSAdminMenu amenu = new CRSAdminMenu();
    Admin admin = new Admin();
	UserDAOInterface userDataset = new UserDAOImplementation();
	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	
    boolean exit = true;

        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("Press\n"
        		+ "1. STUDENT FUNCTIONS\r\n"
        		+ "2. PROFESSOR FUNCTIONS\r\n"
        		+ "3. COURSE FUNCTIONS\r\n"
        		+ "4. ADMIN ACCESS\r\n"
        		+ "5. EXIT PORTAL");
        String choice = in.next();
        switch(choice) {
        case "1":
        	 boolean exit1 = true;
        	    while(exit1) {
        	    System.out.println("------------------------------------------------------");  
        	    System.out.println("Press\n"
        	    		+ "1. APPROVE STUDENT REGISTRATION\r\n"
        	    		+ "2. VIEW ENROLLED STUDENTS\r\n"
        	    		+ "3. EXIT PORTAL");
        	    String choice1 = in.next();
        	    switch(choice1) {
        	    case "1":
        			//StudentCollection.printUnapproved();
        			try {
						userDataset.getUnapproved();
					} catch (StudentNotFoundForApprovalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			System.out.println("\n1.TO APPROVE ALL STUDENTS\n"+"2.APPROVE ONE STUDENT\n"+"3.EXIT\n");
        			 
        			String approve=in.next();
        			switch(approve)
        			{
        			case "1":
        				//System.out.println("To approve all the  Students");
        				adminServices.approveAllStudents();
        			break;
        			case "2":
        				System.out.println("Enter User id.");
    						adminServices.approveStudent(in.next());	
        			break;
        			case "3": System.out.println("Exiting.\n");
            	    	//amenu.display(); 
        			break;
        			default:
        		      	System.out.println("Please enter valid numeric input.");
        			}
        	    break;
        	    case "2":adminServices.viewEnrolledStudents();
        	    break;
        	    case "3": exit1 = false;
        	    	amenu.display(); 
        	    break;
        	    default :System.out.println("Enter valid numeric input.");
        	    }}
        break;
        case "2":
        	 boolean exit2 = true;
     	    while(exit2) {
     	    System.out.println("------------------------------------------------------");  
     	    System.out.println("Press\n"
     	    		+ "1. ADD NEW PROFESSOR\r\n"
     	    		+ "2. ASSIGN COURSE TO PROFESSOR\r\n"
     	    		+ "3. VIEW PROFESSORS\r\n"
     	    		+ "4. REMOVE PROFESSOR\r\n" 	    		
     	    		+ "5. EXIT PORTAL");
     	    String choice2 = in.next();
     	    switch(choice2) {
     	    case "1":Professor professor = new Professor();
     	    	System.out.println("Enter Professor Name : ");
     	    	professor.setProfessorName(in.next());
     	    	System.out.println("Enter Password :");
     	    	professor.setPassword(in.next());
     	    	System.out.println("Enter Professor Designatiion : ");
     	    	professor.setDesignation(in.next());
     	    	System.out.println("Enter Professor's Department : ");
     	    	professor.setDepartmentName(in.next());
     	    	System.out.println("Enter Phone number : ");
     	    	professor.setPhoneNumber(in.next());
     	    	//System.out.println("Enter Course code assigned :");
     	    	//professor.setAssignedCourse(in.next());
     	    	adminServices.addProfessor("", professor); 
     	    break;
     	    case "2":
     	    	try {
     	    		courseDataset.view();
     	    	}catch(NoCourseException e) {
     	    		
     	    	}
     	    	System.out.println("Enter the course code : ");
     	    	String courseCode = in.next();
     	    	System.out.println("Enter the professor id : ");
     	    	String professorId = in.next();
     	    	adminServices.assignCourse(courseCode, professorId); 
     	    break;
     	    case "3": adminServices.viewProfesssors();
        	break;
     	    case "4":
     	    	adminServices.viewProfesssors();
     	    	System.out.println("Enter Professor id : ");
     	    	adminServices.removeProfessor(in.next());
     	    break;
     	    case "5": exit2 = false;
    	    	amenu.display();
    	    break;
     	    default :System.out.println("Enter valid numeric input.");
     	    }}
        break;
        case "3":
        	 boolean exit3 = true;
      	    while(exit3) {
      	    System.out.println("------------------------------------------------------");  
      	    System.out.println("Press\n"
      	    		+ "1. ADD NEW COURSE\r\n"
      	    		+ "2. REMOVE COURSE\r\n"
      	    		+ "3. GENERATE REPORT CARD\r\n"
      	    		+ "4. VIEW COURSE CATALOG\r\n"
      	    		+ "5. EXIT PORTAL");
      	    String choice3 = in.next();
      	    switch(choice3) {
      	    case "1": 
      	    	Course course = new Course();
      	    	System.out.println("Enter Course Code : ");
      	    	course.setCourseCode(in.next());
      	    	System.out.println("Enter Course Name : ");
      	    	course.setCourseName(in.next());
      	    	System.out.println("Enter Department : ");
      	    	course.setDepartmentName(in.next());
      	    	System.out.println("Enter Semester:");
      	    	course.setSemester(in.next());
      	    	adminServices.addCourse(course); 
      	    break;
      	    case "2":
      	    	try {
					courseDataset.view();
	      	    	System.out.println("Enter course code for course to be removed : ");
	      	    	String courseCode = in.next();
	      	    	adminServices.dropCourse(courseCode); 
				} catch (NoCourseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
      	    break;
      	    case "3":adminServices.generateReportCard(); //todo
            break;
      	    case "4":adminServices.courseDetails();
      	    break;
      	    case "5": exit2 = false;
      	    	amenu.display();
      	    break;
      	    default :System.out.println("Enter valid numeric input.");
      	    }}
        break;
        case "4":
        	boolean exit4 = true;
      	    while(exit4) {
      	    System.out.println("------------------------------------------------------");  
      	    System.out.println("Press\n"
      	    		+ "1. ADD ADMIN\r\n"
      	    		+ "2. REMOVE ADMIN\r\n"
      	    		+ "3. UPDATE ADMIN DETAILS\r\n"
      	    		+ "4. EXIT PORTAL");
      	    String choice4 = in.next();
      	    switch(choice4) {
      	    case "1":
      	    	User user1 = new User();
      	    	Admin admin1 = new Admin();
    	    	System.out.println("Enter Name : ");
    	    	admin1.setAdminName(in.next());
    	    	System.out.println("Enter Password : ");
    	    	admin1.setPassword(in.next());
    			user1.setName(admin1.getAdminName());
    			user1.setRole("Admin");
    			user1.setUserId(admin1.getAdminId());
    			user1.setPassword(admin1.getPassword());
    	    	if(adminServices.addAdmin(admin1, user1))
    	    		System.out.println("Admin added.");
    	    	else
    	    		System.out.println("This user Id already exists.");
    	    	
      	    break;
      	    case "2":
      	    	Admin admin2 = new Admin();
      	    	System.out.println("Enter Name : ");
      	    	admin2.setAdminName(in.next());
      	    	System.out.println("Enter Admin Id : ");
      	    	admin2.setAdminId(in.next());
      	    	System.out.println("Enter Password : ");
      	    	admin2.setPassword(in.next());
      	    	adminServices.removeAdmin(admin2); 
      	    break;
      	    case "3":// input and create method
      	    	Admin old = new Admin();
      	    	Admin newAdmin = new Admin();
      	    	System.out.println("Enter old Name : ");
      	    	old.setAdminName(in.next());
      	    	System.out.println("Enter Admin Id : ");
      	    	old.setAdminId(in.next());
      	    	System.out.println("Enter old Password : ");
      	    	old.setPassword(in.next());
      	    	System.out.println("Enter new Name : ");
    	    	newAdmin.setAdminName(in.next());
    	    	newAdmin.setAdminId(old.getAdminId());
    	    	System.out.println("Enter new Password : ");
    	    	newAdmin.setPassword(in.next());
      	    	adminServices.editAdminDetails(old, newAdmin);
            break;
      	    case "4": exit2 = false;
      	    	amenu.display();
      	    break;
      	    default :System.out.println("Enter valid numeric input.");
      	    }}
        break;
        case "5": exit = false;
        	CRSApplicationMenu.main(null);
        break;
        default :System.out.println("Enter valid numeric input.");
        }
      }
    }
    

}
