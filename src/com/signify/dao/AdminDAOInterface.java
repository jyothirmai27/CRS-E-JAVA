/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Admin;

/**
 * @author BHAVISH
 *
 */
public interface AdminDAOInterface {
	
	public void update(String query);
	public void add(int id, Admin admin);
	public void remove(String adminId);
	public void view(String query);

}
