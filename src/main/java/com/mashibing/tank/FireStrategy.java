package com.mashibing.tank;

import com.mashibing.tank.Tank;

/**
 * @description: 坦克开火策略
 * @author: yanxiaotian
 * @create: 2021-05-31 14:38
 **/
public interface FireStrategy {
    /**
     * 坦克开火
     */
    void fire(Tank tank);
}
