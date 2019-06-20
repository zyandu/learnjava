package me.zy.pattern.proxy;

public class AliPayProxy implements IPayMent {
    //构件或者传递进来，被代理的对象
    private AliPayImpl payMent = new AliPayImpl();

    public String doPay(String args) {
        System.out.println("支付前记录日志");
        return payMent.doPay("zy");
    }
}
