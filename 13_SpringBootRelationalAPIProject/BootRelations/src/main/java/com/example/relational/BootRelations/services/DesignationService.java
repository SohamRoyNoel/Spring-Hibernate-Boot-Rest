package com.example.relational.BootRelations.services;

import java.util.List;
import java.util.Optional;

import com.example.relational.BootRelations.models.Designation;
import com.example.relational.BootRelations.models.Employee;


public interface DesignationService {

	List<Designation> findAllDesignation();

	Designation findDesignation(int id);

	Designation addDesignation(Designation degs);

	//void deleteuser(int id);
	
	

}
