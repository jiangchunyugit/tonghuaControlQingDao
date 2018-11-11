package cn.thinkfree.service.construction.impl;

import cn.thinkfree.core.base.RespData;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ConstructionStateEnum;
import cn.thinkfree.core.constants.Role;
import cn.thinkfree.core.utils.JSONUtil;
import cn.thinkfree.database.appvo.PersionVo;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.AfUserDTO;
import cn.thinkfree.database.vo.EmployeeInfoVO;
import cn.thinkfree.service.approvalflow.AfInstanceService;
import cn.thinkfree.service.config.HttpLinks;
import cn.thinkfree.service.construction.CommonService;
import cn.thinkfree.service.construction.ConstructionOrderOperate;
import cn.thinkfree.service.construction.OrderListService;
import cn.thinkfree.service.construction.vo.ConstructionOrderListVo;
import cn.thinkfree.service.construction.vo.ConstructionOrderManageVo;
import cn.thinkfree.service.construction.vo.SiteDetailsVo;
import cn.thinkfree.service.neworder.NewOrderUserService;
import cn.thinkfree.service.utils.AfUtils;
import cn.thinkfree.service.utils.DateUtil;
import cn.thinkfree.service.utils.HttpUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ConstructionOrderOperateImpl implements ConstructionOrderOperate {

    @Autowired
    ConstructionOrderMapper constructionOrderMapper;

    @Autowired
    CommonService commonService;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    NewOrderUserService newOrderUserService;

    @Autowired
    EmployeeMsgMapper employeeMsgMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Autowired
    ProjectBigSchedulingMapper projectBigSchedulingMapper;

    @Autowired
    ProjectSchedulingMapper projectSchedulingMapper;

    @Autowired
    OrderUserMapper orderUserMapper;

    @Autowired
    AfInstanceService afInstanceService;

    @Autowired
    FundsOrderMapper fundsOrderMapper;

    @Autowired
    DesignerOrderMapper designerOrderMapper;

    @Resource
    private HttpLinks httpLinks;

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";


    @Autowired
    OrderListService orderListService;


    /**
     * 施工订单管理-列表
     * 运营后台
     *
     * @return
     */
    @Override
    public MyRespBundle<ConstructionOrderManageVo> getConstructionOrderList(int pageNum, int pageSize, String cityName) {

        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ConstructionOrderListVo> pageInfo = new PageInfo<>();
        ConstructionOrderExample example = new ConstructionOrderExample();
        example.setOrderByClause("create_time DESC");
        example.createCriteria().andStatusEqualTo(1);

        List<ConstructionOrder> list = constructionOrderMapper.selectByExample(example);
        List<ConstructionOrderListVo> listVo = new ArrayList<>();

        /* 统计状态个数 */
        int waitExamine = 0, waitSign = 0, waitPay = 0;

        /* 项目编号List */
        List<String> listProjectNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listProjectNo.add(constructionOrder.getProjectNo());
        }

        /* 订单编号List */
        List<String> listOrdertNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listOrdertNo.add(constructionOrder.getOrderNo());
        }

        /* 公司编号List */
        List<String> listCompanyNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listCompanyNo.add(constructionOrder.getCompanyId());
        }

        // 所属地区 & 项目地址 & 预约日期
        List<Project> list1 = orderListService.getProjectInfo(listProjectNo);
        // 项目经理
        List<Map<String, String>> list2 = orderListService.getEmployeeInfo(listProjectNo, "CP");
        // 设计师
        List<Map<String, String>> list3 = orderListService.getEmployeeInfo(listProjectNo, "CD");
        // 延期天数
        List<ProjectScheduling> list4 = orderListService.getdelayDay(listProjectNo);
        // 确认验收
        Map<String, Integer> Map5 = orderListService.getApprove(listProjectNo);
        // 合同金额/时间
        List<FundsOrder> list6 = orderListService.getFundsOrder(listProjectNo);

        continueOut:
        for (ConstructionOrder constructionOrder : list) {
            ConstructionOrderListVo constructionOrderListVo = new ConstructionOrderListVo();

            // 所属地区 & 项目地址 & 预约日期
            for (Project project : list1) {
                if (constructionOrder.getProjectNo().equals(project.getProjectNo())) {
                    // 条件筛选 - 城市
                    if (!StringUtils.isBlank(cityName)) {
                        if (!cityName.equals(project.getCity())) {
                            continue continueOut;
                        }
                    }
                    constructionOrderListVo.setAddress(project.getCity());
                    constructionOrderListVo.setAddressDetail(project.getAddressDetail());
                    constructionOrderListVo.setAppointmentTime(project.getCreateTime());
                }
                // 业主 & 手机号  TODO 没做批量查询
//                PersionVo owner = getOwnerId(project.getOwnerId());
//                constructionOrderListVo.setOwner(owner.getName());
//                constructionOrderListVo.setPhone(owner.getPhone());
            }

            // 订单编号 & 项目编号
            constructionOrderListVo.setOrderNo(constructionOrder.getOrderNo());
            constructionOrderListVo.setProjectNo(constructionOrder.getProjectNo());
            // 项目经理
            for (Map<String, String> OrderUser : list2) {
                if (constructionOrder.getProjectNo().equals(OrderUser.get("projectNo"))) {
                    constructionOrderListVo.setProjectManager(OrderUser.get("name"));
                }
            }
            // 设计师
            for (Map<String, String> OrderUser : list3) {
                if (constructionOrder.getProjectNo().equals(OrderUser.get("projectNo"))) {
                    constructionOrderListVo.setProjectManager(OrderUser.get("name"));
                }
            }
            // 公司名称
            constructionOrderListVo.setCompanyName(orderListService.getCompanyInfo(constructionOrder.getCompanyId()));

            // 施工阶段
            constructionOrderListVo.setConstructionProgress(orderListService.getContstructionStage(constructionOrder.getConstructionStage()));

            // 订单状态
            constructionOrderListVo.setOrderStage(ConstructionStateEnum.getNowStateInfo(constructionOrder.getOrderStage(), 1));

            //延期天数
            for (ProjectScheduling projectScheduling : list4) {
                if (constructionOrder.getProjectNo().equals(projectScheduling.getProjectNo())) {
                    constructionOrderListVo.setDelayDays(projectScheduling.getDelay());
                }
            }
            // 签约日期 已支付 应支付金额
            for (FundsOrder fundsOrder : list6) {
                if (constructionOrder.getProjectNo().equals(fundsOrder.getProjectNo())) {
                    constructionOrderListVo.setSignedTime(DateUtil.formateToDate(fundsOrder.getSignedTime(), FORMAT));
                    constructionOrderListVo.setReducedContractAmount(fundsOrder.getActualAmount());
                    constructionOrderListVo.setHavePaid(fundsOrder.getPaidAmount());
                }
            }

            // 最近验收情况14
            for (Map.Entry<String, Integer> map : Map5.entrySet()) {
                if (constructionOrder.getProjectNo().equals(map.getKey())) {
                    switch (map.getKey()) {
                        case "1":
                            constructionOrderListVo.setCheckCondition("通过");
                        case "2":
                            constructionOrderListVo.setCheckCondition("未通过");
                        default:
                            constructionOrderListVo.setCheckCondition("--");
                    }
                }
            }

            // 订单状态 统计
            int stage = constructionOrder.getOrderStage();
            if (stage == ConstructionStateEnum.STATE_530.getState()) {
                waitExamine++;
            }
            if (stage == ConstructionStateEnum.STATE_550.getState()) {
                waitSign++;
            }
            if ((stage >= ConstructionStateEnum.STATE_600.getState() && stage <= ConstructionStateEnum.STATE_690.getState())) {
                waitPay++;
            }

            listVo.add(constructionOrderListVo);
        }


        pageInfo.setList(listVo);
        ConstructionOrderManageVo constructionOrderManageVo = new ConstructionOrderManageVo();

        constructionOrderManageVo.setCityList(commonService.getCityList());
        constructionOrderManageVo.setOrderList(pageInfo.getList());
        constructionOrderManageVo.setCountPageNum(pageInfo.getSize());
        constructionOrderManageVo.setOrderNum(list.size());

        constructionOrderManageVo.setWaitExamine(waitExamine);
        constructionOrderManageVo.setWaitSign(waitSign);
        constructionOrderManageVo.setWaitPay(waitPay);

        return RespData.success(constructionOrderManageVo);
    }

    /**
     * 施工工地管理-列表
     * 运营后台
     *
     * @return
     */
    @Override
    public MyRespBundle<ConstructionOrderManageVo> getConstructionSiteList(int pageNum, int pageSize, String cityName) {

        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ConstructionOrderListVo> pageInfo = new PageInfo<>();
        ConstructionOrderExample example = new ConstructionOrderExample();
        example.setOrderByClause("create_time DESC");
        example.createCriteria().andStatusEqualTo(1);

        List<ConstructionOrder> list = constructionOrderMapper.selectByExample(example);
        List<ConstructionOrderListVo> listVo = new ArrayList<>();

        /* 统计状态个数 */
        int waitExamine = 0, waitSign = 0, waitPay = 0;

        /* 项目编号List */
        List<String> listProjectNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listProjectNo.add(constructionOrder.getProjectNo());
        }

        /* 订单编号List */
        List<String> listOrdertNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listOrdertNo.add(constructionOrder.getOrderNo());
        }

        /* 公司编号List */
        List<String> listCompanyNo = new ArrayList<>();
        for (ConstructionOrder constructionOrder : list) {
            listCompanyNo.add(constructionOrder.getCompanyId());
        }

        // 所属地区 & 项目地址 & 预约日期
        List<Project> list1 = orderListService.getProjectInfo(listProjectNo);
        // 项目经理
        List<Map<String, String>> list2 = orderListService.getEmployeeInfo(listProjectNo, "CP");
        // 设计师
        List<Map<String, String>> list3 = orderListService.getEmployeeInfo(listProjectNo, "CD");
        // 延期天数
        List<ProjectScheduling> list4 = orderListService.getdelayDay(listProjectNo);
        // 确认验收
        Map<String, Integer> Map5 = orderListService.getApprove(listProjectNo);
        // 合同金额/时间
        List<FundsOrder> list6 = orderListService.getFundsOrder(listProjectNo);
        List<ProjectScheduling> list7 = orderListService.getProjectScheduling(listProjectNo);
        //合同额
        List<ConstructionOrder> list8 = orderListService.getMoney(listOrdertNo);
        continueOut:
        for (ConstructionOrder constructionOrder : list) {
            ConstructionOrderListVo constructionOrderListVo = new ConstructionOrderListVo();

            // 所属地区 & 项目地址 & 预约日期
            for (Project project : list1) {
                if (constructionOrder.getProjectNo().equals(project.getProjectNo())) {
                    // 条件筛选 - 城市
                    if (!StringUtils.isBlank(cityName)) {
                        if (!cityName.equals(project.getCity())) {
                            continue continueOut;
                        }
                    }
                    constructionOrderListVo.setAddress(project.getCity());
                    constructionOrderListVo.setAddressDetail(project.getAddressDetail());
                    constructionOrderListVo.setAppointmentTime(project.getCreateTime());
                }
                // 业主 & 手机号  TODO 没做批量查询
//                PersionVo owner = getOwnerId(project.getOwnerId());
//                constructionOrderListVo.setOwner(owner.getName());
//                constructionOrderListVo.setPhone(owner.getPhone());
            }

            // 订单编号 & 项目编号
            constructionOrderListVo.setOrderNo(constructionOrder.getOrderNo());
            constructionOrderListVo.setProjectNo(constructionOrder.getProjectNo());
            // 项目经理
            for (Map<String, String> OrderUser : list2) {
                if (constructionOrder.getProjectNo().equals(OrderUser.get("projectNo"))) {
                    constructionOrderListVo.setProjectManager(OrderUser.get("name"));
                }
            }
            // 设计师
            for (Map<String, String> OrderUser : list3) {
                if (constructionOrder.getProjectNo().equals(OrderUser.get("projectNo"))) {
                    constructionOrderListVo.setProjectManager(OrderUser.get("name"));
                }
            }
            // 公司名称
            constructionOrderListVo.setCompanyName(orderListService.getCompanyInfo(constructionOrder.getCompanyId()));

            // 施工阶段
            constructionOrderListVo.setConstructionProgress(orderListService.getContstructionStage(constructionOrder.getConstructionStage()));

            // 订单状态
            constructionOrderListVo.setOrderStage(ConstructionStateEnum.getNowStateInfo(constructionOrder.getOrderStage(), 1));

            //延期天数
            for (ProjectScheduling projectScheduling : list4) {
                if (constructionOrder.getProjectNo().equals(projectScheduling.getProjectNo())) {
                    constructionOrderListVo.setDelayDays(projectScheduling.getDelay());
                    constructionOrderListVo.setStartDates(projectScheduling.getStartTime());
                    constructionOrderListVo.setCompletionDays(projectScheduling.getEndTime());
                }
            }
            // 签约日期 已支付 应支付金额
            for (FundsOrder fundsOrder : list6) {
                if (constructionOrder.getProjectNo().equals(fundsOrder.getProjectNo())) {
                    constructionOrderListVo.setSignedTime(DateUtil.formateToDate(fundsOrder.getSignedTime(), FORMAT));
                    constructionOrderListVo.setReducedContractAmount(fundsOrder.getActualAmount());
                    constructionOrderListVo.setHavePaid(fundsOrder.getPaidAmount());
                }
            }
            //合同金额
            for (ConstructionOrder co : list8) {
                constructionOrderListVo.setContractAmount(co.getMoney().toString());
            }


            // 最近验收情况14
            for (Map.Entry<String, Integer> map : Map5.entrySet()) {
                if (constructionOrder.getProjectNo().equals(map.getKey())) {
                    switch (map.getKey()) {
                        case "1":
                            constructionOrderListVo.setCheckCondition("通过");
                        case "2":
                            constructionOrderListVo.setCheckCondition("未通过");
                        default:
                            constructionOrderListVo.setCheckCondition("--");
                    }
                }
            }

            // 订单状态 统计
            int stage = constructionOrder.getOrderStage();
            if (stage == ConstructionStateEnum.STATE_530.getState()) {
                waitExamine++;
            }
            if (stage == ConstructionStateEnum.STATE_550.getState()) {
                waitSign++;
            }
            if ((stage >= ConstructionStateEnum.STATE_600.getState() && stage <= ConstructionStateEnum.STATE_690.getState())) {
                waitPay++;
            }

            listVo.add(constructionOrderListVo);
        }


        pageInfo.setList(listVo);
        ConstructionOrderManageVo constructionOrderManageVo = new ConstructionOrderManageVo();

        constructionOrderManageVo.setCityList(commonService.getCityList());
        constructionOrderManageVo.setOrderList(pageInfo.getList());
        constructionOrderManageVo.setCountPageNum(pageInfo.getSize());
        constructionOrderManageVo.setOrderNum(list.size());

        constructionOrderManageVo.setWaitExamine(waitExamine);
        constructionOrderManageVo.setWaitSign(waitSign);
        constructionOrderManageVo.setWaitPay(waitPay);

        return RespData.success(constructionOrderManageVo);
    }

    /**
     * @return
     * @Author jiang
     * @Description 工地详情信息
     * @Date
     * @Param
     **/
    @Override
    public MyRespBundle<SiteDetailsVo> getSiteDetails(String projectNo) {
        SiteDetailsVo siteDetailsVo = new SiteDetailsVo();
        ProjectSchedulingExample projectSchedulingExample = new ProjectSchedulingExample();
        projectSchedulingExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<ProjectScheduling> projectSchedulings = projectSchedulingMapper.selectByExample(projectSchedulingExample);
        if (projectSchedulings.size() == 1) {
            ProjectScheduling projectScheduling = projectSchedulings.get(0);
            //项目编号
            siteDetailsVo.setProjectNo(projectNo);
            //开工时间
            siteDetailsVo.setStartDates(projectScheduling.getStartTime());
            //竣工时间
            siteDetailsVo.setCompletionDays(projectScheduling.getEndTime());
            //工期
            Long day = (projectScheduling.getEndTime().getTime() - projectScheduling.getStartTime().getTime()) / (24 * 60 * 60 * 1000);
            siteDetailsVo.setDuration(day.intValue());
            //施工进度
            siteDetailsVo.setConstructionSchedule(projectScheduling.getRate().intValue());
            //延期天数
            siteDetailsVo.setDeferredDays(projectScheduling.getDelay());
        }
        DesignerOrderExample designerOrderExample = new DesignerOrderExample();
        designerOrderExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(designerOrderExample);
        if (designerOrders.size() == 1) {
            DesignerOrder designerOrder = designerOrders.get(0);
            //订单编号
            siteDetailsVo.setOrderNo(designerOrder.getOrderNo());
            //订单类型
            siteDetailsVo.setOrderType(designerOrder.getStyleType());
        }


        //业主
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectNoEqualTo(siteDetailsVo.getProjectNo());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        AfUserDTO customerInfo = AfUtils.getUserInfo(httpLinks.getUserCenterGetUserMsg(), projects.get(0).getOwnerId(), Role.CC.id);
        //业主
        siteDetailsVo.setOwner(customerInfo.getUsername());
        //手机号码
        siteDetailsVo.setPhone(customerInfo.getPhone());
        //项目地址
        siteDetailsVo.setProjectAddress(projects.get(0).getAddressDetail());

        //合同
        ConstructionOrderExample constructionOrderExample = new ConstructionOrderExample();
        constructionOrderExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<ConstructionOrder> constructionOrders = constructionOrderMapper.selectByExample(constructionOrderExample);
        if (constructionOrders.size() == 1) {
            ConstructionOrder constructionOrder = constructionOrders.get(0);
            //合同款
            siteDetailsVo.setContractFunds(constructionOrder.getMoney());
        }
        FundsOrderExample example = new FundsOrderExample();
        example.createCriteria().andProjectNoEqualTo(projectNo);
        List<FundsOrder> list = fundsOrderMapper.selectByExample(example);
        if (list.size() == 1) {
            FundsOrder fundsOrder = list.get(0);
            //已付款
            siteDetailsVo.setPaid(fundsOrder.getPaidAmount());
            //待付款
            siteDetailsVo.setPendingPayment(fundsOrder.getActualAmount());
        }

        //EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        OrderUserExample orderUserExample = new OrderUserExample();
        orderUserExample.createCriteria().andProjectNoEqualTo(projectNo);
        List<OrderUser> orderUsers = orderUserMapper.selectByExample(orderUserExample);
        List<EmployeeInfoVO> lists = new ArrayList<>();
        orderUsers.forEach((user) ->
                {
                    EmployeeMsgExample employeeMsgExample = new EmployeeMsgExample();
                    employeeMsgExample.createCriteria().andUserIdEqualTo(user.getUserId());
                    List<EmployeeMsg> employeeMsgs = employeeMsgMapper.selectByExample(employeeMsgExample);
                    employeeMsgs.forEach(employeeMsg -> {
                        String roleCode = employeeMsg.getRoleCode();
                        if (roleCode != null) {
                            if ("CP".equals(roleCode)) {
                                //项目经理
                                siteDetailsVo.setProjectManager(employeeMsg.getRealName());
                            } else if ("CM".equals(roleCode)) {
                                //工长
                                siteDetailsVo.setForeman(employeeMsg.getRealName());
                            } else if ("CS".equals(roleCode)) {
                                //管家
                                siteDetailsVo.setHousekeeper(employeeMsg.getRealName());
                            } else if ("CD".equals(roleCode)) {
                                //设计师
                                siteDetailsVo.setDesignerName(employeeMsg.getRealName());
                            }
                        }
                    });
                }

        );


        return RespData.success(siteDetailsVo);
    }
}