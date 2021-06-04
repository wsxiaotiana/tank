package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-05-12 20:52
 **/
public class TankFrame extends Frame {
    GameModel gameModel=GameModel.getInstance();
    static final int GAME_WIDTH=800,GAME_HEIGHT=600;

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
        gameModel.paint(g);
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
                    gameModel.getMyTank().fire(); break;
                default: break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!kU && !kD && !kR && !kL){
                gameModel.getMyTank().setMoving(false);
            }else{
                gameModel.getMyTank().setMoving(true);
                if(kU) gameModel.getMyTank().setDir( Dir.UP);
                if(kD) gameModel.getMyTank().setDir(Dir.DOWN);
                if(kR) gameModel.getMyTank().setDir(Dir.RIGHT);
                if(kL) gameModel.getMyTank().setDir(Dir.LEFT);
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
