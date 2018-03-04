package me.yingzhao.pattern.factory.abstr;

import me.yingzhao.pattern.factory.MeiZu;
import me.yingzhao.pattern.factory.Phone;
import me.yingzhao.pattern.factory.XiaoMi;

public class PhoneFactory extends AbstractFactory {
    @Override
    public Phone getXiaoMiPhone() {
        return new XiaoMi();
    }

    @Override
    public Phone getMeiZuPhone() {
        return new MeiZu();
    }

    //易于扩展
}
