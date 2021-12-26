package com.liu.boot.controller;

import com.liu.boot.bean.User;
import com.liu.boot.utils.AssertUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lms
 * @date 2021-09-27 - 8:31
 *
 * Swagger2使用解析：
 *
 *  @Api：用在请求的类上，用于说明当前类的作用
 *      tags="说明该类的作用"
 *
 *  @ApiOperation：用在请求的方法上面，说明该方法的作用
 *      value：说明方法的作用
 *      note：方法的注解说明
 *
 *  @ApiImplicitParams: 用在请求方法上，包含一组参数的说明
 *       @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的配置信息
 *        name：参数名
 *        value:参数的说明，解析
 *        required：参数是否必须传递
 *        paramType：参数放在哪个地方
 *           header： 请求参数的获取 @RequestHeader
 *           query: 请求参数的获取 @RequestParam
 *           path：用于restful接口， 请求参数的获取：@PathVariable
 *           body：不常用
 *           form：不常用
 *        dataTye：参数的类型，其他值dataType="Integer"
 *        defaultValue：参数的默认值
 *
 *  @ApiResponses:用于请求的方法上，表示一组相应
 *      @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
 *          code：数字，如400
 *          message：信息，例如：请求参数没有填好
 *          response：抛出异常的类
 *
 *  @ApiModel:用于响应类上，表示一个返回响应数据的信息，这种一般用在post创建的时候，
 *      使用@responseBody的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候
 *      @ApiModelProperty:用在属性上，描述响应类的属性
 *
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块")
public class UserController {

    /**
     * user以字段的方式进行传递，不能使用json方式进行传递
     * @param user
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "用户添加", notes = "user参数以字段的方式传")
    @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    public String add(User user){
//        AssertUtils.isTrue(StringUtils.isBlank(user.getName()), "用户名不能为空!");
        System.out.println("user = " + user);
        return "用户添加成功!";
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("用户删除")
    @ApiImplicitParam(name = "id", value = "用户名的id", required = true, paramType = "path", dataType = "Integer")
    public String delete(@PathVariable Integer id){
        System.out.println("id = " + id);
        return "用户删除成功!";
    }

    /**
     * 因为使用的@RequestBody注解，所以当前传递过来的数据必须是json数据形式
     * @param user
     * @return
     */
    @PutMapping("update")
    @ApiOperation("用户更新")
    public String delete(@RequestBody User user){
        System.out.println("user = " + user);
        return "用户修改成功!";
    }

    @GetMapping("get/{id}")
    @ApiOperation("用户查询")
    public String get(@PathVariable Integer id, HttpServletRequest request){
//        int i = 1 / 0;
//        String name = "";
//        AssertUtils.isTrue(StringUtils.isBlank(name), "用户名不能为空!");
        String userName = (String) request.getSession().getAttribute("name");
        AssertUtils.isTrue(StringUtils.isBlank(userName), "用户未登录!");
        System.out.println("id = " + id);
        return "用户删除成功!";
    }
}
