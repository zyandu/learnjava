package me.zy.spring.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("me.zy.spring.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}
