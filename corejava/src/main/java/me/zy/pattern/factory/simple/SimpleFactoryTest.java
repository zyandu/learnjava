package me.zy.pattern.factory.simple;

import me.zy.pattern.factory.Phone;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory sf = new SimpleFactory();
        Phone p = sf.getPhone("xiaomi");
        System.out.println(p.getName());
    }
}
