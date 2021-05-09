package cn.hu.codetoname.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * 对象的目标属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertField {
    // 待赋值属性
    private Field convertNameField;
    // 名称依赖值属性
    private Field convertCodeField;
    // 当前属性类型：有普通类型和复杂对象两种
    private String fieldType;
    // 当前属性所属标签
    private String label;
    // 当前属性缓存key
    private String cacheKey;

    public ConvertField(Field convertNameField, String fieldType) {
        this.convertNameField = convertNameField;
        this.fieldType = fieldType;
    }
}
