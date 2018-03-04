package me.yingzhao.pattern.factory.abstr;

import me.yingzhao.pattern.factory.Phone;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        PhoneFactory pf  = new PhoneFactory();
        System.out.println(pf.getMeiZuPhone().getName());
    }
}
