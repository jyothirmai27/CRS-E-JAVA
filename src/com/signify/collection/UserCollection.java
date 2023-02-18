/**
 * 
 */
package com.signify.collection;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;

import com.signify.bean.User;

/**
 * @author BHAVISH
 *
 */
public class UserCollection {
	
	static Map<String, User> authentication = new HashMap<>();
	//Set<Integer> usersData = new HashSet<>();
	public static void add(User user)
	{
		authentication.put(user.getUserId(), user);
		//usersData.add(user.getUserId());
	}
	public static boolean exists(String userId) {
		return authentication.containsKey(userId);
	}
	public static String Authenticate(User user)
	{
		User user1 = authentication.get(user.getUserId());
		if(authentication.containsKey(user.getUserId()))  
			if (user1.getPassword().equals(user.getPassword())) {
				   // System.out.println(authentication.get(user.getUserId())+" -- "+user.getPassword());
				     user.setName(user1.getName());
					return user1.getRole();}
			else {
			    //System.out.println(authentication.get(user.getUserId())+" -- "+user.getPassword());
				return "wrongPassword";}
						
			return "";
	
		
	}

}
