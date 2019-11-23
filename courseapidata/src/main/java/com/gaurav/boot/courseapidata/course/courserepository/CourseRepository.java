package com.gaurav.boot.courseapidata.course.courserepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurav.boot.courseapidata.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query(value="select c from Course c where c.name=:name")
	public List<Course> findByName(@Param("name") String name);
	
	@Query(value="select c from Course c where c.description=?1")
	public List<Course> findByDescription(String description);
	
	
	@Query(value="select count(*) from course_db", nativeQuery=true)
	public Long countAllRecords();
	
}
