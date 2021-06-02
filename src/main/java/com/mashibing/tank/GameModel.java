package com.mashibing.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 外观模式的门面
 * @author: yanxiaotian
 * @create: 2021-06-02 20:28
 **/
public class GameModel {
    private Tank myTank =new Tank(200,400,Dir.UP,Group.GOOD,this);
    public java.util.List<Tank> enemies=new ArrayList<>(4);
    List<Bullet> bullets=new ArrayList<>();
    List<Explode> explodes=new ArrayList<>();

    public GameModel(){
        for(int i=0; i<4; i++){
            this.enemies.add(new Tank(300+i*80,300, Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量为:"+bullets.size(),10,60);
        g.drawString("敌人坦克数量为:"+enemies.size(),10,80);
        g.drawString("爆炸的数量为:"+explodes.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
        for(int i=0;i<enemies.size();i++){
            enemies.get(i).paint(g);
        }
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for(int i=0;i<enemies.size();i++){
            for(int j=0;j<bullets.size();j++){
                bullets.get(j).collideWith(enemies.get(i));
            }
        }
        for(int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }
    }

    public Tank getMyTank() {
        return myTank;
    }
}
