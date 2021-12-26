package com.xxxx.crm3.controller;

import com.xxxx.crm3.base.BaseController;
import com.xxxx.crm3.base.ResultInfo;
import com.xxxx.crm3.enums.StateStatus;
import com.xxxx.crm3.exceptions.ParamsException;
import com.xxxx.crm3.query.SaleChanceQuery;
import com.xxxx.crm3.query.UserQuery;
import com.xxxx.crm3.service.SaleChanceService;
import com.xxxx.crm3.service.UserService;
import com.xxxx.crm3.utils.AssertUtil;
import com.xxxx.crm3.utils.CookieUtil;
import com.xxxx.crm3.utils.LoginUserUtil;
import com.xxxx.crm3.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @date 2021-10-10 - 15:47
 */
@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {

    @Resource
    private SaleChanceService saleChanceService;

    @Resource
    private UserService userService;

    // 营销机会管理首页
    @GetMapping("index")
    public String index(){
        return "saleChance/sale_chance";
    }

    /**
     * 因为前段页面的表格数据要求返回的是Map类型的数据
     *
     * @param query
     * @param flag 规定flag = 1表示当前是开发计划，否则为普通的营销机会查询
     * @param request
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> querySaleChanceByParams(SaleChanceQuery query,
                                                       Integer flag,
                                                       HttpServletRequest request){
        // 说明当前操作的是客户开发计划
        if (flag != null && flag == 1){
            // 设置分配状态
            query.setState(StateStatus.STATED.getType());
            // 设置分配人（设置分配人的id信息）
            Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
            System.out.println("userId = " + userId);
            query.setAssignMan(String.valueOf(userId));
        }
        return saleChanceService.querySaleChanceByQuery(query);
    }

    // 跳转到添加修改的页面
    @GetMapping("toSaleChancePage")
    public String toSaleChancePage(HttpServletRequest request, Integer saleChanceId, Model model){
        // 如果saleChanceId不等于null，表示当前操作为修改操作
        if (saleChanceId != null){
            // 查询数据信息并设置在model中，然后跳转到修改添加页面
            SaleChance saleChance = saleChanceService.selectByPrimaryKey(saleChanceId);
            // System.out.println("saleChance.getAssignMan() = " + saleChance.getAssignMan());
            model.addAttribute("saleChance", saleChance);
        }
        return "saleChance/add_update";
    }

    /**
     * 要求前端中的参数名和SaleChance中的参数名一样，否则无法传递参数至实体类中
     * @param request
     * @param saleChance
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo add(HttpServletRequest request, SaleChance saleChance){
        // 从cookie中获取当前操作的用户（将其设置为新增用户的创建人）
        String userName = CookieUtil.getCookieValue(request, "userName");
        saleChance.setCreateMan(userName);
        // 添加营销机会数据信息
        saleChanceService.saveSaleChance(saleChance);
        return success("营销数据添加成功");
    }


    /**
     * 要求前端中的参数名和SaleChance中的参数名一样，否则无法传递参数至实体类中
     * @param saleChance
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo update(SaleChance saleChance, HttpServletRequest request){
        // 修改营销机会数据信息
        saleChanceService.updateSaleChance(saleChance);
        return success("营销数据更新成功");
    }

    /**
     * 根据用户id删除单一的数据信息（包括批量删除的操作）
     * @param ids
     * @return 返回的是json形式的数据对象信息
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer[] ids){
        System.out.println("ids.length = " + ids.length);
        ResultInfo resultInfo = new ResultInfo();
        AssertUtil.isTrue(ids.length <= 0, "请选择删除的记录");
        AssertUtil.isTrue(saleChanceService.deleteBatch(ids) < 1, "删除失败");
        return success("删除成功");
    }


}
