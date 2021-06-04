package com.mashibing.tank.col;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Paintble;
import com.mashibing.tank.Tank;

import java.awt.*;

/**
 * @description: 坦克坦克碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class TankTankCollider implements Collider{
    @Override
    public void collide(Paintble o1, Paintble o2) {
        if(!(o1 instanceof Tank) || !(o2 instanceof Tank)){
            return;
        }
        Tank t1=(Tank)o1;
        Tank t2=(Tank)o2;
        if(t1.getRect().intersects(t2.getRect())){
            t1.back();
            t2.back();
        };
    }
}
