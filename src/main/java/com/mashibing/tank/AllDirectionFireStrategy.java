package com.mashibing.tank;

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
            tank.tf.warFactory.createBullet(xX,yY, dir,tank.tf,tank.getGroup()== Group.GOOD? Group.GOOD: Group.BAD);
        }
    }
}
