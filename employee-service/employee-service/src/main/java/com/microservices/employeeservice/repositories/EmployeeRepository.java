package com.microservices.employeeservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.employeeservice.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee , Long >{
	
	List<Employee> findAll();

}
