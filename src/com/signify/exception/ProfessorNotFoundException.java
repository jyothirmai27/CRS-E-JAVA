/**
 * 
 */
package com.signify.exception;

/**
 * @author BHAVISH
 *
 */
public class ProfessorNotFoundException extends Exception{
	private String professorName ;
	   public ProfessorNotFoundException(String professorName)
	   {
		   super();
	       System.out.println("Professor Not Found : "+professorName);
	   }
}
