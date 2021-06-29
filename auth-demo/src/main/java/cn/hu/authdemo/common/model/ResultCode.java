package cn.hu.authdemo.common.model;

public enum ResultCode {
    SUCCESS("000", "操作成功");

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
