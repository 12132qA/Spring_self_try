package task1.annotation;

import java.lang.annotation.*;

/**
 * .
 *
 * @belongsProject: day04
 * @belongsPackage: chapter04.task1.annotation
 * @author: ZGY
 * @createTime: 2024-03-23  09:59
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AliasFor {
    @AliasFor("attribute")
    String value() default "";

    @AliasFor("value")
    String attribute() default "";

    Class<? extends Annotation> annotation() default Annotation.class;
}