package com.mashibing.tank.col;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

/**
 * @description: 坦克子弹碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class BulletTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            ((Bullet) o1).collideWith((Tank)o2);
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
        }else {
            return;
        }
    }
}
