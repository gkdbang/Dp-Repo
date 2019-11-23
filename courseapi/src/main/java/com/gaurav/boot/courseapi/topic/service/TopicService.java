package com.gaurav.boot.courseapi.topic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gaurav.boot.courseapi.topic.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("Spring", "Spring Framework", "Spring Framework Description"),
					new Topic("Java", "Core Java", "Core Java Description"),
					new Topic("javascript", "javascript Framework", "javascript Framework Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

/*	public Topic getTopicById(String id) {
		Topic topic = null;
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equalsIgnoreCase(id)){
				topic = topics.get(i);
				break;
			}
		}
		return topic;
	}*/


	public Topic getTopicById(String id){ 
		  Topic t=null; 
		  for(Topic topic:topics){ 
			  if(topic.getId().equalsIgnoreCase(id)){ 
				  t=topic; 
				  break; 
			  }
		  } 
		  return t; 
	}

	public List<Topic> addTopic(Topic topic) {
		
		topics.add(topic);
		return topics;
	}

	public List<Topic> updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equalsIgnoreCase(id)){
				topics.set(i, topic);
				break;
			}
		}
		return topics;
	}

	public List<Topic> deleteTopic(String id) {
		for(Topic t:topics){
			if(t.getId().equalsIgnoreCase(id)){
				topics.remove(t);
				break;
			}
		}
		return topics;
	}

}
