package com.moon.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moon.mybatis.mapper.CountryMapper;

@SpringBootApplication
public class MyBatisSpringBootApplication implements CommandLineRunner {
	
	@Autowired
	private CountryMapper countryMapper;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyBatisSpringBootApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		countryMapper.selectAll();
	}
	
	
	
	
}
