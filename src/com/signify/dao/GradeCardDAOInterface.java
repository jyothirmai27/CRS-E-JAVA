package com.signify.dao;

public interface GradeCardDAOInterface {

	public void update(String userId);
	public void view(String userId);
	public void generate();
	public void viewgrades(String userId,Double cpi);
}
