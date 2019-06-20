package me.zy.pattern.proxy;

public class PaymentClient {


    public static void main(String[] args) {
        IPayMent payMent = new AliPayImpl();
        System.out.println(payMent.doPay("zy"));
    }
}
