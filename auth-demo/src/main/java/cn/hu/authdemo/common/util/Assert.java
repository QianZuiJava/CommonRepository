package cn.hu.authdemo.common.util;

import cn.hu.authdemo.common.exception.BusinessException;

public class Assert {
    public static void isTrue(Boolean bool, BusinessException e){
        if (bool) {
            throw e;
        }
    }

    public static void isFalse(Boolean bool, BusinessException e){
        if (!bool) {
            throw e;
        }
    }
}
