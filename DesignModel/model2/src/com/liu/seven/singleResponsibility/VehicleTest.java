package com.liu.seven.singleResponsibility;

/**
 * @author lms
 * @date 2021-08-31 - 16:18
 * 七大原则： 单一职责原则
 * 总的而言就是各干各的工作，互不干扰
 */
public class VehicleTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.runRoad("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}


class Vehicle{

    public void runRoad(String name){
        System.out.println(name + "正在陆地上运行..........");
    }

    public void runAir(String name){
        System.out.println(name + "正在天空中运行..........");
    }

    public void runWater(String name){
        System.out.println(name + "正在大海里运行..........");
    }

}
