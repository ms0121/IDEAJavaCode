package com.liu.web;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.google.gson.Gson;
import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import com.liu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.LogicalHandler;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lms
 * @date 2021-04-04 - 10:50
 */
public class UserServlet extends BaseServlet {

    // 创建UserServiceImpl的对象去操作数据库信息
    private UserService userService = new UserServiceImpl();


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求响应的参数username
        String username = req.getParameter("username");
        // 调用userService.existUsername(username)判断当前用户是否存在
        boolean existsUsername  = userService.existUsername(username);
        // 把响应的结果保存到map中
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("existsUsername", existsUsername);

        // 将map转为json对象, 进行发送数据
        Gson gson = new Gson();
        String json = gson.toJson(resMap);

        resp.getWriter().write(json);

    }

    /**
     * 注销用户的登录信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将session进行销毁
        req.getSession().invalidate();
        // 将页面重定向到首页, req.getContextPath()表示的是定位到项目首页，即到web
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 实现登录的模块
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(new User(username, password, null));
        if (user == null){
            // 把登录失败的错误信息进行回传提示，并把错误信息和回显的表单项信息保存到request域中
            // 所以需要回显的信息都需要将其保存到request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            // 登录失败,无论是否登陆成功都需要设置跳转的页面路径信息，以及请求重传
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 保存用户的登录信息到session域中
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 实现注册的功能模块
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取session中的验证码，然后将验证码进行删除
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 获取注册页面的属性值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 强制类型转换
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 在servlet页面进行注册
        // 首先检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            // 在通过UserService层来判断数据库中是否存在该信息
            if (userService.existUsername(username)) {
                // 注册失败，把回显的信息保存到request域中
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                System.out.println("该用户 [" + username + "] 信息已经存在!");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 直接进行注册用户的信息
                userService.registerUser(new User(username, password, email));
                // 跳转到注册成功的页面，第一个路径信息指的是跳转到的页面路径信息，从而实现请求的转发
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            // 注册失败，把回显的信息保存到request域中
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            // 验证码不正确，直接返回注册页面
            System.out.println("验证码 [" + code + "] 错误，请重新注册");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

}
