package com.satya.spring.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.spring.boot.model.Employee;
import com.satya.spring.boot.repository.EmployeeRepository;


@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employees::add);
		return employees;
		
	}
	
	public Employee addEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployee(String id){
		return employeeRepository.findOne(id);
	}

}
