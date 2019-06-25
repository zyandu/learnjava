package me.zy.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class AnnotationDemo {
    public void outputResult(){
        System.out.println("从组合注解配置中获取的Bean");
    }
}
