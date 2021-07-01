package cn.hu.authdemo.common.exception;

import cn.hu.authdemo.common.model.ResultCode;

public class BusinessException extends RuntimeException {
    private String code;
    private String msg;




    public BusinessException(){

    }
    public BusinessException(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public static BusinessException userRoleExist() {
        return new BusinessException(ResultCode.USER_ROLE_EXISTS);
    }

    public static BusinessException userExists() {
        return new BusinessException(ResultCode.USER_EXISTS);
    }

    public static BusinessException userAndRoleBinded() {
        return new BusinessException(ResultCode.USER_HAVE_ROLE);
    }

    public static BusinessException roleNotExists() {
        return new BusinessException(ResultCode.ROLE_NOT_EXISTS);
    }

    public static BusinessException userNotExists() {
        return new BusinessException(ResultCode.USER_NOT_EXISTS);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
