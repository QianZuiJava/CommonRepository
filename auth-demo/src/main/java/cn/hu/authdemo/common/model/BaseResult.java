package cn.hu.authdemo.common.model;

public class BaseResult {
    private String resCode;
    private String resMessage;
    private Object data;

    public BaseResult() {
    }

    public BaseResult(String resCode, String resMessage, Object data) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.data = data;
    }

    public static BaseResult ok() {
        return new BaseResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(), null);
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
