package com.msb.test01;

/**
 * @Auther: houjie
 * @Date: 2021/5/28 - 05 - 28 - 23:05
 * @Description: com.msb.test01
 * @version: 1.0
 */
public class Pizza {
    //属性
    private String name;
    private int size;
    private int price;

    //方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //展示披萨信息
    public  String showPizza(){
        return "披萨的名字是："+name+"\n披萨的大小是："+size+"\n披萨的价格："+price;

    }
    //构造器
    public Pizza() {
    }

    public Pizza(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
}
