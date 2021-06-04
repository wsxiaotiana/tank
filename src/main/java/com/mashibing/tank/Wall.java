package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 墙
 * @author: yanxiaotian
 * @create: 2021-06-04 11:00
 **/
public class Wall extends GameObject{

    public int width,height;
    public Rectangle rect=null;

    public Wall(int x,int y,int width, int height) {
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
        rect=new Rectangle(x,y,width,height);
        GameModel.getInstance().add(this);
    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.darkGray);
        g.fillRect(x,y,width,height);
        g.setColor(c);
    }
}
