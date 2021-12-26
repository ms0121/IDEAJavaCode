package com.xxxx.crm3.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.crm3.base.BaseService;
import com.xxxx.crm3.dao.SaleChanceMapper;
import com.xxxx.crm3.enums.DevResult;
import com.xxxx.crm3.enums.StateStatus;
import com.xxxx.crm3.query.SaleChanceQuery;
import com.xxxx.crm3.utils.AssertUtil;
import com.xxxx.crm3.utils.PhoneUtil;
import com.xxxx.crm3.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-10 - 15:46
 */
@Service
public class SaleChanceService extends BaseService<SaleChance, Integer> {

    @Resource
    private SaleChanceMapper saleChanceMapper;

    // 多条件分页查询营销数据
    public Map<String, Object> querySaleChanceByQuery(SaleChanceQuery query) {
        HashMap<String, Object> result = new HashMap<>();
        // 设置分页信息
        PageHelper.startPage(query.getPage(), query.getLimit());
        // 多条件查询所有的营销信息
        List<SaleChance> saleChances = saleChanceMapper.selectByParams(query);
        // 将条件查询得到的营销信息封装在PageInfo中
        PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChances);
        result.put("code", 0);
        result.put("msg", "success");
        // 总记录数
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 营销机会数据添加
     *   1.参数校验
     *       customerName:非空
     *       linkMan:非空
     *       linkPhone:非空 11位手机号
     *   2.设置相关参数默认值
     * state:默认未分配  如果选择分配人  state 为已分配
     *      assignTime:如果  如果选择分配人   时间为当前系统时间
     *      devResult:默认未开发 如果选择分配人devResult为开发中 0-未开发 1-开发中 2-开发成功 3-开发失败
     *      isValid:默认有效数据(1-有效  0-无效)
     *      createDate updateDate:默认当前系统时间
     * 3.执行添加 判断结果
     *
     * @param saleChance
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSaleChance(SaleChance saleChance) {
        checkParams(saleChance.getCustomerName(), saleChance.getLinkMan(), saleChance.getLinkPhone());
        // 默认设置为未指定分配人
        saleChance.setState(StateStatus.UNSTATE.getType());
        saleChance.setDevResult(DevResult.UNDEV.getStatus());

        // 选择分配人,则设置相应的字段信息（更新为已分配的状态）
        if (StringUtils.isNotBlank(saleChance.getAssignMan())) {
            saleChance.setState(StateStatus.STATED.getType());
            saleChance.setDevResult(DevResult.DEVING.getStatus());
            saleChance.setAssignTime(new Date());
        }
        saleChance.setIsValid(1);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
        AssertUtil.isTrue(saleChanceMapper.insertSelective(saleChance) < 1, "营销机会数据添加失败！");
    }

    // 校验参数
    private void checkParams(String customerName, String linkMan, String linkPhone) {
        AssertUtil.isTrue(StringUtils.isBlank(customerName), "请输入客户名");
        AssertUtil.isTrue(StringUtils.isBlank(linkMan), "请输入联系人");
        AssertUtil.isTrue(StringUtils.isBlank(linkPhone), "请输入联系人手机号码");
        AssertUtil.isTrue(!PhoneUtil.isMobile(linkPhone), "手机号码格式不正确");
    }

    /**
     * 营销机会数据更新
     * 1.参数校验
     *      id:记录必须存在
     *      customerName:非空
     *      linkMan:非空
     *      linkPhone:非空，11位手机号
     * 2. 设置相关参数值
     *      updateDate:系统当前时间
     *         原始记录 未分配 修改后改为已分配(由分配人决定)
     *            state 0->1
     *            assginTime 系统当前时间
     *            devResult 0-->1
     *         原始记录  已分配  修改后 为未分配
     *            state  1-->0
     *            assignTime  待定  null
     *            devResult 1-->0
     * 3.执行更新 判断结果
     * @param saleChance
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSaleChance(SaleChance saleChance) {
        // 根据id查询用户信息
        SaleChance temp = saleChanceMapper.selectByPrimaryKey(saleChance.getId());
        AssertUtil.isTrue(temp == null, "待更新记录不存在");
        // 校验修改的其他三个参数
        checkParams(saleChance.getCustomerName(), saleChance.getLinkMan(), saleChance.getLinkPhone());
        // 修改更新时间
        saleChance.setUpdateDate(new Date());

        // 2. 设置相关参数值
        if (StringUtils.isBlank(temp.getAssignMan()) && StringUtils.isNotBlank(saleChance.getAssignMan())) {
            // 如果原始记录未分配，修改后改为已分配
            saleChance.setState(StateStatus.STATED.getType());
            saleChance.setAssignTime(new Date());
            saleChance.setDevResult(DevResult.DEVING.getStatus());

        } else if (StringUtils.isNotBlank(temp.getAssignMan()) && StringUtils.isBlank(saleChance.getAssignMan())) {
            // 如果原始记录已分配，修改后改为未分配
            saleChance.setAssignMan("");
            saleChance.setState(StateStatus.UNSTATE.getType());
            saleChance.setAssignTime(null);
            saleChance.setDevResult(DevResult.UNDEV.getStatus());
        }
        // 执行更新的操作
        AssertUtil.isTrue(saleChanceMapper.updateByPrimaryKeySelective(saleChance) < 1, "营销机会数据更新失败");
    }
}
