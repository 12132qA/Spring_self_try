package task1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 1. 创建自定义注解 方法
 *
 * @author 张根勇*/

@Retention(RetentionPolicy.RUNTIME) // 源文件
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface Component {
    String value() default "";
}