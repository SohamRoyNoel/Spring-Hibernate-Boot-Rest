package com.example.relational.BootRelations.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.relational.BootRelations.models.Designation;
import com.example.relational.BootRelations.models.Employee;
import com.example.relational.BootRelations.repository.DesignationRepository;
import com.example.relational.BootRelations.repository.EmployeeRepository;

@Service
public class DesignationServiceImpl implements DesignationService {

	private DesignationRepository designationRepository;
	


	@Autowired
	public DesignationServiceImpl(DesignationRepository designationRepository) {
		this.designationRepository = designationRepository;
	}

	@Override
	public List<Designation> findAllDesignation() {
		return designationRepository.findAll();
	}

	@Override
	public Designation findDesignation(int id) {
		return designationRepository.getOne(id);
	}

	@Override
	public Designation addDesignation(Designation degs) {
		return designationRepository.save(degs);
	}
	
	
	
}
