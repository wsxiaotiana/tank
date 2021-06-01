package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Audio;
import com.mashibing.tank.ImageMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

/**
 * @description: 爆炸类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class RectExplode extends AbstractExplode {
    public final static int WIDTH= ImageMgr.explodeImages[0].getWidth();
    public final static int HEIGHT= ImageMgr.explodeImages[0].getHeight();

    private int x,y;
    private boolean living = true;
    TankFrame tf=null;
    private int step=0;

    public RectExplode(int x, int y, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.tf=tf;
        Audio audio=new Audio("audio/explode.wav");
        audio.play();
    }
    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        g.setColor(c);
        //g.drawImage(ImageMgr.explodeImages[step++],x,y,null);
        step++;
        if(step>=15){
            step=0;
            tf.explodes.remove(this);
        }
    }


}
