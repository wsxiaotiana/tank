package com.mashibing.tank;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-04-24 11:02
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        TankFrame frame=new TankFrame();
        for(int i=0; i<4; i++){
           frame.enemies.add(frame.warFactory.createTank(300+i*80,300, Dir.DOWN,frame,Group.BAD));
        }

        while(true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
