package com.mashibing.tank;

import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;


/**
 * @description: 坦克类
 * @author: yanxiaotian
 * @create: 2021-05-13 21:42
 **/
public class Tank extends GameObject {
    public final static int WIDTH = ImageMgr.tankD.getWidth();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public final static int HEIGHT = ImageMgr.tankD.getHeight();
    private final int SPEED = 5;
    private final Random random = new Random();
    public int x, y;
    public int preX,preY;
    public Dir dir = Dir.UP;
    public FireStrategy fireStrategy = null;
    public GameModel gm = null;
    boolean moving = true;
    boolean living = true;
    Rectangle rect = null;
    private Group group = Group.BAD;
    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        if (this.group == Group.GOOD) {
            String strategy = (String) PropertyMgr.get("defaultStrategy");
            try {
                fireStrategy = (FireStrategy) Class.forName(strategy).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String strategy = (String) PropertyMgr.get("defaultStrategy");
            try {
                fireStrategy = (FireStrategy) Class.forName(strategy).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getPreX() {
        return preX;
    }

    public void setPreX(int preX) {
        this.preX = preX;
    }

    public int getPreY() {
        return preY;
    }

    public void setPreY(int preY) {
        this.preY = preY;
    }

    public Rectangle getRect() {
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    @Override
    public void paint(Graphics g) {
        if (!this.living) {
            gm.remove(this);
            return;
        }
        move();
        randomDir();
        switch (dir) {
            case UP:
                g.drawImage(ImageMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ImageMgr.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ImageMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ImageMgr.tankR, x, y, null);
                break;
            default:
                break;
        }
    }

    public void randomDir() {
        if (random.nextInt(100) < 4) {
            int d = random.nextInt(10) % 5;
            switch (d) {
                case 0:
                    this.setDir(Dir.UP);
                    break;
                case 1:
                    this.setDir(Dir.DOWN);
                    break;
                case 2:
                    this.setDir(Dir.LEFT);
                    break;
                case 3:
                    this.setDir(Dir.RIGHT);
                    break;
                default:
                    break;
            }
        }
    }

    private void move() {
        preX=x;
        preY=y;
        if (!moving) {
            return;
        }
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x + WIDTH > TankFrame.GAME_WIDTH || y + HEIGHT > TankFrame.GAME_HEIGHT) {
            switch (dir) {
                case UP:
                    y += SPEED;
                    break;
                case DOWN:
                    y -= SPEED;
                    break;
                case LEFT:
                    x += SPEED;
                    break;
                case RIGHT:
                    x -= SPEED;
                    break;
                default:
                    break;
            }
        }
        if (random.nextInt(100) < 2) {
            this.fire();
        }
    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getSPEED() {
        return SPEED;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        fireStrategy.fire(this);
    }

    public void die() {
        gm.add(new Explode(x, y, gm));
        this.living = false;
    }

    public void stop(){
        this.moving=false;
    }
}
