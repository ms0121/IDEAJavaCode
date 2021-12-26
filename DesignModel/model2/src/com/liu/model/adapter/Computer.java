package com.liu.model.adapter;

/**
 * @author lms
 * @date 2021-08-31 - 22:01
 * 适配者模式
 */
public class Computer {
    // 电脑需要连接网线才能上网，网线不可以直接插在笔记本上，
    // 此时就需要设计一个适配器，将网线插在适配器上面，然后也要将笔记本插在适配器上
    public void net(Adapter adapter){
        adapter.handlerNet();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Cable cable = new Cable();
        AdapterImpl adapter = new AdapterImpl();
        adapter.setCable(cable);

        // 此时笔记本就可以通过适配器连接到网线，从而实现上网的操作
        computer.net(adapter);
    }
}
