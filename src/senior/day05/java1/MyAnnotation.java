package senior.day05.java1;

import java.lang.annotation.*;

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
