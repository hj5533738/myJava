package com.msb.game;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: houjie
 * @Date: 2021/5/29 - 05 - 29 - 10:56
 * @Description: com.msb.game
 * @version: 1.0
 */
public class StartGame {
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //给窗体设置一个标题
        jf.setTitle("贪吃蛇 小游戏");
        //设置窗体弹出的坐标，对应窗体的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //设置窗体大小不可调
        jf.setResizable(false);
        //关闭窗口的同时，程序关闭，设置默认关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板
        GamePanel gp = new GamePanel();
        //将面板放入窗体
        jf.add(gp);
        //默认情况下窗体是隐形，设置为显示--->细节，显现
        jf.setVisible(true);
    }
}
