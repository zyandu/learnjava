package me.zy.pattern.factory.abstr;

import me.zy.pattern.factory.MeiZu;
import me.zy.pattern.factory.Phone;
import me.zy.pattern.factory.XiaoMi;

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
