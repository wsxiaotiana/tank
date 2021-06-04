package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Paintble;

import java.awt.*;

/**
 * @description: 方框装饰器
 * @author: yanxiaotian
 * @create: 2021-06-04 17:06
 **/
public class RectDecorator extends GODecorator{

    private int width,height;

    public RectDecorator(Paintble go) {
        super(go);
    }

    public RectDecorator(Paintble go, int width, int height) {
        super(go);
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        GameObject gObject=(GameObject)go;
        go.paint(g);
        Color c=g.getColor();
        g.setColor(Color.white);
        g.drawRect(gObject.x,gObject.y,this.width,this.height);
        g.setColor(c);
    }
}
