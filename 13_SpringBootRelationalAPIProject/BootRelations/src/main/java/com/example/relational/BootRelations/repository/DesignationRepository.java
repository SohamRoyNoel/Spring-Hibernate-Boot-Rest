package com.example.relational.BootRelations.repository;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relational.BootRelations.models.Designation;


public interface DesignationRepository extends JpaRepository<Designation, Integer> {

	
	
}

