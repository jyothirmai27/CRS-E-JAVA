/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Student;
import com.signify.service.SemesterRegistrationServices;
import com.signify.service.StudentServices;

/**
 * @author BHAVISH
 *
 */
public class StudentMenu {

	public void display() throws IOException {
		System.out.println("\tWELCOME TO STUDENT PANEL");

        Scanner ob = new Scanner (System.in);

        while(true) {
            
        System.out.println("---------------------------------------------------- "); 
        System.out.println("1. ADD COURSE\r\n"
        		+ "2. DROP COURSE\r\n"
        		+ "3. UPDATE PASSWORD\r\n"
        		+ "4. EXIT");
        String choice;
        if(ob.hasNext())
        {
        	//System.out.println("hi");
        	choice = ob.next();
        switch(choice){
        case "1": System.out.println("Course added");
        	//StudentServices.addCourse();
        	//in.close();
        break;
        case "2":System.out.println("Course dropped"); 
        	//StudentServices.dropCourse();
        break;
        case "3":System.out.println("Changed details");
        //StudentServices.editDetails();
		break;
        case "4": CRSApplicationMenu.main(null);
		default: System.out.println("Enter valid numeric input");
        }}}
        
	}
}
