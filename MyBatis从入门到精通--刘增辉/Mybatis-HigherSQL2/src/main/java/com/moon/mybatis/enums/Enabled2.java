package com.moon.mybatis.enums;

/**
 * 使用自定义的类型处理器
 * 
 * @author moon  2019/06/22 15:49  
 *
 */
public enum Enabled2 {
	
	enabled(10),   // 启用
	disabled(11);  // 禁用
	
	private final Integer value;
	
	
	private Enabled2(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	/*
	public void setValue(Integer value) {
		this.value = value;
	}
	*/
	
}
