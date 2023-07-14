package com.example.kb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 행 만들어준 시간 자동으로 들어감
public class Kb3Application {

	public static void main(String[] args) {
		SpringApplication.run(Kb3Application.class, args);
	}

}
