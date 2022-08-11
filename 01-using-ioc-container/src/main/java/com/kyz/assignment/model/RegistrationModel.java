package com.kyz.assignment.model;

import java.util.List;

import com.kyz.assignment.domain.Registration;

public interface RegistrationModel {
   List<Registration> findByClass(int id); 
   
   void save(Registration re);
   
}
