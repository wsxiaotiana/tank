package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 坦克类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Tank {
    private int x,y;
    private Dir dir=Dir.UP;
    private final int SPEED=10;
    private boolean moving = false;
    TankFrame tf=null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x,y,50,50);
        g.setColor(c);
        move();
    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case UP: y-=SPEED; break;
            case DOWN: y+=SPEED; break;
            case LEFT: x-=SPEED; break;
            case RIGHT:x+=SPEED; break;
            default: break;
        }
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

    public int getSPEED() {
        return SPEED;
    }

    public void fire() {
        tf.bullets.add(new Bullet(x,y,dir,this.tf));
    }
}
