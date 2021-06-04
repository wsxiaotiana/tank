package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Group;
import com.mashibing.tank.Tank;
import com.mashibing.tank.decorator.RectDecorator;

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
        GameModel.getInstance().add(new RectDecorator(new Bullet(xX,yY,tank.dir,tank.getGroup()== Group.GOOD? Group.GOOD: Group.BAD),Bullet.WIDTH,Bullet.HEIGHT));
    }
}
