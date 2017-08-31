package com.satya.spring.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.satya.spring.boot.model.Topic;


@Repository
public interface TopicRepository extends MongoRepository<Topic, String>{

}
