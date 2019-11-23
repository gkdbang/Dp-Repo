package com.gaurav.boot.courseapidata.bootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.gaurav.boot.courseapidata")
@EntityScan("com.gaurav.boot.courseapidata")
@EnableJpaRepositories("com.gaurav.boot.courseapidata")
public class CourseApiDataSpringBoot {

	public static void main(String[] args) {
		
		SpringApplication.run(CourseApiDataSpringBoot.class, args);
	}
}
