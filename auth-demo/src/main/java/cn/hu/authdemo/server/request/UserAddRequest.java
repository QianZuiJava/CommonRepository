package cn.hu.authdemo.server.request;

public class UserAddRequest {
    private String userAccount;
    private Long tenantId;
    private String operatorId;
    public UserAddRequest(){

    }

    public UserAddRequest(String userAccount, Long tenantId, String operatorId) {
        this.userAccount = userAccount;
        this.tenantId = tenantId;
        this.operatorId = operatorId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
