package com.satya.spring.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.satya.spring.boot.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
	public Employee findByEmployeeId(String id);

}
