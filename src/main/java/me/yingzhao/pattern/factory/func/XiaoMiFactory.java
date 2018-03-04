package me.yingzhao.pattern.factory.func;

import me.yingzhao.pattern.factory.Phone;
import me.yingzhao.pattern.factory.XiaoMi;

public class XiaoMiFactory implements Factory {
    public Phone getPhone() {
        return new XiaoMi();
    }
}
