package me.zy.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfFunctionConfig {
    @Bean
    public ConfFunctionService functionService(){
        return new ConfFunctionService();
    }

    @Bean
    public ConfUseFunctionService confUseFunctionService(){
        ConfUseFunctionService cufs = new ConfUseFunctionService();
        cufs.setFunctionService(functionService());
        return cufs;
    }

}
