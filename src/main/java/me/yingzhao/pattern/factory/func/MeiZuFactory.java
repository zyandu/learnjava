package me.yingzhao.pattern.factory.func;

import me.yingzhao.pattern.factory.MeiZu;
import me.yingzhao.pattern.factory.Phone;

public class MeiZuFactory implements Factory {
    public Phone getPhone() {
        return new MeiZu();
    }
}
