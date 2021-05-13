package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-04-24 11:02
 **/
public class T {
    public static void main(String[] args) throws Exception{
        TankFrame frame=new TankFrame();
        while(true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
