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
	public void add(Admin admin);
	public void remove(String adminId);
	public void view(String query);

}
