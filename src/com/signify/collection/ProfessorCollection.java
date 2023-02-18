/**
 * 
 */
package com.signify.collection;


import java.util.HashMap;
import java.util.Map;

import com.signify.bean.Professor;


/**
 * @author BHAVISH
 *
 */
public class ProfessorCollection {

	
	static Map<String, Professor> professorDataset = new HashMap<>();
	public static void add(Professor prof)
	{
		professorDataset.put(prof.getUserId(), prof);
	}
	public static Professor get(String key) {
		return professorDataset.getOrDefault(key, null);
	}
	public static void print()
	{
		for(Map.Entry map:professorDataset.entrySet()){  
			     
			Professor prof = (Professor) map.getValue();
			System.out.println(map.getKey());
			System.out.println(prof.getProfessorName());
			System.out.println(prof.getDesignation());
			System.out.println(prof.getDepartmentName());
		}
	}
	
}
