package cn.hu.authdemo.common.model;

public enum ResultCode {
    SUCCESS("000", "操作成功"),
    USER_ROLE_EXISTS("001", "用户角色已经存在，不可重复创建"),
    USER_EXISTS("002", "用户已经存在，不可重复创建"),
    USER_HAVE_ROLE("003", "用户已经绑定了该角色，不可重复绑定"),
    ROLE_NOT_EXISTS("004", "用户角色不存在，不可进行绑订操作"),
    USER_NOT_EXISTS("005", "用户不存在，不可重复绑定");
    private String code;
    private String msg;

    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
