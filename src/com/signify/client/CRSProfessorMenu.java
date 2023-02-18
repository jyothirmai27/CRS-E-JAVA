package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Professor;
import com.signify.service.GradeCardInterface;
import com.signify.service.GradeCardServices;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;
import com.signify.service.SemesterRegistrationServices;

public class CRSProfessorMenu {
	public void display() throws IOException {
	
        System.out.println("\tWELCOME TO PROFESSOR PANEL");         
        System.out.println("--------------------------------------------------------------- ");  
        
        //Object creation
        Scanner in = new Scanner (System.in);
        ProfessorInterface professorService = new ProfessorService();
        GradeCardInterface gradeCardServices = new GradeCardServices();
        Professor professor = new Professor();
        
        
        boolean exit = true;
        while(exit) {
        System.out.println("------------------------------------------------------");  
        System.out.println("Press\n"
        		+ "1. ADD GRADES\r\n"
        		+ "2. VIEW ENROLLED STUDENTS\r\n"
        		+ "3. APPLY AS INSTRUCTOR FOR COURSE\r\n"
        		+ "4. EDIT USER DETAILS\r\n"
        		+ "5. EXIT PORTAL");
        String choice = in.next();
        switch(choice) {
        case "1":gradeCardServices.addGrades();
        break;
        case "2":professorService.viewEnrolledStudents();
        break;
        case "3":professorService.selectCourse();
        break;
        case "4"://get details and pass professor object
        	professorService.editDetails(); 
        break;
        case "5": exit = false;
        	CRSApplicationMenu.main(null);
        break;
        default :System.out.println("Enter valid numeric input.");
        }
      }
	}
}


