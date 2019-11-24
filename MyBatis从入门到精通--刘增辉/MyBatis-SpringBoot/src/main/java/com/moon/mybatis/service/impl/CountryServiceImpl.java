package com.moon.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.mybatis.mapper.CountryMapper;
import com.moon.mybatis.pojo.Country;
import com.moon.mybatis.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryMapper countryMapper;
	
	
	/**
	 * 查询全部数据
	 * 
	 * @return
	 * 
	 * @author moon  2019/11/24  11:35
	 */
	@Override
	public List<Country> selectAll() {
		
		return countryMapper.selectAll();
	}

}
