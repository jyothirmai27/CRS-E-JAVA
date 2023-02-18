/**
 * 
 */
package com.signify.collection;


import java.util.HashMap;
import java.util.Map;

import com.signify.bean.Professor;
import com.signify.bean.User;


/**
 * @author BHAVISH
 *
 */
public class ProfessorCollection {

	
	static Map<String, Professor> professorDataset = new HashMap<>();
	public static void update(String userId, Professor prof) {
		professorDataset.put(userId, prof);
	}
	public static boolean add(String userId,Professor prof)
	{
		professorDataset.put(prof.getUserId(), prof);
		if(UserCollection.exists(userId))
			return false;
		professorDataset.put(userId, prof);
		User user = new User();
		user.setName(prof.getProfessorName());
		user.setRole("Professor");
		user.setUserId(prof.getUserId());
		user.setPassword(prof.getPassword());
		UserCollection.add(user);
		return true;
	}
	public static Professor get(String key) {
		return professorDataset.getOrDefault(key, null);
	}
	public static String getProfesssorName(String key) {
		Professor professor = professorDataset.getOrDefault(key, null);
		if(professor == null)
			return "nil";
		else 
			return professor.getProfessorName();
	}
	public static void updateCourse(String professorId, String courseCode) {
		Professor professor = ProfessorCollection.get(professorId);
		professor.setAssignedCourse(courseCode);
		ProfessorCollection.update(professorId, professor);
		
	}
	public static void print()
	{
		 for (String key: professorDataset.keySet()) {  
		     
			 Professor prof = professorDataset.getOrDefault(key, null);
				System.out.println("Sr No. \t\t Name \t\t Designation \t\t Department \t\t Course ");
				System.out.println(prof.getUserId() +" \t\t "+prof.getProfessorName()+" \t\t "+prof.getDesignation()+" \t\t "+prof.getDepartmentName()+" \t\t "+prof.getAssignedCourse());
				//System.out.println(demo.getOrDefault(key,"not working"));
			}
	}
	
}
