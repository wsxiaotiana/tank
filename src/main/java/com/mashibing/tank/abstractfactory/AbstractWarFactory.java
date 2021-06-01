package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

/**
 * @description: 抽象工厂类
 * @author: yanxiaotian
 * @create: 2021-06-01 15:37
 **/
public abstract class AbstractWarFactory {
    public abstract AbstractTank createTank(int x, int y, Dir dir,TankFrame tf,Group group);
    public abstract AbstractBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group);
    public abstract AbstractExplode createExplode(int x, int y, TankFrame tf);
}
