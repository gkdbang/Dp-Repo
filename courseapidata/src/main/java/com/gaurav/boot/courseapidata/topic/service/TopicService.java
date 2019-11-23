package com.gaurav.boot.courseapidata.topic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.boot.courseapidata.topic.model.Topic;
import com.gaurav.boot.courseapidata.topic.topicrepository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics=new ArrayList<Topic>();
		for(Topic t:topicRepository.findAll()){
			topics.add(t);
		}
		return topics;
	}


	public Topic getTopicById(int id){ 
			return topicRepository.findOne(id);
	}
	
	public List<Topic> getTopicByName(String name) {
		return topicRepository.findByName(name);
	}
	
	public List<Topic> getTopicByDescription(String description) {
		return topicRepository.findByDescription(description);
	}
	
	public Long getTotalCount() {
		
		return topicRepository.count();
	}

	public List<Topic> addTopic(List<Topic> topic) {
		
		topicRepository.save(topic);
		return getAllTopics();
	}

	public List<Topic> updateTopic(Topic topic, int id) {
		topicRepository.save(topic);
		return getAllTopics();
	}

	public List<Topic> deleteTopic(int id) {
		topicRepository.delete(id);
		return getAllTopics();
	}

}
