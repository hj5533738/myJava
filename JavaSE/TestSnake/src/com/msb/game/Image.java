package com.msb.game;

import javax.swing.*;
import java.net.URL;

/**
 * @Auther: houjie
 * @Date: 2021/5/29 - 05 - 29 - 10:38
 * @Description: com.msb.game
 * @version: 1.0
 */
public class Image {
    //将图片路径封装为对象
    public static URL bodyURL = Image.class.getResource("/image/body.png");
    public static ImageIcon bodyImage = new ImageIcon(bodyURL);
    //将图片路径封装为对象
    public static URL downURL = Image.class.getResource("/image/down.png");
    public static ImageIcon downImage = new ImageIcon(downURL);
    //将图片路径封装为对象
    public static URL foodURL = Image.class.getResource("/image/food.png");
    public static ImageIcon foodImage = new ImageIcon(foodURL);
    //将图片路径封装为对象
    public static URL headURL = Image.class.getResource("/image/head.png");
    public static ImageIcon headImage = new ImageIcon(headURL);
    //将图片路径封装为对象
    public static URL leftURL = Image.class.getResource("/image/left.png");
    public static ImageIcon leftImage = new ImageIcon(leftURL);
    //将图片路径封装为对象
    public static URL rightURL = Image.class.getResource("/image/right.png");
    public static ImageIcon rightImage = new ImageIcon(rightURL);
    //将图片路径封装为对象
    public static URL upURL = Image.class.getResource("/image/up.png");
    public static ImageIcon upImage = new ImageIcon(upURL);
}
