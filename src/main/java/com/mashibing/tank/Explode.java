package com.mashibing.tank;

import java.awt.*;

/**
 * @description: 爆炸类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Explode extends GameObject{
    public final static int WIDTH= ImageMgr.explodeImages[0].getWidth();
    public final static int HEIGHT= ImageMgr.explodeImages[0].getHeight();

    private boolean living = true;
    private int step=0;

    public Explode(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
        Audio audio=new Audio("audio/explode.wav");
        audio.play();
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageMgr.explodeImages[step++],x,y,null);
        if(step>=ImageMgr.explodeImages.length){
            step=0;
            GameModel.getInstance().remove(this);
        }
    }


}
