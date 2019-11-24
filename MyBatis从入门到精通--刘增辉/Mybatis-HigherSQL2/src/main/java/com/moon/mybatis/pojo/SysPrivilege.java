package com.moon.mybatis.pojo;

public class SysPrivilege {
    /**
     * 权限ID
     * 
     * id
     */
    private Long id;

    /**
     * 权限名称
     * 
     * privilege_name
     */
    private String privilegeName;

    /**
     * 权限URL
     * 
     * privilege_url
     */
    private String privilegeUrl;
    
    
    
    /**
     * 重写 toString() 函数 
     */
    @Override
	public String toString() {
		return "SysPrivilege [id=" + id + ", privilegeName=" + privilegeName + ", privilegeUrl=" + privilegeUrl + "]";
	}
    
    
    /**
     * 全参构造函数  
     * 
     * @param id
     * @param privilegeName
     * @param privilegeUrl
     */
	public SysPrivilege(Long id, String privilegeName, String privilegeUrl) {
		super();
		this.id = id;
		this.privilegeName = privilegeName;
		this.privilegeUrl = privilegeUrl;
	}
    
	
	/**
	 * 无参构造函数  
	 */
	public SysPrivilege() {
		super();
	}
	
	
	
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl == null ? null : privilegeUrl.trim();
    }
}