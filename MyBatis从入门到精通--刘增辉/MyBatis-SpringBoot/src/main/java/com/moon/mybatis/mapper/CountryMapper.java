package com.moon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.moon.mybatis.pojo.Country;

@Mapper
public interface CountryMapper {
	
	
	
	/**
	 * 查询全部数据
	 * 
	 * @return
	 * 
	 * @author moon  2019/11/24  11:35
	 */
	List<Country> selectAll();
	
}
