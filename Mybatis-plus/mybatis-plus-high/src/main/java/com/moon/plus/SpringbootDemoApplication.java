package com.moon.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moon.plus.dao")
public class SpringbootDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello Mybatis-plus (^__^) ");
	}
}
