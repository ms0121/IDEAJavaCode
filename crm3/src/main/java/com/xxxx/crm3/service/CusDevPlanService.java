package com.xxxx.crm3.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.crm3.base.BaseService;
import com.xxxx.crm3.dao.CusDevPlanMapper;
import com.xxxx.crm3.query.CusDevPlanQuery;
import com.xxxx.crm3.vo.CusDevPlan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-23 - 9:40
 */
@Service
public class CusDevPlanService extends BaseService<CusDevPlan, Integer> {

    @Resource
    private CusDevPlanMapper cusDevPlanMapper;

    /**
     * 查询客户开发计划数据信息
     * @param query 多条件查询
     * @return Map：前段表格需要的数据形式是Map类型的数据信息
     */
    public Map<String, Object> queryCusDevPlanByQuery(CusDevPlanQuery query) {
        HashMap<String, Object> map = new HashMap<>();
        // 设置查询返回数据的分页信息
        PageHelper.startPage(query.getPage(), query.getLimit());
        // 多条件查询
        List<CusDevPlan> cusDevPlans = cusDevPlanMapper.selectByParams(query);
        // 将条件查询得到的数据封装在PageInfo中
        PageInfo<CusDevPlan> cusDevPlanPageInfo = new PageInfo<>(cusDevPlans);
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count",cusDevPlanPageInfo.getTotal());
        map.put("data", cusDevPlanPageInfo);
        return map;
    }
}
