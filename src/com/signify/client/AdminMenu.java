/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.service.AdminServices;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class AdminMenu {
	public void display() throws IOException {
    System.out.println("\tWELCOME TO STUDENT PANEL");        
    
    Scanner in = new Scanner (System.in);
    

    while(true) {
    	System.out.println("---------------------------------------------------------");  
    System.out.println( "1. APPROVE STUDENT\r\n"
    		+ "2. ADD COURSE\r\n"
    		+ "3. ADD PROFESSOR\r\n"
    		+ "4. ADD ADMIN\r\n"
    		+ "5. GENERATE REPORT CARD\r\n"
    		+ "6. EXIT");
    String choice = in.next();
    switch(choice){
    case "1": AdminServices.approveStudent();
    break;
    case "2": AdminServices.addCourse();
    break;
    case "3":AdminServices.addProfessor();
	break;
    case "4":AdminServices.addAdmin();
	break;
    case "5":AdminServices.generateReportCard();
	break;
    case "6":CRSApplicationMenu.main(null);
    break;
	default: System.out.println("Enter valid numeric input");
    }
    in.close();
}
}
}
