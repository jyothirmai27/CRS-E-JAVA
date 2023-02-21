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
	
	public void update(String update, String id, String field);
	public void insert(int id, Professor professor);
	public void delete(String profeessorId);
	public void view(String query);
	

}
