package com.liu.crud.bean;

import com.github.pagehelper.PageInfo;

import java.awt.image.Kernel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 设置一个状态类，用于提示用户访问页面的状态
 * @author lms
 * @date 2021-04-20 - 16:58
 */
public class Msg {
    // 状态码： 100-成功
    // 200 - 失败
    private int code;
    // 给用户的提示信息
    private String msg;
    // 用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<>();

    // 设置一个添加方法
    public Msg add(String key, Object value) {
        // 先当前对象的extend集合，再给该集合设值
        this.getExtend().put(key, value);
        return this;
    }

    // 获取当前执行状态的信息
    public static Msg success() {
        // 创建一个Msg对象，并设置状态码，以及返回的信息
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("执行成功!");
        return result;
    }

    // 获取当前执行状态的信息
    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("执行失败!");
        return result;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}
