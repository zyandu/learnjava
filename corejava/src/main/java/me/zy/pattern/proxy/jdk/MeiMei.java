package me.zy.pattern.proxy.jdk;

public class MeiMei implements Person{
    public void findLove() {
        System.out.println("我喜欢高富帅");
    }

    public String getSex() {
        return "我是女生";
    }

    public String getName() {
        return "我是MeiMei";
    }
}
