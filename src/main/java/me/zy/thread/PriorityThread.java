package me.zy.thread;

public class PriorityThread  {
    public static class PriorityHigh extends Thread{
        public static int i =0;

        @Override
        public void run() {
            for(i=0;i<1000000;i++);

            System.out.println("High over.");
        }
    }

    public static class PriorityLow extends Thread{
        public static int i =0;

        @Override
        public void run() {
            for(i=0;i<1000000;i++);
            System.out.println("Low over.");
        }
    }

    public static void main(String[] args) {
        PriorityHigh high = new PriorityHigh();
        PriorityLow low = new PriorityLow();

        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        low.start();
        high.start();

    }
}
