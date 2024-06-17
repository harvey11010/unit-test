package com.team13.fantree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FanTreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FanTreeApplication.class, args);
	}

}
