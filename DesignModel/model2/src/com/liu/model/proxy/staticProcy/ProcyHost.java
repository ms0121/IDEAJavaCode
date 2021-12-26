package com.liu.model.proxy.staticProcy;

/**
 * @author lms
 * @date 2021-08-31 - 20:37
 */
public class ProcyHost implements Rent {

    // 中介手中的房东信息
    private Host host;

    public ProcyHost(){
    }

    // 中间具体带过去看房子的是哪个主人
    public ProcyHost(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        look();
        // 中介帮房东进行租房子
        host.rent();
        hetong();
    }

    public void hetong(){
        System.out.println("签合同");
    }

    public void look(){
        System.out.println("到处看房子");
    }

}
