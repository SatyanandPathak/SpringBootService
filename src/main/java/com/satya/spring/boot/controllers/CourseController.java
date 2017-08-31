package com.satya.spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satya.spring.boot.model.Course;
import com.satya.spring.boot.services.CourseService;


@RestController
@RequestMapping(value = "/topics/{id}/courses")
public class CourseController {
	private static final String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET, produces = JSON_TYPE)
	public List<Course> getCourses(@PathVariable String id){
		return courseService.getCourses();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = JSON_TYPE)
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = JSON_TYPE, produces = JSON_TYPE)
	public Course addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = JSON_TYPE, produces = JSON_TYPE)
	public void updateCourse(@PathVariable String id, @RequestBody Course course){
		courseService.updateCourse(course, id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}

}
