package com.microservices.employeeservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.employeeservice.entities.Employee;
import com.microservices.employeeservice.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {

		if (employee != null) {
			return employeeRepository.save(employee);
		}

		return null;
	}

	public Employee findById(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	public Employee deleteById(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());

			return employee.get();
		}
		return null;
	}

	public Employee update(Employee employee, Long id) {
		Optional<Employee> tempEmployee = employeeRepository.findById(id);

		if (tempEmployee.isPresent()) {
			return employeeRepository.save(employee);

		}
		return null;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
}
