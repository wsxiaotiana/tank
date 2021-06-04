package com.mashibing.tank;

import com.mashibing.tank.col.BulletTankCollider;
import com.mashibing.tank.col.Collider;
import com.mashibing.tank.col.ColliderChain;
import com.mashibing.tank.col.TankTankCollider;
import sun.security.jca.GetInstance;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 外观模式的门面
 * @author: yanxiaotian
 * @create: 2021-06-02 20:28
 **/
public class GameModel {

    private static class instanceBuilder{
        public static final GameModel INSTANCE=new GameModel();
    }
    static {
        instanceBuilder.INSTANCE.init();
    }
    private Tank myTank=null;
    /*public java.util.List<Tank> enemies=new ArrayList<>(4);
    List<Bullet> bullets=new ArrayList<>();
    List<Explode> explodes=new ArrayList<>();*/

    List<GameObject> objects=new ArrayList<>();
    ColliderChain colliderChain=new ColliderChain();

    public static GameModel getInstance(){
        return instanceBuilder.INSTANCE;
    }
    private void init(){
        myTank =new Tank(200,500,Dir.UP,Group.GOOD);
        for(int i=0; i<4; i++){
            new Tank(300+i*80,500, Dir.UP,Group.BAD);
        }
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }
    private  GameModel(){

    }
    public void add(GameObject go){
        objects.add(go);
    }
    public void remove(GameObject go){
        objects.remove(go);
    }
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.WHITE);
/*        g.drawString("子弹数量为:"+bullets.size(),10,60);
        g.drawString("敌人坦克数量为:"+enemies.size(),10,80);
        g.drawString("爆炸的数量为:"+explodes.size(),10,100);*/
        g.setColor(c);
        myTank.paint(g);
        for(int i=0;i<objects.size();i++){
            objects.get(i).paint(g);
        }
        for(int i=0; i<objects.size();i++){
            for(int j=i+1;j<objects.size();j++){
                colliderChain.collide(objects.get(i),objects.get(j));
            }
        }
/*        for(int i=0;i<enemies.size();i++){
            for(int j=0;j<bullets.size();j++){
                bullets.get(j).collideWith(enemies.get(i));
            }
        }*/
    }

    public Tank getMyTank() {
        return myTank;
    }
}
