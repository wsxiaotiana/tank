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
    public static BufferedImage tankU,tankD,tankL,tankR;
    public static BufferedImage bulletU,bulletD,bulletL,bulletR;
    static {
        try {
            tankU = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            tankD = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
            tankL = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
            tankR = ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));

            bulletU=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletD=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
            bulletL=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/bulletL.gif"));
            bulletR=ImageIO.read(ImageMgr.class.getClassLoader().getResourceAsStream("image/bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
