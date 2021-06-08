package com.microservices.employeeservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeservice.entities.Employee;
import com.microservices.employeeservice.services.EmployeeService;

@RestController("/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		System.out.println(employee);
		Employee tempEmployee = employeeService.save(employee);

		if (tempEmployee != null) {
			return new ResponseEntity<Employee>(tempEmployee, HttpStatus.OK);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {

	
		List<Employee> tempEmployee = employeeService.findAll();

		if (tempEmployee != null) {
			return new ResponseEntity<List<Employee>>(tempEmployee, HttpStatus.OK);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/employees/{employee_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name = "employee_id") Long employeeId) {

		return null;
	}

	@PutMapping("/employees/{employee_id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
			@PathVariable(name = "employee_id") Long employeeId) {

		Employee tempEmployee = employeeService.update(employee, employeeId);

		if (tempEmployee != null) {
			return new ResponseEntity<Employee>(tempEmployee, HttpStatus.OK);
		}

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/employees/{employee_id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(name = "employee_id") Long employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);

		if (tempEmployee != null) {
			return new ResponseEntity<Employee>(tempEmployee, HttpStatus.OK);
		}

		return ResponseEntity.noContent().build();
	}

}
