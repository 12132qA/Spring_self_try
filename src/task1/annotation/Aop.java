package task1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 源文件
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface Aop {
    String value() default "";
}