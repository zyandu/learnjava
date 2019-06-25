package me.zy.spring.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScheduler {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
