/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Professor;
import com.signify.exception.ProfessorNotFoundException;

/**
 * @author BHAVISH
 *
 */
public interface ProfessorDAOInterface {
	
	public void update(String update, String id, String field);
	public void insert(int id, Professor professor);
	public void delete(String profeessorId) throws ProfessorNotFoundException;
	public void view(String query);
	public boolean getProfessor(String userId) throws ProfessorNotFoundException;

}
