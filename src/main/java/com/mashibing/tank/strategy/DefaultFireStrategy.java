package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Group;
import com.mashibing.tank.Tank;

/**
 * @description: 普通开火
 * @author: yanxiaotian
 * @create: 2021-05-31 14:42
 **/
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int xX=tank.x+Tank.WIDTH/2;
        int yY=tank.y+Tank.HEIGHT/2;
        new Bullet(xX,yY,tank.dir,tank.gm,tank.getGroup()== Group.GOOD? Group.GOOD: Group.BAD);
    }
}
