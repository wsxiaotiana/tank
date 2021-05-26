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
    boolean living =true;
    TankFrame tf=null;
    private Group group = Group.BAD;


    public void paint(Graphics g) {
        if(!living){
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
            this.die();
        }
    }

    public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;
    }

    public int getX() {
        return x;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public void collideWith(Tank tank) {
        if(this.getGroup()==tank.getGroup()){
            return;
        }
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rect1.intersects(rect2)){
            this.die();
            tank.die();
        }
    }

    private void die() {
        this.living=false;
    }
}
