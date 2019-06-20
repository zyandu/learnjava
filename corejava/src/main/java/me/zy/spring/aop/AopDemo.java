package me.zy.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AopConfig.class);
        ActionService actionService = context.getBean(ActionService.class);
        MethodService methodService = context.getBean(MethodService.class);

        actionService.add();
        methodService.add();

        context.close();
    }
}
