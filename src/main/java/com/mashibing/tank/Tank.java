package com.mashibing.tank;

import java.awt.*;
import java.util.Random;


/**
 * @description: 坦克类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Tank {
    public final static int WIDTH= ImageMgr.goodTankU.getWidth();
    public final static int HEIGHT= ImageMgr.goodTankU.getHeight();

    private int x,y;
    private Dir dir= Dir.UP;
    private final int SPEED=2;
    private boolean moving = true;
    private boolean living = true;
    TankFrame tf=null;
    private Group group=Group.BAD;
    private Random random=new Random();

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;
    }

    public void paint(Graphics g) {
        if(!this.living){
            tf.enemies.remove(this);
            return;
        }
        move();
        randomDir();
        switch(dir){
            case UP: g.drawImage(this.group==Group.GOOD ? ImageMgr.goodTankU : ImageMgr.badTankU,x,y,null); break;
            case DOWN: g.drawImage(this.group==Group.GOOD ? ImageMgr.goodTankD : ImageMgr.badTankD,x,y,null); break;
            case LEFT: g.drawImage(this.group==Group.GOOD ? ImageMgr.goodTankL : ImageMgr.badTankL,x,y,null); break;
            case RIGHT: g.drawImage(this.group==Group.GOOD ? ImageMgr.goodTankR : ImageMgr.badTankR,x,y,null); break;
            default: break;
        }
    }

    private void randomDir() {
        if(this.group == Group.BAD && random.nextInt(100)<4){
            int d=random.nextInt(10)%5;
            switch (d){
                case 0: this.setDir(Dir.UP); break;
                case 1: this.setDir(Dir.DOWN); break;
                case 2: this.setDir(Dir.LEFT); break;
                case 3: this.setDir(Dir.RIGHT); break;
                default: break;
            }
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
        boundCheck();
        if(this.group ==Group.BAD && random.nextInt(100)<5){
            this.fire();
        }
    }

    private void boundCheck() {
        if(x<WIDTH/4-4){
            x=WIDTH/4-4;
        }
        if(y<HEIGHT/2){
            y=HEIGHT/2;
        }
        if(x>tf.getWidth()-WIDTH-4){
            x=tf.getWidth()-WIDTH-4;
        }
        if(y>tf.getHeight()-HEIGHT-4){
            y=tf.getHeight()-HEIGHT-4;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        int xX=x+WIDTH/4;
        int yY=y+HEIGHT/4;
        tf.bullets.add(new Bullet(xX,yY,dir,this.tf,this.group==Group.GOOD? Group.GOOD: Group.BAD));
    }

    public void die() {
        tf.explodes.add(new Explode(x,y,tf));
        this.living=false;
    }

}
