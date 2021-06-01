package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.AbstractBullet;
import com.mashibing.tank.abstractfactory.AbstractExplode;
import com.mashibing.tank.abstractfactory.AbstractTank;
import com.mashibing.tank.abstractfactory.AbstractWarFactory;
import com.mashibing.tank.abstractfactory.DefaultWarFactory;
import com.mashibing.tank.abstractfactory.RectWarFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-05-12 20:52
 **/
public class TankFrame extends Frame {
    public static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    public List<AbstractTank> enemies=new ArrayList<>(4);
    public List<AbstractBullet> bullets=new ArrayList<>();
    public AbstractWarFactory warFactory=new DefaultWarFactory();
    private Tank myTank =new Tank(200,400,Dir.UP,this,Group.GOOD);

    public Tank getMyTank() {
        return myTank;
    }

    public void setMyTank(Tank myTank) {
        this.myTank = myTank;
    }

    public List<AbstractTank> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractTank> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractBullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<AbstractBullet> bullets) {
        this.bullets = bullets;
    }

    public List<AbstractExplode> getExplodes() {
        return explodes;
    }

    public void setExplodes(List<AbstractExplode> explodes) {
        this.explodes = explodes;
    }

    public List<AbstractExplode> explodes=new ArrayList<>();
    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(true);
        setTitle("tank war");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    Random random=new Random();

    Image offScreenImage=null;
    //此方法用来解决闪烁问题
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
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

    class MyKeyListener extends KeyAdapter {
        boolean kU=false;
        boolean kD=false;
        boolean kL=false;
        boolean kR=false;
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode=e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_UP:
                    kU=true; break;
                case KeyEvent.VK_DOWN:
                    kD=true; break;
                case KeyEvent.VK_LEFT:
                    kL=true; break;
                case KeyEvent.VK_RIGHT:
                    kR=true; break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire(); break;
                default: break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!kU && !kD && !kR && !kL){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(kU) myTank.setDir( Dir.UP);
                if(kD) myTank.setDir(Dir.DOWN);
                if(kR) myTank.setDir(Dir.RIGHT);
                if(kL) myTank.setDir(Dir.LEFT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode=e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_UP:
                    kU=false; break;
                case KeyEvent.VK_DOWN:
                    kD=false; break;
                case KeyEvent.VK_LEFT:
                    kL=false; break;
                case KeyEvent.VK_RIGHT:
                    kR=false; break;
                default: break;
            }
            setMainTankDir();
        }
    }
}
