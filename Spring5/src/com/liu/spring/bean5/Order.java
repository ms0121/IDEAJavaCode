package com.liu.spring.bean5;

/**
 * @author lms
 * @date 2021-04-11 - 11:02
 *
 * 1. bean  生命周期(不考虑后置处理器)
     * （1）通过构造器创建 bean 实例（无参数构造）
     * （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
     * （3）调用 bean 的初始化的方法（需要进行配置初始化的方法）
     * （4）bean 可以使用了（对象获取到了）
     * （5）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
 *
 *
 * 2. 、如果考虑bean的后置处理器，则 bean 生命周期有七步:
         * （1）通过构造器创建 bean 实例（无参数构造）
         * （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
         * （3) 把  bean  实例传递  bean  后置处理器的方法 postProcessBeforeInitialization
         * （4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
         * （5）把 bean  实例传递 bean  后置处理器的方法 postProcessAfterInitialization
         * （6）bean 可以使用了（对象获取到了）
         * （7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
 */
public class Order {
    private String name;

    public Order() {
        System.out.println("1. 无参构造方法执行了");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2. 调用了set方法设置属性值");
    }

    // 创建执行的初始化方法
    public void initMethod() {
        System.out.println("3. 调用了initMethod初始化方法");
    }

    // 创建执行销毁的方法
    public void destroyMethod() {
        System.out.println("5. 调用了destroy销毁方法");
    }

}
