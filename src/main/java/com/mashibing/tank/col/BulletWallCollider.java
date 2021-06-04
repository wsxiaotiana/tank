package com.mashibing.tank.col;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

import java.awt.*;

/**
 * @description: 坦克子弹碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:27
 **/
public class BulletWallCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet=(Bullet) o1;
            Wall wall=(Wall) o2;
            Rectangle rect1 = bullet.getRect();
            Rectangle rect2 = wall.getRect();
            if(rect1.intersects(rect2)){
                bullet.die();
                GameModel.getInstance().remove(bullet);
                return;
            }
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            collide(o2,o1);
        }else {
            return;
        }
    }
}
