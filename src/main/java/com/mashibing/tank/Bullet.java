package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 子弹类
 * @author: yanxiaotian
 * @create: 2021-05-14 07:16
 **/
public class Bullet {
    private static final int SPEED = 10;
    private static final int WIDTH=5,HEIGHT=5;
    private int x,y;
    private Dir dir=Dir.UP;


    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        move();
    }

    private void move() {
        switch (dir){
            case UP: y-=SPEED; break;
            case DOWN: y+=SPEED; break;
            case LEFT: x-=SPEED; break;
            case RIGHT:x+=SPEED; break;
            default: break;
        }
    }

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

}
