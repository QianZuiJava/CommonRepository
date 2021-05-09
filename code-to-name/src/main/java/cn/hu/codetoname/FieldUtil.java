package cn.hu.codetoname;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 反射中属性工具类
 */
public class FieldUtil {

    /**
     * 通过属性和目标实例获取属性值
     *
     * @param target 当前目标实例
     * @param field 当前属性
     * @return Object 当前属性值
     */
    public static Object getFieldValue(Object target, Field field){
        if (target == null || field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过属性和目标实例给属性赋值
     *
     * @param target 当前目标实例
     * @param field 当前属性
     * @param value 值
     * @return Object 当前属性值
     */
    public static void setFieldValue(Object target, Field field, Object value){
        if (target == null || field == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 判断当前属性是否为java内置类或复杂对象
     *
     * @param field
     * @return
     */
    public static Boolean isEmbebbed(Field field){
        Class<?> type = field.getType();
        // 是否为List
        if (type.isAssignableFrom(List.class)) return true;
        // 自定义类
        return type.getSuperclass() != null
                && type.getCanonicalName()!= null
                && !type.getCanonicalName().startsWith("java");
    }
}
