package me.zy.thread;

/*
* join等待某个线程终止
* 可以设置等待时长，默认为0
* */
public class JoinMain {
    public volatile static int i =0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for(i = 0;i<1000000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        /*
        * join等同于while(isalive()) wait(0)
        * 线程执行完毕，系统（native C++调用）会调用nofityAll()
        * 不要在线程实例上使用wait、notify、notifyAll方法
        * 这几个方法被系统调用（native C++调用），不保证线程上能够如愿执行
        * */
        at.join();
        //执行完打印结果：如果不join打印0，join打印最大值1000000
        System.out.println(i);
    }
}
