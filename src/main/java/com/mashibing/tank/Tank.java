package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 坦克类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Tank {
    public final static int WIDTH= ImageMgr.tankD.getWidth();
    public final static int HEIGHT= ImageMgr.tankD.getHeight();

    private int x,y;
    private Dir dir=Dir.UP;
    private final int SPEED=5;
    private boolean moving = true;
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
        move();
        switch(dir){
            case UP: g.drawImage(ImageMgr.tankU,x,y,null); break;
            case DOWN: g.drawImage(ImageMgr.tankD,x,y,null); break;
            case LEFT: g.drawImage(ImageMgr.tankL,x,y,null); break;
            case RIGHT: g.drawImage(ImageMgr.tankR,x,y,null); break;
            default: break;
        }
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
        int xX=x+WIDTH/2;
        int yY=y+HEIGHT/2;
        tf.bullets.add(new Bullet(xX,yY,dir,this.tf));
    }
}
