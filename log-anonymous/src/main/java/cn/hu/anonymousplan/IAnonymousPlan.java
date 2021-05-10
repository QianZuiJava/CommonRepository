package cn.hu.anonymousplan;

import cn.hu.enums.AnonymousPlanCode;

/**
 * 1 提供获取对应方案编码的方法
 * 2 提供匿名化对应数据的方法
 */
public interface IAnonymousPlan {
    String ANONYMOUS_SYMBOL = "*";
    /**
     * 实际匿名化处理的方法
     *
     * @param target 目标值
     * @return String 匿名处理的结果
     */
    String anonymousField(String target);

    /**
     * 获取对应的方案编码
     *
     * @return AnonymousPlanCode 编码对象
     */
    AnonymousPlanCode getAnonymousPlanCode();
}
