package com.moon.mybatis.pojo;

public class Country {
    /**
     * 主键, id值
     * 
     * id
     */
    private Integer id;

    /**
     * 国家名
     * 
     * country_name
     */
    private String countryName;

    /**
     * 国家编码
     * 
     * country_code
     */
    private String countryCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }
}