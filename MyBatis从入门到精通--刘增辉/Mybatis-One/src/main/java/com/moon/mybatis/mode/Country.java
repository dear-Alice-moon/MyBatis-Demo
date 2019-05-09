package com.moon.mybatis.mode;

public class Country {
	
	private Long id;  // 这里的数据类型，还可以使用 Integer 。    2019/01/13 17:36 @moon         
	
	private String countryName;
	
	private String countryCode;
	
	
	
	
	/**
	 * 重写 toString() 函数
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode + "]";
	}
	
	/**
	 * 全参构造函数
	 * @param id
	 * @param countryName
	 * @param countryCode
	 */
	public Country(Long id, String countryName, String countryCode) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.countryCode = countryCode;
	}
	
	/**
	 * 无参构造函数 
	 */
	public Country() {
		super();
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
