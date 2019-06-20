package me.zy.spring.initdestory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("me.zy.spring.initdestory")
public class PrePostConfiguration {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    Jsr250WayService jsr250WayService(){
        return new Jsr250WayService();
    }
}
