package me.zy.spring.event;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {
    public Event(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
