package me.zy.pattern.factory.abstr;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        PhoneFactory pf  = new PhoneFactory();
        System.out.println(pf.getMeiZuPhone().getName());
    }
}
