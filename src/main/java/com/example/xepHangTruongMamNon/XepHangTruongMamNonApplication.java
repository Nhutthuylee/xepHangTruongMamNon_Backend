package com.example.xepHangTruongMamNon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
// @EnableSpringDataWebSupport
public class XepHangTruongMamNonApplication {

	public static void main(String[] args) {
		SpringApplication.run(XepHangTruongMamNonApplication.class, args);
	}

}
