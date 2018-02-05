package me.yingzhao.pattern.proxy.jdk;

import me.yingzhao.pattern.proxy.jdk.Person;

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
