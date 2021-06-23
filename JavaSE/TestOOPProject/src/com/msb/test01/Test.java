package com.msb.test01;

import java.util.Scanner;

/**
 * @Auther: houjie
 * @Date: 2021/5/28 - 05 - 28 - 23:15
 * @Description: com.msb.test01
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //选择购买的披萨
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你要购买的披萨：（1.培根披萨 2.水果披萨）");
        int choice = sc.nextInt();
        //通过工厂获得披萨
        Pizza pizza = pizzaStore.getPizza(choice);
        System.out.println(pizza.showPizza());

    }
}
