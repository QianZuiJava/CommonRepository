package cn.hu.codetoname.model;

import lombok.Data;

@Data
public class ConvertInfo extends ConvertField {
    // 转换名称结果值
    private String convertNameValue;
    // 转换依赖code值
    private String convertCodeValue;
    // 语种
    private String language;
}
