package cn.hu.authdemo.server.request;

public class RoleAddRequest {
    private String roleCode;
    private String roleName;
    private String operatorId;
    private long tenantId;

    public RoleAddRequest(){

    }

    public RoleAddRequest(String roleCode, String roleName, String operatorId, long tenantId) {
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.operatorId = operatorId;
        this.tenantId = tenantId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }
}
