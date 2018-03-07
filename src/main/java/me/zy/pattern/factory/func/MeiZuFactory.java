package me.zy.pattern.factory.func;

import me.zy.pattern.factory.MeiZu;
import me.zy.pattern.factory.Phone;

public class MeiZuFactory implements Factory {
    public Phone getPhone() {
        return new MeiZu();
    }
}
