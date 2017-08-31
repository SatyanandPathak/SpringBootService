package com.satya.spring.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.spring.boot.model.Topic;
import com.satya.spring.boot.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> getTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	
	public Topic addTopic(Topic topic){
		return topicRepository.save(topic);
	}
	
	public void deleteTopic(String id){
		topicRepository.delete(id);
	}
	
	public void updateTopic(Topic topic, String id){
		topicRepository.save(topic);
	}

}
