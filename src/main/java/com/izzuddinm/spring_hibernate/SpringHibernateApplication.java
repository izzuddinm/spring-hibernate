package com.izzuddinm.spring_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

}
