package me.zy.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfFunctionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfFunctionConfig.class);

        ConfUseFunctionService cufs = context.getBean(ConfUseFunctionService.class);
        System.out.println(cufs.functionSayHello("Java Config"));

        context.close();
    }
}
