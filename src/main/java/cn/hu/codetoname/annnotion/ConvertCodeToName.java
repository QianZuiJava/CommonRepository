package cn.hu.codetoname.annnotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ConvertCodeToName {
    String label() default "";
    String dependCode() default "";
    String prefix() default "";
}
