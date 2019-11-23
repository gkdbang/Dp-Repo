package com.gaurav.ecom2.bootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.gaurav.ecom2")
@EntityScan("com.gaurav.ecom2.model")
@EnableJpaRepositories("com.gaurav.ecom2.repository")
public class EcomSpringBoot {

	public static void main(String[] args) {
		
		SpringApplication.run(EcomSpringBoot.class, args);

	}

}
