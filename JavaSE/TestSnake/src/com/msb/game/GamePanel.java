package com.msb.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @Auther: houjie
 * @Date: 2021/5/29 - 05 - 29 - 11:16
 * @Description: com.msb.game
 * @version: 1.0
 * 继承了JPanel才成为一个面板
 */
public class GamePanel extends JPanel {
    //定义两个数组
    //蛇的长度
    int length;
    //一个数组，专门存储蛇的X轴坐标
    int[] snakeX = new int[200];
    //一个数组，专门存储蛇的Y轴坐标
    int[] snakeY = new int[200];
    //游戏只有两个状态，开始or暂停
    boolean isstart = false;// 默认暂停状态
    //加入一个定时器
    Timer time;
    //定义蛇的行走方向
    String direction;
    //定义食物的x,y轴坐标
    int foodX;
    int foodY;
    //定义积分
    int score = 0;
    //加入一个变量，判断小蛇的死亡状态
    boolean isDie = false;//默认情况下小蛇没有死亡

    public void init(){
        //初始化蛇的长度
        length = 3;
        //初始化蛇头坐标
        snakeX[0] = 175;
        snakeY[0] = 275;
        //初始化第一节身子坐标
        snakeX[1] = 150;
        snakeY[1] = 275;
        //初始化第二节身子坐标
        snakeX[2] = 125;
        snakeY[2] = 275;
        //初始化蛇头的方向
        direction = "R";
        //食物的初始化位置
        foodX = 300;
        foodY = 200;

    }
    public GamePanel() {
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int KeyCode = e.getKeyCode();
                System.out.println(KeyCode);
                if(KeyCode == KeyEvent.VK_SPACE){//箭头空格
                    if(isDie){
                        //恢复到初始化状态
                        init();
                        isDie = false;
                    }else{//小蛇没有死亡的情况
                        isstart = !isstart;//检测到空格以后，游戏开始暂停的控制
                        repaint();//重绘的动作
                       }
                    }
                //箭头向上箭头
                if(KeyCode == KeyEvent.VK_UP){//箭头空格
                    direction = "U";//检测到U以后
                }
                //箭头向下箭头
                if(KeyCode == KeyEvent.VK_DOWN){//箭头空格
                    direction = "D";//检测到D以后
                }
                //箭头向左箭头
                if(KeyCode == KeyEvent.VK_LEFT){//箭头空格
                    direction = "L";//检测到L以后
                }
                //箭头向右箭头
                if(KeyCode == KeyEvent.VK_RIGHT){//箭头空格
                    direction = "R";//检测到R以后
                }
            }
        });
        //对定时器进行初始化操作
        time = new Timer(100, new ActionListener() {
            /*
            ActionListener是事件监听
            相当于每100s监听一下是否发生了动作
            具体动作放在actionPerformed
            */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isstart == true&&isDie == false){//游戏开始状态，蛇才动，后一节走到前一节的位置
                    for(int i=length-1;i>0;i--){
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }
                    //动头
                    if("R".equals(direction)){
                        snakeX[0] += 25;
                    }
                    if("L".equals(direction)){
                        snakeX[0] -= 25;
                    }
                    if("U".equals(direction)){
                        snakeY[0] -= 25;
                    }
                    if("D".equals(direction)){
                        snakeY[0] += 25;
                    }
                    //防止蛇飞出边界
                    if(snakeX[0]>750){
                        snakeX[0] = 25;
                    }
                    if(snakeX[0]<25){
                        snakeX[0] = 750;
                    }
                    if(snakeY[0]<100){
                        snakeY[0] = 725;
                    }
                    if(snakeY[0]>725){
                        snakeY[0] = 100;
                    }
                    //检测碰撞的动作
                    //食物的坐标和蛇头的坐标一样的时候，才是碰撞了
                    if(snakeX[0] == foodX&&snakeY[0] == foodY){
                        //蛇的长度加1
                        length++;
                        //食物坐标改变，随机生成坐标--->必须是25的倍数
                        foodX =( (int) (Math.random()*30)+1)*25;//[25,750] [1,30]*25
                        foodY = (new Random().nextInt(26)+4)*25;//[100,725] [4,29]*25
                        //吃上食物之后积分加10
                        score += 10;
                    }
                    //死亡判断
                    for(int i = 1;i<length;i++){
                        if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                            //提示ture状态
                            isDie = true;
                        }
                    }
                    repaint();//重绘界面
                }
            }
        });
        //定时器需要启动
        time.start();
    }

    //paintComponent方法比较特殊，属于图形版的main方法，自动调用
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景颜色
        this.setBackground(new Color(226, 224, 221));
        //画头部的图片，paintIcon四个参数：this指的是当前面板，g指的是使用的画笔，xy指对应的坐标
        Image.headImage.paintIcon(this,g,10,10);
        //调整画笔颜色---->类比画图板，先调整颜色再画图
        g.setColor(new Color(220, 146, 146));
        //画一个矩形
        g.fillRect(10,70,770,685);

        //画出小蛇
        if("R".equals(direction)){
            Image.rightImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("U".equals(direction)){
            Image.upImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("D".equals(direction)){
            Image.downImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("L".equals(direction)){
            Image.leftImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
/*        Image.bodyImage.paintIcon(this,g,snakeX[1],snakeY[1]);
        Image.bodyImage.paintIcon(this,g,snakeX[2],snakeY[2]);*/
        //优化为循环画出蛇的身体
        for(int i = 1;i<length;i++){
            Image.bodyImage.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //如果游戏暂停，界面中间就应该有一句提示语：
        if(isstart == false){
            //画一个文字
            g.setColor(new Color(114,98,255));
            //三个参数：字体，加粗，字号
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字：三个参数，文字内容
            g.drawString("点击空格开始游戏",250,330);
        }
        //画食物
        Image.foodImage.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(220, 45, 220));
        //三个参数：字体，加粗，字号
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        //画文字：三个参数，文字内容
        g.drawString("积分："+score,620,40);

        //画出死亡状态
        if(isDie){
            g.setColor(new Color(236, 29, 29));
            //三个参数：字体，加粗，字号
            g.setFont(new Font("微软雅黑",Font.BOLD,25));
            //画文字：三个参数，文字内容
            g.drawString("小蛇死亡，游戏停止，按下空格重新开始",250,300);
        }
    }
}
