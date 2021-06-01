package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Tank;

import java.awt.*;

/**
 * @description: 抽象子弹
 * @author: yanxiaotian
 * @create: 2021-06-01 15:52
 **/
public abstract class AbstractBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWith(AbstractTank tank);
}
