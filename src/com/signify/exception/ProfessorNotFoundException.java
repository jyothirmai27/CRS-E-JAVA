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
	       System.out.println("Professor Not Found : "+professorName);
	   }
}
