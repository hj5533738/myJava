package com.msb.test01;

import java.util.Scanner;

/**
 * @Auther: houjie
 * @Date: 2021/5/28 - 05 - 28 - 23:39
 * @Description: com.msb.test01
 * @version: 1.0
 */
public class pizzaStore {
    public static Pizza getPizza(int choice){
        Scanner sc = new Scanner(System.in);
        Pizza p = null;
        switch (choice){
            case 1: {
                System.out.println("请录入培根的克数：");
                int weight = sc.nextInt();
                System.out.println("请录入披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请录入披萨的价格：");
                int price = sc.nextInt();
                //将录入的信息封装为培根披萨的对象
                baconPizza bp = new baconPizza("培根披萨",size,price,weight);
                p = bp;
            }
            break;
            case 2:{
                System.out.println("请录入你想要加入的水果：");
                String peiliao = sc.next();
                System.out.println("请录入披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请录入披萨的价格：");
                int price = sc.nextInt();
                fruitPizza fp = new fruitPizza("水果披萨",size,price,peiliao);
                p = fp;
            }
            break;
        }
        return p;
    }
}
