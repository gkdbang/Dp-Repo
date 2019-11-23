package com.gaurav.boot.courseapidata.course.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gaurav.boot.courseapidata.topic.model.Topic;


@Entity
@Table(name="course_db")
public class Course{
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="course_id")
		private Long id;
		@Column(name="course_name")
		private String name;
		@Column(name="course_description")
		private String description;
		
		//@JsonBackReference
		//@JsonView
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		@JoinColumn(name="id",nullable=false)
		private Topic topic;
		
		// No-argu constructor
		public Course() {}

		public Course(Long id, String name, String description, Topic topic) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.topic = topic;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public Topic getTopic() {
			return topic;
		}

		public void setTopic(Topic topic) {
			this.topic = topic;
		}
		
}
