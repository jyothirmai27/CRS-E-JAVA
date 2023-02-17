/**
 * 
 */
package com.signify.collection;

import java.util.HashSet;
import java.util.Set;

import com.signify.bean.Admin;

/**
 * @author BHAVISH
 *
 */
public class AdminCollection {
	Set<Admin> AdminDataset = new HashSet<>();
	public void add(Admin a)
	{
		AdminDataset.add(a);
	}
	public void print()
	{
		for(Admin a: AdminDataset)
		{
			System.out.println(a.getAdminId());
			System.out.println(a.getPassword());
		}
	}

}
