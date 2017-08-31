package com.satya.spring.boot.model;

import org.springframework.data.annotation.Id;

//import javax.persistence.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Course {
	@Id
	String id;
	String name;
	String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
