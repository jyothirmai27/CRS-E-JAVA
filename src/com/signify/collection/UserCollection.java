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
	
	Map<Integer, String> authentication = new HashMap<>();
	//Set<Integer> usersData = new HashSet<>();
	public void add(User user)
	{
		authentication.put(user.getUserId(), user.getPassword());
		//usersData.add(user.getUserId());
	}
	public boolean Authenticate(User user)
	{
		if(authentication.containsKey(user.getUserId())) 
			if (authentication.get(user.getUserId())== user.getPassword())
					return true;
			return false;
	
		
	}

}
