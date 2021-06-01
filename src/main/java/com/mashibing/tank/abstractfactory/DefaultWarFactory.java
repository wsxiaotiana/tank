package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Explode;
import com.mashibing.tank.Group;
import com.mashibing.tank.Tank;
import com.mashibing.tank.TankFrame;

/**
 * @description: 默认工厂类
 * @author: yanxiaotian
 * @create: 2021-06-01 15:42
 **/
public class DefaultWarFactory extends AbstractWarFactory {
    @Override
    public AbstractTank createTank(int x, int y, Dir dir,TankFrame tf,Group group) {
        return new Tank(x,y,dir,tf,group);
    }

    @Override
    public AbstractBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        return new Bullet(x,y,dir,tf,group);
    }

    @Override
    public AbstractExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
