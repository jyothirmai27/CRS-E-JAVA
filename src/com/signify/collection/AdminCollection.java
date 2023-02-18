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
	static Set<Admin> AdminDataset = new HashSet<>();
	public static void add(Admin a)
	{
		AdminDataset.add(a);
	}

	public static void print()
	{
		for(Admin a: AdminDataset)
		{
			System.out.println(a.getAdminId());
			System.out.println(a.getPassword());
		}
	}

}
