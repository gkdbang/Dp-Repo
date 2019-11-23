package com.gaurav.boot.courseapi.topic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.boot.courseapi.topic.model.Topic;
import com.gaurav.boot.courseapi.topic.service.TopicService;


@RestController
@RequestMapping(value="/topics")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/getAllTopics", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/getOneTopic/{id}")
	public Topic getTopicById(@PathVariable("id") String id){
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(value="/addTopics",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> addTopic(@RequestBody Topic topic){
		List<Topic> topics=topicService.addTopic(topic);
		return topics;
	}
	
	@RequestMapping(value="/updateTopics/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> updateTopic(@RequestBody Topic topic,@PathVariable("id") String id){
		List<Topic> topics=topicService.updateTopic(topic,id);
		return topics;
	}
	
	@RequestMapping(value="/deleteTopics/{id}",method=RequestMethod.DELETE)
	public List<Topic> deleteTopic(@PathVariable("id") String id){
		List<Topic> topics=topicService.deleteTopic(id);
		return topics;
	}
	
}
