package me.zy.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService service = context.getBean(AwareService.class);
        service.outputResult();

    }
}
