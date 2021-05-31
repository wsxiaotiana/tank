package com.mashibing.tank;

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
        new Bullet(xX,yY,tank.dir,tank.tf,tank.getGroup()== Group.GOOD? Group.GOOD: Group.BAD);
    }
}
