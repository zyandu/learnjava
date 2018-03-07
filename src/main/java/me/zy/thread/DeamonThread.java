package me.zy.thread;

/*
* 守护线程不作为虚拟机是否退出的标志
* */
public class DeamonThread {
    public static class DeamonT extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("I am alive.");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeamonT dt = new DeamonT();
        dt.setDaemon(true);
        dt.start();
        //只能在线程开始前设置，否则就会报错
        //dt.setDaemon(true);

        Thread.sleep(2000);
    }
}
