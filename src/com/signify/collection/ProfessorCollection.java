/**
 * 
 */
package com.signify.collection;


import java.util.HashSet;
import java.util.Set;

import com.signify.bean.Professor;


/**
 * @author BHAVISH
 *
 */
public class ProfessorCollection {

	Set<Professor> professorDataset = new HashSet<>();
	public void add(Professor cus) {
		professorDataset.add(cus);
	
		
		
	}
	public void print() {
		for(Professor prof : professorDataset) {
		System.out.println(prof.getProfessorName());
		System.out.println(prof.getDesignation());
		System.out.println(prof.getDepartmentName());
		}
	}
	
}
