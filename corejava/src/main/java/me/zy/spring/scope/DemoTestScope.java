package me.zy.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoTestScope {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(DemoConfigScope.class);
        DemoSingletonScope dss0 = context.getBean(DemoSingletonScope.class);
        DemoSingletonScope dss1 = context.getBean(DemoSingletonScope.class);

        DemoPrototypeScope dps0 = context.getBean(DemoPrototypeScope.class);
        DemoPrototypeScope dps1 = context.getBean(DemoPrototypeScope.class);

        System.out.println(dss0.equals(dss1));
        System.out.println(dps0.equals(dps1));
    }
}
