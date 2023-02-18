package com.signify.client;

import java.io.IOException;
import java.util.Scanner;

import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.collection.ProfessorCollection;
import com.signify.collection.StudentCollection;
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
        case "1":gradeCardServices.addGrades(); //todo
        break;
        case "2":professorService.viewEnrolledStudents();
        break;
        case "3":professorService.selectCourse(); //todo
        break;
        case "4":
        	Professor professor = new Professor();
         	professor = ProfessorCollection.get(userId);
         	if(professor == null) {
         		System.out.println("Some error occoured. Please retry.");
             	CRSApplicationMenu.main(null);}
         	System.out.println("Hi, "+professor.getProfessorName()+"\n");
              while(true) {
              System.out.println("------------------------------------------------------");
         	System.out.println("Press\n"
             		+ "1. EDIT NAME\r\n"
             		+ "2. EDIT DESIGNATION\r\n"
             		+ "3. EDIT DEPARTMRNT NAME\r\n"
             		+ "4. CHANGE PASSWORD\r\n"
             		+ "5. EDIT PHONE NUMBER\r\n"
             		+ "6. EXIT PORTAL");
         	String field = in.next();
         	if(field.equals("6")) 
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


