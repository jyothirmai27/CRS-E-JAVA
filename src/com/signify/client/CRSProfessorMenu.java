package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Professor;
import com.signify.service.SemesterRegistrationServices;

public class CRSProfessorMenu {
	public void display() throws IOException {
	
        System.out.println("WELCOME TO PROFESSOR PANEL");         
        System.out.println("---------------------- ");  
        Scanner in = new Scanner (System.in);
        while(true) {
        System.out.println("1. add course\r\n"
        		+ "2. drop course\r\n"
        		+ "3. Update password\r\n"
        		+ "4. Exit");
        String choice = in.next();
        switch(choice){
        case "1":  System.out.println("Course added");
        break;
        case "2": System.out.println("Course dropped");
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


