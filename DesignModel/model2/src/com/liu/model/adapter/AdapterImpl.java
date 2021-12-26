package com.liu.model.adapter;

/**
 * @author lms
 * @date 2021-08-31 - 22:07
 */
public class AdapterImpl implements Adapter {

    // 将网线插入到适配器中
    private Cable cable;

    // 传入具体的网线
    public void setCable(Cable cable) {
        this.cable = cable;
    }

    // 适配器实现具体的上网操作
    @Override
    public void handlerNet() {
        cable.request();
    }
}
