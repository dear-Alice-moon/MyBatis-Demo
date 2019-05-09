package test03.model;

public class SysPrivilege {
    /**
     * id
     */
    private Long id;

    /**
     * privilege_name
     */
    private String privilegeName;

    /**
     * privilege_url
     */
    private String privilegeUrl;

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