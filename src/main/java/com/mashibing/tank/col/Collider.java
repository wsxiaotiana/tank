package com.mashibing.tank.col;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Paintble;

/**
 * @description: 物体碰撞器
 * @author: yanxiaotian
 * @create: 2021-06-03 10:26
 **/
public interface Collider {
    void collide(Paintble o1, Paintble o2);
}
