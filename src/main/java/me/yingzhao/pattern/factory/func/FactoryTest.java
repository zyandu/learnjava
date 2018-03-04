package me.yingzhao.pattern.factory.func;

public class FactoryTest {
    public static void main(String[] args) {
        Factory f = new MeiZuFactory();
        System.out.println(f.getPhone().getName());
    }
}
