package com.gaurav.boot.courseapidata.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.boot.courseapidata.course.courserepository.CourseRepository;
import com.gaurav.boot.courseapidata.course.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		List<Course> courses=new ArrayList<Course>();
		for(Course c:courseRepository.findAll()){
			courses.add(c);
		}
		return courses;
	}


	public Course getCourseById(Long id){ 
			return courseRepository.findOne(id);
	}
	
	public List<Course> getCourseByName(String name) {
		
		List<Course> course=null;
		if("B.Tech".equalsIgnoreCase(name))
			course=courseRepository.findByName(name.concat("."));
		else
			course=courseRepository.findByName(name);
		
			return course;
	}


	public List<Course> getCourseByDescription(String description) {
		
		return courseRepository.findByDescription(description);
	}

	public List<Course> addCourse(List<Course> course) {
		
		courseRepository.save(course);
		return getAllCourses();
	}

	public List<Course> updateCourse(Course course, Long id) {
		courseRepository.save(course);
		return getAllCourses();
	}

	public List<Course> deleteCourse(Long id) {
		courseRepository.delete(id);
		return getAllCourses();
	}


	public Long getCoursesCount() {
		return courseRepository.countAllRecords();
	}

}
