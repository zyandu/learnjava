package me.zy.spring.initdestory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Jsr250WayService {
    @PostConstruct
    //构造函数执行完执行
    public void init(){
        System.out.println("JSR250-init-method");
    }

    public Jsr250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy
    public void destory(){ //Bean销毁之前执行
        System.out.println("JSR250-destory-method");
    }

}
