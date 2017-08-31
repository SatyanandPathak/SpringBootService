package com.satya.spring.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.spring.boot.model.Course;
import com.satya.spring.boot.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> getCourses(){
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
		
	}
	
	public Course getCourse(String id){
		return courseRepository.findOne(id);
				
	}
	
	public Course addCourse(Course course){
		return courseRepository.save(course);
	}
	
	public void deleteCourse(String id){
		Course course = courseRepository.findOne(id);
		courseRepository.delete(course);
	}
	
	public void updateCourse(Course course, String id){
		courseRepository.save(course);
	}
	
}
