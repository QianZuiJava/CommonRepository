package cn.hu.codetoname;

import cn.hu.codetoname.annnotion.ConvertCodeToName;
import cn.hu.codetoname.model.ConvertContext;
import cn.hu.codetoname.model.ConvertField;
import cn.hu.codetoname.model.ConvertInfo;
import cn.hu.codetoname.model.FieldType;
import cn.hu.codetoname.testmodel.Student;
import cn.hu.codetoname.testmodel.Teacher;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换操作类
 */
public class ConvertHandler {
    public static void main(String[] args) {
        Student student = new Student("", "MAN", new Teacher("", "JAVA"));
        ConvertHandler convertHandler = new ConvertHandler();
        ConvertContext convertContext = new ConvertContext("zh-cn");
        convertHandler.collect(student, convertContext);
        System.out.println("SUCCESS");
    }

    public void collect(Object target, ConvertContext convertContext){
        // 判断为空，直接返回
        if (target == null) return;
        // 判断为list，递归处理
        if (target instanceof List) {
            List list = (List) target;
            for (Object object : list){
                collect(object, convertContext);
            }
            return;
        }
        // 非集合对象，则获取收集属性ConvertField
        List<ConvertField> convertFields = getConvertFields(target);
        // 将ConvertField属性，转为ConvertInfo，并收集到上下文中
        for (ConvertField convertField : convertFields) {
            // 如果为嵌套属性，则继续递归
            if (convertField.getFieldType().equals(FieldType.EMBEDDED)) {
                // 获取属性实例
                Object fieldValue = FieldUtil.getFieldValue(target, convertField.getConvertNameField());
                collect(fieldValue, convertContext);
            } else {
                // 封装为ConvertInfo并收集到上下文中
                convertInfoToContext(target, convertField, convertContext);
            }
        }
    }

    private void convertInfoToContext(Object target, ConvertField convertField, ConvertContext convertContext) {
        Field convertNameField = convertField.getConvertNameField();
        Field convertCodeField = convertField.getConvertCodeField();
        String cacheKey = convertField.getCacheKey();
        String label = convertField.getLabel();
        Object codeFieldValue = FieldUtil.getFieldValue(target, convertCodeField);
        ConvertInfo convertInfo = new ConvertInfo();
        convertInfo.setConvertNameField(convertNameField);
        convertInfo.setConvertCodeField(convertCodeField);
        convertInfo.setConvertCodeValue(codeFieldValue.toString());
        convertInfo.setLabel(label);
        convertInfo.setCacheKey(cacheKey);
        convertInfo.setLanguage(convertContext.getLanguage());
        convertContext.getConvertInfoList().add(convertInfo);
    }

    private List<ConvertField> getConvertFields(Object target) {
        List<ConvertField> convertFieldList = new ArrayList<>();
        for (Class tClass = target.getClass(); tClass != null; tClass = tClass.getSuperclass()){
            Field[] declaredFields = tClass.getDeclaredFields();
            for (Field field : declaredFields) {
                // 判断是否为嵌套属性（自定义对象）
                if (FieldUtil.isEmbebbed(field)){
                    convertFieldList.add(new ConvertField(field, FieldType.EMBEDDED));
                    continue;
                }
                // 简单属性 1 判断是否有指定注解 2 判断依赖属性是否为基本类型 3 判断依赖属性是否有值
                parseFieldToConvertField(target, field, convertFieldList);
            }
        }
        return convertFieldList;
    }

    private void parseFieldToConvertField(Object target, Field field, List<ConvertField> convertFieldList) {
        ConvertCodeToName annotation = field.getAnnotation(ConvertCodeToName.class);
        // 1 是否有指定注解
        if (annotation == null) return;
        // 2 是否有依赖属性,标签和前缀是否为空
        String dependCode = annotation.dependCode();
        if (StringUtils.isEmpty(dependCode) || StringUtils.isEmpty(annotation.label()) || StringUtils.isEmpty(annotation.prefix())) return;
        // 3 依赖属性的类型
        try {
            Field declaredField = target.getClass().getDeclaredField(dependCode);
            Class<?> declaredFieldType = declaredField.getType();
            if (!declaredFieldType.equals(String.class)
                && !declaredFieldType.equals(Integer.class)
                && !declaredFieldType.equals(Boolean.class)) return;
            // 4 判断依赖属性是否有值
            Object fieldValue = FieldUtil.getFieldValue(target, declaredField);
            if (fieldValue == null || StringUtils.isEmpty(fieldValue.toString())) return;
            // 5 将满足条件的属性进行封装
            convertFieldList.add(new ConvertField(field, declaredField, FieldType.SIMPLE, annotation.label(), annotation.prefix()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
