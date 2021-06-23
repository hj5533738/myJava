package com.msb.test01;

/**
 * @Auther: houjie
 * @Date: 2021/5/28 - 05 - 28 - 23:10
 * @Description: com.msb.test01
 * @version: 1.0
 */
public class fruitPizza extends Pizza{
    //属性：
    private String peiliao;

    public String getPeiliao() {
        return peiliao;
    }

    public void setPeiliao(String peiliao) {
        this.peiliao = peiliao;
    }
    //重写父类的showPizza方法
    @Override
    public String showPizza() {
        return super.showPizza()+"\n培根的配料是："+peiliao;
    }

    //构造器
    public fruitPizza() {
    }

    public fruitPizza(String peiliao) {
        this.peiliao = peiliao;
    }

    public fruitPizza(String name, int size, int price, String peiliao) {
        super(name, size, price);
        this.peiliao = peiliao;
    }
}
