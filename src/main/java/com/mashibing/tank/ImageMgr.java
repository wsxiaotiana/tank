package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description: 加载图片
 * @author: yanxiaotian
 * @create: 2021-05-20 06:21
 **/
public class ImageMgr {
    public static BufferedImage goodTankU, goodTankD,goodTankL,goodTankR;
    public static BufferedImage badTankU, badTankD,badTankL,badTankR;
    public static BufferedImage bulletU,bulletD,bulletL,bulletR;
    public static BufferedImage[] explodeImages =new BufferedImage[16];
    static {
        try {
            goodTankU = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/GoodTank1.png"));
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);

            badTankU = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/BadTank1.png"));
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);

            bulletU=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/bulletU.png"));
            bulletD=ImageUtil.rotateImage(bulletU,180);
            bulletL=ImageUtil.rotateImage(bulletU,-90);
            bulletR=ImageUtil.rotateImage(bulletU,90);
            for(int i=0; i<explodeImages.length;i++){
                explodeImages[i]=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
