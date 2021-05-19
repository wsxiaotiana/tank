package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 子弹类
 * @author: yanxiaotian
 * @create: 2021-05-14 07:16
 **/
public class Bullet {
    private final static int WIDTH= ImageMgr.bulletD.getWidth();
    private final static int HEIGHT= ImageMgr.bulletD.getWidth();

    private static final int SPEED = 10;
    private int x,y;
    private Dir dir=Dir.UP;
    boolean live=true;
    TankFrame tf=null;


    public void paint(Graphics g) {
        if(!live){
            tf.bullets.remove(this);
            return;
        }
        move();
        switch (dir){
            case UP: g.drawImage(ImageMgr.bulletU,x,y,null); break;
            case DOWN: g.drawImage(ImageMgr.bulletD,x,y,null); break;
            case LEFT: g.drawImage(ImageMgr.bulletL,x,y,null); break;
            case RIGHT: g.drawImage(ImageMgr.bulletR,x,y,null); break;
            default: break;
        }
    }

    private void move() {
        switch (dir){
            case UP: y-=SPEED; break;
            case DOWN: y+=SPEED; break;
            case LEFT: x-=SPEED; break;
            case RIGHT:x+=SPEED; break;
            default: break;
        }
        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
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
