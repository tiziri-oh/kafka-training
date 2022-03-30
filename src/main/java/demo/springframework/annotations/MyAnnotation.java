package demo.springframework.annotations;

import java.lang.annotation.*;

//Target; ou cette annotation peut etre utilisé
//INHERITED : chaque class qui herite de la classe mere utilisant cette annotation en heritera aussi
//Retention:
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.)
@Inherited
public @interface MyAnnotation {
    String name() default "Jack";
    int count() default 999;
    String[] tags() default {"Java", "Annotation"};
}
