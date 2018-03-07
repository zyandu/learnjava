package me.zy.pattern.factory.simple;

import me.zy.pattern.factory.MeiZu;
import me.zy.pattern.factory.Phone;
import me.zy.pattern.factory.XiaoMi;

public class SimpleFactory {
    public Phone getPhone(String name){
        if(name.equals("xiaomi")){
            return new XiaoMi();
        }else if(name.equals("meizu")){
            return new MeiZu();
        }
        return null;
    }
}
