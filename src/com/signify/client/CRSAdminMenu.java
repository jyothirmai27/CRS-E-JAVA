/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Admin;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServices;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class CRSAdminMenu {
	public void display() throws IOException {
    System.out.println("\tWELCOME TO ADMIN PANEL");        
    
    Scanner in = new Scanner (System.in);
    AdminInterface adminServices = new AdminServices();
    CRSAdminMenu amenu = new CRSAdminMenu();
    Admin admin = new Admin();
	

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
    	    case "1": adminServices.approveStudent();
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
 	    		+ "3. EXIT PORTAL");
 	    String choice2 = in.next();
 	    switch(choice2) {
 	    case "1": adminServices.addProfessor();
 	    break;
 	    case "2":adminServices.assignCourse();
 	    break;
 	    case "3": exit2 = false;
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
  	    		+ "4. EXIT PORTAL");
  	    String choice3 = in.next();
  	    switch(choice3) {
  	    case "1": adminServices.addCourse();
  	    break;
  	    case "2":adminServices.dropCourse();
  	    break;
  	    case "3":adminServices.generateReportCard();
        break;
  	    case "4": exit2 = false;
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
  	    case "1": //get admin details as input
  	    	adminServices.addAdmin(admin);
  	    break;
  	    case "2"://input
  	    	adminServices.removeAdmin(admin);
  	    break;
  	    case "3":// input and create method
  	    	adminServices.addAdmin(admin);
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
