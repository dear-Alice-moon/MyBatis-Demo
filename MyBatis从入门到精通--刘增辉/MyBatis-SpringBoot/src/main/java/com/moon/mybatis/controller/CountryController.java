package com.moon.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.moon.mybatis.pojo.Country;
import com.moon.mybatis.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	@GetMapping("/selctAll")
	public JSON selectAll() {
		
		List<Country> countryList = countryService.selectAll();
		
		
		return (JSON) JSONObject.toJSON(countryList);
	}
	
	
}
