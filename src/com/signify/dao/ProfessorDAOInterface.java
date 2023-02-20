/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Professor;

/**
 * @author BHAVISH
 *
 */
public interface ProfessorDAOInterface {
	
	public void update(String query);
	public void insert(Professor professor);
	public void delete(String profeessorId);
	public void view(String query);
	

}
