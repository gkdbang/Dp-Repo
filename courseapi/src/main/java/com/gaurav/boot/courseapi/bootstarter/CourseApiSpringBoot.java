package com.gaurav.boot.courseapi.bootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.gaurav.boot.courseapi")
public class CourseApiSpringBoot {

	public static void main(String[] args) {

		SpringApplication.run(CourseApiSpringBoot.class, args);
	}
}
