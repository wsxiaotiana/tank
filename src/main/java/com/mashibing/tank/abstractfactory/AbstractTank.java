package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Group;

import java.awt.*;

/**
 * @description: 抽象坦克类
 * @author: yanxiaotian
 * @create: 2021-06-01 15:40
 **/
public abstract class AbstractTank {
    public Group group=Group.BAD;
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract void die();
    public abstract void fire();

    public Group getGroup() {
        return group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
