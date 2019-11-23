package com.gaurav.boot.courseapidata.topic.topicrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.boot.courseapidata.topic.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {
	
		// We don't need to write our own query spring data-Jpa will generate query by itself.
		public List<Topic> findByName(String name);	
		public List<Topic> findByDescription(String description);
}
