/**
 * 
 */
package com.signify.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.signify.bean.Admin;
import com.signify.bean.Student;
import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public class AdminCollection {
	static Map<String, Admin> adminDataset = new HashMap<>();
	
	public static boolean update(Admin old, Admin admin) {
		if(adminDataset.containsKey(old.getAdminId())) {
			adminDataset.remove(old.getAdminId());
			AdminCollection.add(admin);
			return true;}
		return false;
	}
	public static boolean remove(Admin admin) {
		if(adminDataset.containsKey(admin.getAdminId())) {
			adminDataset.remove(admin.getAdminId());
			return true;}
		return false;
	}
	public static boolean add( Admin admin)
	{
		if(UserCollection.exists(admin.getAdminId()))
			return false;
		adminDataset.put(admin.getAdminId(), admin);
		User user = new User();
		user.setName(admin.getAdminName());
		user.setRole("Admin");
		user.setUserId(admin.getAdminId());
		user.setPassword(admin.getPassword());
		UserCollection.add(user);
		return true;
	}

	public static void print()
	{
		for (String key: adminDataset.keySet()) {  
		     
			Admin admin = adminDataset.getOrDefault(key, null);
			System.out.println(admin.getAdminId() +" \t\t "+admin.getAdminName());
		}
	}

}
