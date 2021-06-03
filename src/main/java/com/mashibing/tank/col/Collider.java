package com.mashibing.tank.col;

import com.mashibing.tank.GameObject;

/**
 * @description: 物体碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:26
 **/
public interface Collider {
    void collide(GameObject o1,GameObject o2);
}
