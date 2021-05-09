package cn.hu.codetoname.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换上下文
 */
@Data
public class ConvertContext {
    // 当前上下文语种
    private String language;
    // 当前所有需要转换的属性集合
    private List<ConvertInfo> convertInfoList;

    public ConvertContext(String language) {
        this.language = language;
        this.convertInfoList = new ArrayList<>();
    }
}
