package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)            //custom annotation kab available karana hai  eg--RUNTIME PAR
@Target(ElementType.TYPE)                      //annotation kahan laga sakte ho eg-- CLASS ke upar
@interface MyAnnotation {
   String value();
}

@MyAnnotation(value="Custom Annotation")
public class Test
{
    public static void main(String[] args) {
        Class<Test> ob = Test.class;
        MyAnnotation annotation = null;
        if (ob.isAnnotationPresent(MyAnnotation.class)) {
            annotation = ob.getAnnotation(MyAnnotation.class);
        }
        System.out.println("Annotation Value : " + annotation.value());
    }
}
