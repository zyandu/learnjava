package me.zy.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class ActionService {
    @PonintCutAction(name="注解式拦截add操作")
    public void add(){}

}
