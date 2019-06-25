package me.zy.spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    @Async
    //@Async注解表明此方法是个异步方法
    //如果注解在类级别，表明该类的所有方法都是异步的
    //这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
    public void executeTask(Integer i){
        System.out.println("执行异步任务"+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1："+(i+1));
    }
}
