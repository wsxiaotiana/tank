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
    private Tank tank=new Tank(200,200,Dir.UP);
    public TankFrame() throws HeadlessException {
        setSize(800,600);
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

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
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
                default: break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!kU && !kD && !kR && !kL){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(kU) tank.setDir( Dir.UP);
                if(kD) tank.setDir(Dir.DOWN);
                if(kR) tank.setDir(Dir.RIGHT);
                if(kL) tank.setDir(Dir.LEFT);
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
