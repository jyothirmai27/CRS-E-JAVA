package com.signify.dao;

import com.signify.exception.NoCourseRegisteredException;

public interface GradeCardDAOInterface {

	public void update(String userId);
	public void view(String userId) throws NoCourseRegisteredException;
	public void generate() throws NoCourseRegisteredException;
	public void viewgrades(String userId,Double cpi);
}
