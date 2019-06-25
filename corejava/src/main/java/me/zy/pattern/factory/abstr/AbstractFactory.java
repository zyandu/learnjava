package me.zy.pattern.factory.abstr;

import me.zy.pattern.factory.Phone;

/**
 * 抽象工厂是用户入口
 * 在spring中使用最广泛的设计模式
 */
public abstract class AbstractFactory {
    //公共逻辑，方便统一管理

    public abstract Phone getXiaoMiPhone();

    public abstract Phone getMeiZuPhone();

    //很好扩展，符合开闭原则
    //public abstract Phone getHuaWeiPhone();
}
