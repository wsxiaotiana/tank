package com.mashibing.tank.col;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Paintble;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

/**
 * @description: 坦克坦克碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class TankWallCollider implements Collider{
    @Override
    public void collide(Paintble o1, Paintble o2) {
        if(!(o1 instanceof Tank) || !(o2 instanceof Wall)){
            return;
        }
        Tank t1=(Tank)o1;
        Wall w=(Wall)o2;
        if(t1.getRect().intersects(w.getRect())){
            t1.back();
        };
    }
}
