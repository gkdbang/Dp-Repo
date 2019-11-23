package com.gaurav.boot.courseapidata.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.boot.courseapidata.course.model.Course;
import com.gaurav.boot.courseapidata.course.service.CourseService;


@RestController
@RequestMapping(value="/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/getAllCourses", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping(value="/getOneCourse/{id}")
	public Course getCourseById(@PathVariable("id") Long id){
		return courseService.getCourseById(id);
	}
	
	@RequestMapping(value="/getOneCourseByName/{name}")
	public List<Course> getCourseByName(@PathVariable("name") String name){
		System.out.println(name);
		return courseService.getCourseByName(name);
	}
	
	@RequestMapping(value="/getOneCourseByDescription/{description}")
	public List<Course> getCourseByDescription(@PathVariable("description") String description){
		return courseService.getCourseByDescription(description);
	}
	
	@GetMapping(value="/getCoursesCount")
	public Long getCoursesCount(){
		return courseService.getCoursesCount();
	}
	
	@RequestMapping(value="/addCourses",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> addCourse(@RequestBody List<Course> course){
		List<Course> courses=courseService.addCourse(course);
		return courses;
	}
	
	@RequestMapping(value="/updateCourses/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> updateCourse(@RequestBody Course course,@PathVariable("id") Long id){
		List<Course> courses=courseService.updateCourse(course,id);
		return courses;
	}
	
	@RequestMapping(value="/deleteCourses/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> deleteCourse(@PathVariable("id") Long id){
		List<Course> courses=courseService.deleteCourse(id);
		return courses;
	}
	
}
