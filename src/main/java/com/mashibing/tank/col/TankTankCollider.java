package com.mashibing.tank.col;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

import java.awt.*;

/**
 * @description: 坦克坦克碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class TankTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(!(o1 instanceof Tank) || !(o2 instanceof Tank)){
            return;
        }
        Tank t1=(Tank)o1;
        Tank t2=(Tank)o2;
        if(t1.getRect().intersects(t2.getRect())){
            int preX1=t1.getPreX();
            int preY1=t1.getPreY();
            int preX2=t2.getPreX();
            int preY2=t2.getPreY();
            t1.setX(preX1);
            t1.setY(preY1);
            t2.setX(preX2);
            t2.setY(preY2);
        };
    }
}
