/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Student;
import com.signify.collection.StudentCollection;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class CRSStudentMenu {


    StudentInterface studentServices = new StudentServices();
    Student student = new Student();
    //StudentCollection studentDataset = new StudentCollection();
	
	public void display(String userId) throws IOException {
		System.out.println("\tWELCOME TO STUDENT PANEL");

        Scanner in = new Scanner (System.in);
        
        
        boolean exit = true;
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("Press\n"
        		+ "1. REGISTER FOR SEMESTER\r\n"
        		+ "2. ADD COURSE\r\n"
        		+ "3. DROP COURSE\r\n"
        		+ "4. VIEW COURSE CATALOG\r\n"
        		+ "5. VIEW GRADES\r\n"
        		+ "6. MAKE FEE PAYMENT\r\n"
        		+ "7. EDIT USER DETAILS\r\n"
        		+ "8. EXIT PORTAL");
        String choice = in.next();
        switch(choice) {
        case "1":studentServices.registerToCourse();
        break;
        case "2":studentServices.addCourse();
        break;
        case "3":studentServices.dropCourse();
        break;
        case "4":studentServices.viewCatelogs();
        break;
        case "5":studentServices.viewGrades();
        break;
        case "6":studentServices.makePayment();
        break;
        case "7":
        	String address;
        	String branchName;
        	student = StudentCollection.get(userId);
        	if(student == null) {
        		System.out.println("Some error occoured. Please retry after creating user.");
            	CRSApplicationMenu.main(null);}
        	System.out.println("Hi, "+student.getStudentName());
        	System.out.println("Enter Address : ");
        	address = in.next();
        	System.out.println("Enter Branch Name : ");
        	branchName = in.next(); 
        	student.setAddress(address);
        	student.setBranchName(branchName);
        	studentServices.addStudent(student);
        	studentServices.editDetails();
        break;
        case "8": exit = false;
        	CRSApplicationMenu.main(null);
        break;
        default :System.out.println("Enter valid numeric input.");
        }
      }
        
	}
	
	public void register(Student student) {
		if(studentServices.addStudent(student))
			System.out.println("Regitration Succesful. Waiting for Approval.");
		else
			System.out.println("This user Id already exists.");
		//return true;
	}
}
