/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Student;

/**
 * @author BHAVISH
 *
 */
public interface StudentDAOInterface {
	
	public void add(Student student);
	public void delete(String query);
	public void update(String query);
	public void view(String query);

}
