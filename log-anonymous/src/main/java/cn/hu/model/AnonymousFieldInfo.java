package cn.hu.model;

import lombok.Data;

/**
 * 匿名属性和对应的方案模型
 */
@Data
public class AnonymousFieldInfo {
    // 方案分组名
    private String groupName;
    // 匿名属性名
    private String anonymousField;
    // 匿名方案编码
    private Integer anonymousPlanCode;
}
