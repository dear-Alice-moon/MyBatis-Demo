package com.moon.mybatis.pojo;

import java.io.Serializable;

public class SysDict implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键 id
	 */
	private Long id;

	/**
	 * 类别 code
	 */
	private String code;

	/**
	 * 字典名 name
	 */
	private String name;

	/**
	 * 字典值 value
	 */
	private String value;
	
	
	
	
	/**
	 * 重写toString()函数
	 */
	@Override
	public String toString() {
		return "SysDict [id=" + id + ", code=" + code + ", name=" + name + ", value=" + value + "]";
	}
	
	
	/**
	 * 全参构造函数
	 * 
	 * @param id
	 * @param code
	 * @param name
	 * @param value
	 */
	public SysDict(Long id, String code, String name, String value) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.value = value;
	}
	
	
	/**
	 * 无参构造函数
	 */
	public SysDict() {
		super();
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}