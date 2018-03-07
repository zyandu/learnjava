package me.zy.pattern.proxy.jdk;

public class FindLoveResult {
    public static void main(String[] args) throws Throwable {
        Person op = (Person) new MeiPo().getInstance(new MeiMei());
        op.findLove();

    }
}
