package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.edu.cart.mapper"})
public class Exam3Application {

	public static void main(String[] args) {
		SpringApplication.run(Exam3Application.class, args);
	}

}
