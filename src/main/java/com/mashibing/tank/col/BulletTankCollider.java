package com.mashibing.tank.col;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

import java.awt.*;

/**
 * @description: 坦克子弹碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class BulletTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet=(Bullet) o1;
            Tank tank=(Tank) o2;
            if(bullet.getGroup()==tank.getGroup()){
                return;
            }
            Rectangle rect1 = bullet.getRect();
            Rectangle rect2 = tank.getRect();
            if(rect1.intersects(rect2)){
                bullet.die();
                tank.die();
                GameModel.getInstance().remove(bullet);
                GameModel.getInstance().remove(tank);
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
        }else {
            return;
        }
    }
}
