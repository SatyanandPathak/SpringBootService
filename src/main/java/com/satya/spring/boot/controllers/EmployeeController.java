package com.satya.spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satya.spring.boot.model.Employee;
import com.satya.spring.boot.services.EmployeeServices;


@RestController
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "http://127.0.0.1:8887")
//@CrossOrigin(origins = "http://127.0.0.1")
public class EmployeeController {
	
	@Autowired
	private EmployeeServices employeeServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		return employeeServices.getEmployees();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee){
		
		return employeeServices.addEmployee(employee);
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable String id){
	
		return employeeServices.getEmployee(id);
	}

}
