package me.zy.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
    @Autowired
    public FunctionService functionService;

    public String functionSayHello(String word) {
        return functionService.sayHello(word);
    }
}
