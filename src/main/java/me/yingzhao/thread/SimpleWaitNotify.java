package me.yingzhao.thread;
/*
* wait会释放当前线程的监视器（释放锁）
* */
public class SimpleWaitNotify {
    public static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            //这里没拿到object对象的锁，会抛异常
            //所以调用wait方法前提必须是拿到当前对象的监视器
            //object.wait();
            synchronized(object){
                System.out.println(System.currentTimeMillis()+":T1 start!");
                System.out.println(System.currentTimeMillis()+":T1 wait for object!");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(System.currentTimeMillis()+":T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            //这里没拿到object对象的锁，会抛异常
            //所以调用notify方法前提也必须是拿到当前对象的监视器
            //object.wait();
            synchronized(object){
                System.out.println(System.currentTimeMillis()+":T2 start!Notify one thread.");
                //唤醒当前等待中的某一个线程，notifyAll会唤醒所有等待中的线程，谁抢到谁先执行
                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 end!");

                try {
                    //T1等待T2执行完两秒后再执行
                    //sleep不释放锁
                    T2.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}
