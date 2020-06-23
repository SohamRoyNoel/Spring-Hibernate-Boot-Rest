package com.example.relational.BootRelations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.relational.BootRelations.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select p from Employee p where p.Emp_Name= :name")
    public Employee findByname(@Param("name") String name);
	
}
