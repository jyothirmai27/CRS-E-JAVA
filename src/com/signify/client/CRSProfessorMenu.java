package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Professor;
import com.signify.service.SemesterRegistrationServices;

public class CRSProfessorMenu {
	public void display() throws IOException {
	
        System.out.println("\tWELCOME TO PROFESSOR PANEL");         
        System.out.println("--------------------------------------------------------------- ");  
        Scanner in = new Scanner (System.in);
        while(true) {
        System.out.println("1. ADD GRADES\r\n"
        		+ "2. VIEW STUDENTS\r\n"
        		+ "3. UPDATE PASSWORD\r\n"
        		+ "4. EXIT ");
        String choice = in.next();
        switch(choice){
        case "1":  System.out.println("Course Graded");
        break;
        case "2": System.out.println("List of Students");
        break;
        case "3": Professor professor = new Professor();
    	System.out.println("Enter new Password");
    	String password = in.next();
		professor.setPassword(password);
		break;
        case "4":CRSApplicationMenu.main(null);
		default: System.out.println("Enter valid numeric input");
        }
        }
	}
}


