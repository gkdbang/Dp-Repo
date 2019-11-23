package com.gaurav.userphone.bootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.gaurav.userphone")
@EntityScan("com.gaurav.userphone.model")
@EnableJpaRepositories("com.gaurav.userphone.repository")
public class UserPhoneSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(UserPhoneSpringBoot.class, args);
	}
}
