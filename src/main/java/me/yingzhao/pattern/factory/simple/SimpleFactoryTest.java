package me.yingzhao.pattern.factory.simple;

import me.yingzhao.pattern.factory.Phone;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory sf = new SimpleFactory();
        Phone p = sf.getPhone("xiaomi");
        System.out.println(p.getName());
    }
}
