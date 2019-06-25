package me.zy.pattern.factory.func;

import me.zy.pattern.factory.Phone;
import me.zy.pattern.factory.XiaoMi;

public class XiaoMiFactory implements Factory {
    public Phone getPhone() {
        return new XiaoMi();
    }
}
