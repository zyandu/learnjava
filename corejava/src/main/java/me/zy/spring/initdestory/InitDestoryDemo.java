package me.zy.spring.initdestory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDestoryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfiguration.class);

        context.getBean(BeanWayService.class);
        context.getBean(Jsr250WayService.class);

        context.close();
    }
}
