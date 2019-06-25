package me.zy.spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsService(){
        return new WindowListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService(){
        return  new LinuxListService();
    }
}
