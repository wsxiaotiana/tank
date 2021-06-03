package com.mashibing.tank;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-04-24 11:02
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        TankFrame frame=new TankFrame();

        while(true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
