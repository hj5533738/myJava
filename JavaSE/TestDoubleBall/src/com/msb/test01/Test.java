package com.msb.test01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //声明一个数组，用来接收7个球的数字：
        int[] balls = new int[7];
        //购买注数
        int count = 0;
        //定义一个变量，设定是否买彩票
        boolean isbuy = false;
        //定义一个字符串，接收整个收支的明细
        String details = "";
        //定义一个字符串，接收余额
        int balance = 0;//初始化金额为0
        while (true) {
            System.out.println("--------欢迎进入双色球彩票系统-------");
            System.out.println("1.购买彩票");
            System.out.println("2.查看开奖");
            System.out.println("3.退出");
            System.out.println("请选择你要完成的功能");
            //拿来一个扫描器
            Scanner sc = new Scanner(System.in);
            //接收键盘录入的int类型的数据
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("双色球系统》》》》》购买彩票");
                    System.out.println("请选择你需要购买几注");
                    count = sc.nextInt();//购买数量

                    for (int i = 1; i <= 7; i++) {
                        if (i != 7) {
                            System.out.println("请录入第" + i + "个红球");
                            int redBall = sc.nextInt();
                            balls[i - 1] = redBall;
                        } else {
                            System.out.println("请录入1个蓝球");
                            int blueBall = sc.nextInt();
                            balls[6] = blueBall;
                        }
                    }
                    //提示完整信息：
                    System.out.println("您购买了" + count + "注彩票，一共消费了" + count * 2 + "元钱，您购买的彩票号码为：");
                    //遍历数组
                    for (int num : balls) {
                        System.out.print(num + "\t");
                    }
                    System.out.println();
                    //彩票购买
                    isbuy = true;
                    break;
                case 2:
                    //1.判断是否购买彩票
                    if(isbuy == true){
                        //2.中奖号码
                        int[] luckBall = getLuckBall();
                        //3.将两组号码进行对比
                        int level = getLevel(balls, luckBall);
                        //4.根据level的结果执行后面的逻辑
                        switch (level) {
                            case 1:
                                System.out.println("恭喜你，中了一等奖，1注奖金500万，您一共获得：" + 500 * count + "万元");
                                break;
                            case 2:
                                System.out.println("恭喜你，中了二等奖，1注奖金300万，您一共获得：" + 300 * count + "万元");
                                break;
                            case 3:
                                System.out.println("恭喜你，中了三等奖，1注奖金100万，您一共获得：" + 100 * count + "万元");
                                break;
                            case 4:
                                System.out.println("恭喜你，中了四等奖，1注奖金50万，您一共获得：" + 50 * count + "万元");
                                break;
                            case 5:
                                System.out.println("恭喜你，中了五等奖，1注奖金2000元，您一共获得：" + 2000 * count + "元");
                                break;
                            case 6:
                                System.out.println("恭喜你，中了六等奖，1注奖金5元，您一共获得：" + 5 * count + "元");
                                break;
                        }
                        System.out.println("双色球系统》》》》》查看开奖");
                    }else{
                        System.out.println("对不起，请先购买彩票");
                    }
                    break;
                case 3:
                    System.out.println("双色球系统》》》》》退出");
                    return;
            }
        }

    }


    //定义一个方法，专门用来生成中奖号码
    public static int[] getLuckBall(){
        //int[] luckBall ={1,2,3,4,5,6,7};
        int[] luckBall = new int[7];
        //红球：1——33
        //蓝色：1——16
        for(int i = 1;i<=7;i++){
            if(i!=7){
                luckBall[i-1] = (int) (Math.random()*33)+1;
            }else{
                luckBall[6] = (int) (Math.random()*16)+1;
            }
        }
        return luckBall;
    }

    //定义一个方法，专门用对比中奖号码
    public static int getLevel(int[] balls, int[] luckBall) {
        int level = 0;
        //计数器：用来记红球有几个相等
        int redCount = 0;
        //计数器：用来记蓝球有几个相等
        int blueCount = 0;
        for (int i = 0; i <= 6; i++) {
            if (i != 6) {
                for (int j = 0; j <= 5; j++) {
                    if (balls[i] == luckBall[j]) {
                        redCount++;
                    }
                }
            } else {
                if (balls[6] == luckBall[6]) {
                    blueCount++;
                }
            }
        }
        //输出比对结果
        System.out.println("红球有" + redCount + "个相等");
        System.out.println("蓝球有" + blueCount + "个相等");

        //根据红球和蓝球的相等数量，得到level的具体结果
        if (redCount == 6 && blueCount == 1) {
            level = 1;
        } else if (redCount == 6) {
            level = 2;
        } else if (redCount == 5 && blueCount == 1) {
            level = 3;
        } else if (redCount == 5 || redCount == 4 && blueCount == 1) {
            level = 4;
        } else if (redCount == 4 || redCount == 3 && blueCount == 1) {
            level = 5;
        } else {
            level = 6;
        }
        return level;
    }
}


