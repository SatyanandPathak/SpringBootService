package com.satya.spring.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.satya.spring.boot.model.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String>{

}
