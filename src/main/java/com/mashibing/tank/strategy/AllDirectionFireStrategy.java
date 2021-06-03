package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.Tank;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-05-31 15:06
 **/
public class AllDirectionFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int xX=tank.x+Tank.WIDTH/2;
        int yY=tank.y+Tank.HEIGHT/2;
        Dir[] dirs=Dir.values();
        for(Dir dir:dirs){
            new Bullet(xX,yY, dir,tank.gm,tank.getGroup()== Group.GOOD? Group.GOOD: Group.BAD);
        }
    }
}
