package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Paintble;

import java.awt.*;

/**
 * @description: 游戏对象装饰器
 * @author: yanxiaotian
 * @create: 2021-06-04 17:02
 **/
public abstract class GODecorator implements Paintble {
    protected Paintble go;

    public GODecorator(Paintble go) {
        this.go = go;
    }
}
