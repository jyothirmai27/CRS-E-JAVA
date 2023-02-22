/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.dao.CourseRegistrationDAOImplementation;
import com.signify.dao.CourseRegistrationDAOInterface;
import com.signify.dao.PaymentDAOImplementation;
import com.signify.dao.PaymentDAOInterface;
import com.signify.exception.NoCourseException;
import com.signify.exception.UserNotFoundException;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class CRSStudentMenu {

	CourseDAOInterface courseDataset = new CourseDAOImplementation();
	CourseRegistrationDAOInterface coursesDataset = new CourseRegistrationDAOImplementation();
    StudentInterface studentServices = new StudentServices();
    Payment payment = new Payment();
    //StudentCollection studentDataset = new StudentCollection();
	
	public void display(String userId) {
		System.out.println("\tWELCOME TO STUDENT PANEL");

        Scanner in = new Scanner (System.in);
        
        
        boolean exit = true;
     
    	   while(exit) {
    	        System.out.println("------------------------------------------------------");  
    	        System.out.println("Press\n"
    	        		+ "1. ADD COURSE\r\n"
    	        		+ "2. DROP COURSE\r\n"
    	        		+ "3. VIEW COURSE CATALOG\r\n"
    	        		+ "4. VIEW GRADES\r\n"
    	        		+ "5. MAKE FEE PAYMENT\r\n"
    	        		+ "6. EDIT USER DETAILS\r\n"
    	        		+ "7. EXIT PORTAL");
    	        String choice = in.next();
    	        switch(choice) {
    	        case "1":
    	        	
    	        	try {
						courseDataset.view();
    					System.out.println("Enter course code you want to add.");
    					String code = in.next();
    					
    		        	studentServices.addCourse(userId,code);
					} catch (NoCourseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				 
    	        break;
    	        case "2":
    	        	
    	        		coursesDataset.viewCourses(userId);
    					System.out.println("Enter course code you want to remove.");
    					
    					//if(CatalogCollection.get(code)== null)
    					//	System.out.println("Enter valid course code");
    					studentServices.dropCourse(userId, in.next());
    				
    	        	 //todo
    	        break;
    	        case "3":studentServices.viewCatelogs();
    	        break;
    	        case "4":
    	        	studentServices.viewGrades(userId); //todo
    	        break;
    	        case "5":System.out.println("Enter Mode of Payment\n"
    	        		+ "1. ONLINE\r\n"
    	        		+ "2. OFFLINE\r\n"
    	        		+ "3. EXIT PORTAL\r\n");
    	        String choice2 = in.next();
    	        switch(choice2) {
    	        case "1":
    				 System.out.println("Enter upiId");
    				 String upiId = in.next();
    				 payment.setOffline(false);
    				 payment.setUpiId(upiId);
    				 payment.setStudentId(userId);
    		         studentServices.makePayment(userId, payment);
    				 
    	        break;
    	        case "2":
    	        	System.out.println("Enter cheque Number : ");
    	        	String chequeNumber = in.next();
    	        	payment.setOffline(true);
    				payment.setStudentId(userId);
    	        	payment.setChequeNumber(chequeNumber);
    	        	studentServices.makePayment(userId, payment);
    	        break;
    	        default :System.out.println("Enter valid numeric input.");
    	        }
    	        break;
    	        case "6":
    	             while(true) {
    	             System.out.println("------------------------------------------------------");
    	        	System.out.println("Press\n"
    	            		+ "1. EDIT NAME\r\n"
    	            		+ "2. EDIT ADDRESS\r\n"
    	            		+ "3. EDIT BRANCH NAME\r\n"
    	            		+ "4. EDIT BATCH\r\n"
    	            		+ "5. EDIT PHONE NUMBER\r\n"
    	            		+ "6. EXIT PORTAL");
    	        	String field = in.next();
    	        	if(field.equals("6")) 
    	            	studentServices.editDetails(userId, field, "");
    	        	else{
    	            	System.out.println("Enter correction : ");
    	            	String correction = in.next();
    	            	studentServices.editDetails(userId, field, correction);}
    	        		
    	             }
    	        case "7": exit = false;
    	        	CRSApplicationMenu.main(null);
    	        break;
    	        default :System.out.println("Enter valid numeric input.");
    	        }
    	   } 
    		
    	     
	}
    		
    		public void register(Student student, User user) {
    			if(studentServices.addStudent(student, user))
    				System.out.println("Regitration Succesful. Waiting for Approval.");
    			else
    				System.out.println("This user Id already exists.");
    			//return true;
    		
       }
}
