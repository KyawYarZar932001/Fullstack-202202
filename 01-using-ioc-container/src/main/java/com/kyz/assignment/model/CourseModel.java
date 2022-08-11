package com.kyz.assignment.model;

import java.util.List;

import javax.sql.DataSource;

import com.kyz.assignment.domain.Course;

public interface CourseModel {
	List<Course> getAll();
	void save (Course course);
	
	Course findById(int id);
	

}
