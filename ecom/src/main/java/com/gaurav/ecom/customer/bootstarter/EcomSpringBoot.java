package com.gaurav.ecom.customer.bootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.gaurav.ecom.customer")
@EntityScan("com.gaurav.ecom.customer.model")
@EnableJpaRepositories("com.gaurav.ecom.customer.repository")
public class EcomSpringBoot {

	public static void main(String[] args) {
		
		SpringApplication.run(EcomSpringBoot.class, args);

	}

}
