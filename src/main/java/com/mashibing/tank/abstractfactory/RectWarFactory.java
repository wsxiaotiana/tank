package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

/**
 * @description: 方形工厂
 * @author: yanxiaotian
 * @create: 2021-06-01 16:26
 **/
public class RectWarFactory extends AbstractWarFactory{
    @Override
    public AbstractTank createTank(int x, int y, Dir dir,TankFrame tf,Group group) {
        return new RectTank(x,y,dir,tf,group);
    }

    @Override
    public AbstractBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        return new RectBullet(x,y,dir,tf,group);
    }

    @Override
    public AbstractExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
