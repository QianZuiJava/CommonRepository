package cn.hu.codetoname;

import cn.hu.codetoname.model.ConvertContext;
import cn.hu.codetoname.model.ConvertField;

import java.util.List;

/**
 * 转换处理器接口
 */
public interface IConvertHandler {
    /**
     * 收集属性到上下文
     * @param target 目标对象
     * @param convertContext 转换上下文
     */
    void collect(Object target, ConvertContext convertContext);

    /**
     * 给上下中收集的属性赋值
     * @param convertContext
     */
    void assignment(ConvertContext convertContext);

    /**
     * 将上下文中的值回写到目标对象中
     *
     * @param target 目标对象
     * @param convertContext 转换上下文
     */
    void writeBack(Object target, ConvertContext convertContext);

    /**
     * 收集目标的属性信息
     *
     * @param target 目标对象
     * @return List 收集的属性
     */
    List<ConvertField> getConvertFields(Object target);
}
