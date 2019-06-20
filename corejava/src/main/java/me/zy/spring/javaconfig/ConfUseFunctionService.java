package me.zy.spring.javaconfig;

public class ConfUseFunctionService {
    public ConfFunctionService functionService;

    public void setFunctionService(ConfFunctionService functionService) {
        this.functionService = functionService;
    }

    public String functionSayHello(String word) {
        return functionService.sayHello(word);
    }
}
