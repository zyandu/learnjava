package me.zy.thread;

public class BadResume {
    static Thread t1 = new ChangeObjectThread("t1");
    static Thread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run(){
            System.out.println("in " + getName());
            //suspend挂起，不会释放锁,如果resume提前于suspend执行，就会发生死锁
            Thread.currentThread().suspend();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(2000);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }}
