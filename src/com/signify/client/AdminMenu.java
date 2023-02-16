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
    System.out.println("WELCOME TO STUDENT PANEL");        
    System.out.println("---------------------- ");  
    Scanner in = new Scanner (System.in);
    

    while(true) {
    System.out.println( "1 to Approve Student\r\n"
    		+ "2 to Add course\r\n"
    		+ "3 to Add Professor\r\n"
    		+ "4 to Add Admin\r\n"
    		+ "5 to Generate Report Card\r\n"
    		+ "16 to Exit");
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
