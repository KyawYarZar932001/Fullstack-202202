package com.kyz.assignment.model;

import java.util.List;

import com.kyz.assignment.domain.OpenClass;

public interface OpenClassModel {
	
	List<OpenClass>findByCourse(int courseId);
	
	void create(OpenClass openClass); 
	OpenClass findById(int id); 
}
