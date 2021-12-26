package com.xxxx.crm3.controller;

import com.xxxx.crm3.base.BaseController;
import com.xxxx.crm3.query.CusDevPlanQuery;
import com.xxxx.crm3.query.SaleChanceQuery;
import com.xxxx.crm3.service.CusDevPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-23 - 9:35
 * 客户开发计划
 */

@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController extends BaseController {

    @Resource
    private CusDevPlanService cusDevPlanService;

    /**
     * 客户开发计划首页
     * @return
     */
    @GetMapping("index")
    public String cusDevPlan(){
        return "cusDevPlan/cus_dev_plan";
    }


    /**
     * 因为前段页面的表格数据要求返回的是Map类型的数据
     * @param query
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Map<String, Object> queryCusDevPlanByParams(CusDevPlanQuery query){
        return cusDevPlanService.queryCusDevPlanByQuery(query);
    }



}
