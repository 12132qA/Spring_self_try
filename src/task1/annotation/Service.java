package task1.annotation;

import java.lang.annotation.*;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.annotation
 * @author: ZGY
 * @createTime: 2024-03-23  10:01
 * @version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Service {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}