package com.xxxx.crm3.controller;

import com.xxxx.crm3.base.BaseController;
import com.xxxx.crm3.base.ResultInfo;
import com.xxxx.crm3.model.UserModel;
import com.xxxx.crm3.service.UserService;
import com.xxxx.crm3.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-09-27 - 17:48
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    // 登录页面
    @PostMapping("login")
    @ResponseBody
    public ResultInfo userLogin(String userName, String userPwd) {
        ResultInfo resultInfo = new ResultInfo();

        UserModel userModel = userService.userLogin(userName, userPwd);
        resultInfo.setResult(userModel);

//        UserModel userModel = null;
//        // 通过try catch捕获service层抛出的异常信息，如果service层抛出了异常信息，则表明登录失败
//        try {
//            userModel = userService.userLogin(userName, userPwd);
//            resultInfo.setResult(userModel);
//        } catch (ParamsException e) {
//            // 捕获自定义异常信息
//            resultInfo.setCode(e.getCode());
//            resultInfo.setMsg(e.getMsg());
//            e.printStackTrace();
//        }catch (Exception e) {
//            // 捕获其他的异常信息，
//            resultInfo.setCode(500);
//            resultInfo.setMsg("登录失败!");
//            e.printStackTrace();
//        }

        return resultInfo;
    }

    // 跳转至修改密码页面
    @RequestMapping("toPasswordPage")
    public String updatePassword() {
        return "user/password";
    }

    // 跳转至设置页面
    @RequestMapping("toSettingPage")
    public String toSettingPage() {
        return "user/setting";
    }


    // 修改用户密码
    @PostMapping("updatePwd")
    @ResponseBody
    public ResultInfo updatePwd(String oldPassword, String newPassword, String confirmPassword,
                                HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        // 从cookie中获取用户的id信息
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 修改用户密码
        userService.updatePassword(userId, oldPassword, newPassword, confirmPassword);

//        try {
//            // 修改用户密码
//            userService.updatePassword(userId, oldPassword, newPassword, confirmPassword);
//        } catch (ParamsException p) {
//            resultInfo.setCode(p.getCode());
//            resultInfo.setMsg(p.getMsg());
//            p.printStackTrace();
//        }catch (Exception e) {
//            resultInfo.setCode(500);
//            resultInfo.setMsg("用户密码修改失败!");
//            e.printStackTrace();
//        }
        return resultInfo;
    }


    /**
     * 更新用户信息
     *
     * @param phone
     * @param email
     * @param trueName
     * @return
     */
    @PostMapping("updateSetting")
    @ResponseBody
    public ResultInfo updateUserInfo(String phone, String email, String trueName, HttpServletRequest request) {
        ResultInfo resultInfo = new ResultInfo();
        // 从cookie中获取用户的id信息
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        userService.updateUserInfo(userId, phone, email, trueName);
        return resultInfo;
    }

    /**
     * 查询所有的销售人员信息
     * @return
     */
    @GetMapping("queryAllSales")
    @ResponseBody
    public List<Map<String, Object>> queryAllUser(){
        return userService.queryAllSales();
    }
}
