package com.mashibing.tank;

/**
 * @description: 坦克方向
 * @author: yanxiaotian
 * @create: 2021-05-13 21:09
 **/
public enum Dir {
    LEFT,UP,RIGHT,DOWN;
    public static Dir getOposite(Dir dir){
        switch(dir){
            case LEFT: return RIGHT;
            case UP: return DOWN;
            case RIGHT: return LEFT;
            case DOWN: return UP;
            default: break;
        }
        return dir;
    }
}
