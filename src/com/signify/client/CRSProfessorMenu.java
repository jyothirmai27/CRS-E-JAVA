package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Professor;
import com.signify.bean.Student;

import com.signify.dao.CourseDAOImplementation;
import com.signify.dao.CourseDAOInterface;
import com.signify.service.GradeCardInterface;
import com.signify.service.GradeCardServices;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorService;
import com.signify.service.SemesterRegistrationServices;

public class CRSProfessorMenu {
	public void display(String userId) throws IOException {
	
        System.out.println("\tWELCOME TO PROFESSOR PANEL");         
        System.out.println("--------------------------------------------------------------- ");  
        
        //Object creation
        Scanner in = new Scanner (System.in);
        ProfessorInterface professorService = new ProfessorService();
        GradeCardInterface gradeCardServices = new GradeCardServices();
        CourseDAOInterface courseDataset = new CourseDAOImplementation();
       // Professor professor = new Professor();
        
        
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
        case "1":
        	
        	courseDataset.view();
        	
        	System.out.println("Enter Course code : ");
        	professorService.changeGrade(in.next());

        break;
        case "2":professorService.viewEnrolledStudents();
        break;
        case "3":
        	courseDataset.view();
        	System.out.println("Enter course code to be assigned");
        	String code = in.next();
        	professorService.selectCourse(); //todo
        break;
        case "4":
              while(true) {
              System.out.println("------------------------------------------------------");
         	System.out.println("Press\n"
             		+ "1. EDIT NAME\r\n"
             		+ "2. EDIT DESIGNATION\r\n"
             		+ "3. EDIT DEPARTMRNT NAME\r\n"
             		+ "4. EDIT PHONE NUMBER\r\n"
             		+ "5. EXIT PORTAL");
         	String field = in.next();
         	if(field.equals("5")) 
             	professorService.editDetails(userId, field, "");
         	else{
             	System.out.println("Enter correction : ");
             	String correction = in.next();
             	professorService.editDetails(userId, field, correction);
             	}
              }
        case "5": exit = false;
        	CRSApplicationMenu.main(null);
        break;
        default :System.out.println("Enter valid numeric input.");
        }
      }
	}
}


