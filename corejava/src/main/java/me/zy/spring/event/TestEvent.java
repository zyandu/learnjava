package me.zy.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEvent {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);

        Publisther publisther = context.getBean(Publisther.class);
        publisther.publish("hello application event");

        context.close();

    }
}
