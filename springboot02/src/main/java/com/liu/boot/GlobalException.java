package com.liu.boot;

import com.liu.boot.exception.ParamsException;
import com.liu.boot.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-09-27 - 10:42
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalException {

    // 拦截所有的异常信息,需要按照json的格式返回数据
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo exceptionHandler(Exception e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg(e.getMessage());
        return resultInfo;
    }

    // 拦截指定的异常信息，返回的是json形式的数据
    @ExceptionHandler(value = ParamsException.class)
    @ResponseBody
    public ResultInfo paramsException(ParamsException e) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(e.getCode());
        resultInfo.setMsg(e.getMsg());
        return resultInfo;
    }
}
