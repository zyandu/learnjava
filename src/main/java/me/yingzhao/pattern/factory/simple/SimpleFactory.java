package me.yingzhao.pattern.factory.simple;

import me.yingzhao.pattern.factory.MeiZu;
import me.yingzhao.pattern.factory.Phone;
import me.yingzhao.pattern.factory.XiaoMi;

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
