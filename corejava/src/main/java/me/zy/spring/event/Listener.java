package me.zy.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ApplicationListener<Event> {
    @Override
    public void onApplicationEvent(Event event) {
        String msg = event.getMsg();
        System.out.println("DemoListener接收到了demo-publisher发布的消息："+msg);
    }
}
