/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Student;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentInterface;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class CRSStudentMenu {

	public void display() throws IOException {
		System.out.println("\tWELCOME TO STUDENT PANEL");

        Scanner in = new Scanner (System.in);
        StudentInterface studentServices = new StudentServices();
        Student student = new Student();

        
        
        boolean exit = true;
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("Press\n"
        		+ "1. ENTER DETAILS\r\n"
        		+ "2. REGISTER FOR SEMESTER\r\n"
        		+ "3. ADD COURSE\r\n"
        		+ "4. DROP COURSE\r\n"
        		+ "5. VIEW COURSE CATALOG\r\n"
        		+ "6. VIEW GRADES\r\n"
        		+ "7. MAKE FEE PAYMENT\r\n"
        		+ "8. EDIT USER DETAILS\r\n"
        		+ "9. EXIT PORTAL");
        String choice = in.next();
        switch(choice) {
        case "1"://get input here 
        	studentServices.addStudent(student);
        break;
        case "2":studentServices.registerToCourse();
        break;
        case "3":studentServices.addCourse();
        break;
        case "4":studentServices.dropCourse();
        break;
        case "5":studentServices.viewCatelogs();
        break;
        case "6":studentServices.viewGrades();
        break;
        case "7":studentServices.makePayment();
        break;
        case "8":studentServices.editDetails();
        break;
        case "9": exit = false;
        	CRSApplicationMenu.main(null);
        break;
        default :System.out.println("Enter valid numeric input.");
        }
      }
        
	}
}
