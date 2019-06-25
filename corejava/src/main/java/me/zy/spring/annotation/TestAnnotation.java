package me.zy.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationConfig.class);

        context.getBean(AnnotationDemo.class).outputResult();
    }
}
