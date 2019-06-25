package me.zy.spring.testcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestContextConfig {
    @Bean
    @Profile("dev")
    public TestContextBean devTestBean(){
        return new TestContextBean("from development profile.");
    }

    @Bean
    @Profile("prod")
    public TestContextBean prodTestBean(){
        return new TestContextBean("from production profile.");
    }
}
