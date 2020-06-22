package com.example.relational.BootRelations.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.relational.BootRelations.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
