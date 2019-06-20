package me.zy.spring.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoEl {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig config = context.getBean(ElConfig.class);
        config.outputResource();

        context.close();
    }
}
