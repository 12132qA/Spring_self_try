package task1.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Configuration {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";

    boolean proxyBeanMethods() default true;
}