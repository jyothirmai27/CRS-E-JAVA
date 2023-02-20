/**
 * 
 */
package com.signify.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.collection.CatalogCollection;
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
        case "1":studentServices.registerToCourse(); //todo
        break;
        case "2":

			if(CatalogCollection.isEmpty())
				System.out.println("No courses yet. Please wait for course allocation.");
			else {
				CatalogCollection.printCourses();
				System.out.println("Enter course code you want to add.");
				String code = in.next();
				if(CatalogCollection.get(code)== null)
					System.out.println("Enter valid course code");
	        	studentServices.addCourse(userId,code);
			}
			 //todo
        break;
        case "3":
        	Student student2 = new Student();
        	student2 = StudentCollection.get(userId);
    		
    		List<String> selected = new ArrayList<String>();
    		selected = student2.getRegisteredCourses();
        	if(selected.isEmpty())
				System.out.println("No courses yet. Please add course first.");
			else {

				Course c = new Course();
				for (String code : selected) {
					c = CatalogCollection.get(code);
					System.out.println("Course Code : "+c.getCourseCode()+"\t"+"Course Name : "+c.getCourseName());
				}
				System.out.println("Enter course code you want to remove.");
				String code = in.next();
				//if(CatalogCollection.get(code)== null)
				//	System.out.println("Enter valid course code");
				studentServices.dropCourse(userId, code);
			}
        	 //todo
        break;
        case "4":studentServices.viewCatelogs();
        break;
        case "5":studentServices.viewGrades(userId); //todo
        break;
        case "6":studentServices.makePayment();
        break;
        case "7":
            Student student = new Student();
        	student = StudentCollection.get(userId);
        	if(student == null) {
        		System.out.println("Some error occoured. Please retry.");
            	CRSApplicationMenu.main(null);}
        	System.out.println("Hi, "+student.getStudentName()+"\n");
             while(true) {
             System.out.println("------------------------------------------------------");
        	System.out.println("Press\n"
            		+ "1. EDIT NAME\r\n"
            		+ "2. EDIT ADDRESS\r\n"
            		+ "3. EDIT BRANCH NAME\r\n"
            		+ "4. CHANGE PASSWORD\r\n"
            		+ "5. EDIT BATCH\r\n"
            		+ "6. EDIT PHONE NUMBER\r\n"
            		+ "7. EXIT PORTAL");
        	String field = in.next();
        	if(field.equals("7")) 
            	studentServices.editDetails(userId, field, "");
        	else{
            	System.out.println("Enter correction : ");
            	String correction = in.next();
            	studentServices.editDetails(userId, field, correction);}
        		
             }
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
