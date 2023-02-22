/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Admin;
import com.signify.exception.AdminDoesntExistException;

/**
 * @author BHAVISH
 *
 */
public interface AdminDAOInterface {
	
	public void update(String query);
	public void add(int id, Admin admin);
	public void remove(String adminId) throws AdminDoesntExistException;
	public void view(String query);

}
