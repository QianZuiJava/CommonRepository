package cn.hu.enums;

public enum AnonymousPlanCode {
    // 匿名用户信息
    ANONYMOUS_USER_NAME(1),
    // 匿名密码
    ANONYMOUS_USER_PASSWORD(2);

    Integer anonymousPlanCode;

    AnonymousPlanCode(Integer anonymousPlanCode) {
        this.anonymousPlanCode = anonymousPlanCode;
    }

    public Integer getAnonymousPlanCode() {
        return anonymousPlanCode;
    }
}
