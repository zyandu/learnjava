package me.zy.spring.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FunctionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(FunctionConfig.class);
        UseFunctionService us =  context.getBean(UseFunctionService.class);

        System.out.println(us.functionSayHello("world"));

        context.close();

    }
}
