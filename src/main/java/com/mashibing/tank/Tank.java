package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.AbstractTank;
import com.mashibing.tank.abstractfactory.AbstractWarFactory;
import com.mashibing.tank.abstractfactory.DefaultWarFactory;

import java.awt.*;
import java.util.Random;


/**
 * @description: 坦克类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Tank extends AbstractTank {
    public final static int WIDTH= ImageMgr.tankD.getWidth();
    public final static int HEIGHT= ImageMgr.tankD.getHeight();

    Dir dir= Dir.UP;
    private final int SPEED=5;
    boolean moving = true;
    boolean living = true;
    TankFrame tf=null;
    private Random random=new Random();
    FireStrategy fireStrategy=null;

    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;
        if(this.group==Group.GOOD){
            String defaultStrategy=(String)PropertyMgr.get("defaultStrategy");
            try {
                fireStrategy=(FireStrategy)Class.forName(defaultStrategy).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fireStrategy=new AllDirectionFireStrategy();
        }else{
            String defaultStrategy=(String)PropertyMgr.get("allDirStrategy");
            try {
                fireStrategy=(FireStrategy)Class.forName(defaultStrategy).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fireStrategy=new AllDirectionFireStrategy();
        }
    }
    @Override
    public void paint(Graphics g) {
        if(!this.living){
            tf.enemies.remove(this);
            return;
        }
        move();
        //randomDir();
        switch(dir){
            case UP: g.drawImage(ImageMgr.tankU,x,y,null); break;
            case DOWN: g.drawImage(ImageMgr.tankD,x,y,null); break;
            case LEFT: g.drawImage(ImageMgr.tankL,x,y,null); break;
            case RIGHT: g.drawImage(ImageMgr.tankR,x,y,null); break;
            default: break;
        }
    }

    private void randomDir() {
        if(random.nextInt(100)<4){
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
        if(x<0 || y<0 || x+WIDTH>tf.getWidth() || y+HEIGHT>tf.getHeight()){
            this.dir= Dir.getOposite(dir);
            switch (dir){
                case UP: y-=SPEED; break;
                case DOWN: y+=SPEED; break;
                case LEFT: x-=SPEED; break;
                case RIGHT:x+=SPEED; break;
                default: break;
            }
        }
        if(random.nextInt(10)<2){
            this.fire();
        }
    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getSPEED() {
        return SPEED;
    }
    @Override
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    @Override
    public void fire() {
        //fireStrategy.fire(this);
        int xX=this.x+Tank.WIDTH/2;
        int yY=this.y+Tank.HEIGHT/2;
        this.tf.warFactory.createBullet(xX,yY,this.dir,this.tf,this.getGroup()== Group.GOOD? Group.GOOD: Group.BAD);
    }
    @Override
    public void die() {
        tf.explodes.add(tf.warFactory.createExplode(x,y,tf));
        this.living=false;
    }

}
