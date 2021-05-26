package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 爆炸类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Explode {
    public final static int WIDTH= ImageMgr.explodeImages[0].getWidth();
    public final static int HEIGHT= ImageMgr.explodeImages[0].getHeight();

    private int x,y;
    private boolean living = true;
    TankFrame tf=null;
    private int step=0;

    public Explode(int x, int y, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.tf=tf;
        Audio audio=new Audio("audio/explode.wav");
        audio.play();
    }

    public void paint(Graphics g) {
        g.drawImage(ImageMgr.explodeImages[step++],x,y,null);
        if(step>=ImageMgr.explodeImages.length){
            step=0;
            tf.explodes.remove(this);
        }
    }


}
