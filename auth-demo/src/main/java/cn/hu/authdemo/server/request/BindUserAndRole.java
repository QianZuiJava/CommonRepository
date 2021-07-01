package cn.hu.authdemo.server.request;

public class BindUserAndRole {
    private String userAccount;
    private String roleCode;
    private String operatorId;
    private long tenantId;
    public BindUserAndRole(){

    }
    public BindUserAndRole(String userAccount, String roleCode, String operatorId, long tenantId) {
        this.userAccount = userAccount;
        this.roleCode = roleCode;
        this.operatorId = operatorId;
        this.tenantId = tenantId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
