package com.cityservices.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableJpaAuditing
@EnableGlobalMethodSecurity(securedEnabled = true)
public class TourApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourApplication.class, args);
	}

}
