package com.msb.test01;

/**
 * @Auther: houjie
 * @Date: 2021/5/28 - 05 - 28 - 23:13
 * @Description: com.msb.test01
 * @version: 1.0
 */
public class baconPizza extends Pizza{
    //属性
    private  int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    //重写父类的showPizza方法
    @Override
    public String showPizza() {
        return super.showPizza()+"\n培根的克数是："+weight;
    }

    //构造器
    public baconPizza() {
    }

    public baconPizza(int weight) {
        this.weight = weight;
    }

    public baconPizza(String name, int size, int price, int weight) {
        super(name, size, price);
        this.weight = weight;
    }
}
