package cn.thinkfree.service.construction.impl;


import cn.thinkfree.core.base.RespData;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ConstructionStateEnumB;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.mapper.ConstructionOrderMapper;
import cn.thinkfree.database.mapper.ConstructionOrderPayMapper;
import cn.thinkfree.database.mapper.ProjectBigSchedulingMapper;
import cn.thinkfree.database.mapper.ProjectMapper;
import cn.thinkfree.database.model.*;
import cn.thinkfree.service.construction.CommonService;
import cn.thinkfree.service.construction.ConstructionAndPayStateService;
import cn.thinkfree.service.construction.ConstructionStateServiceB;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 施工状态
 */
@Service
public class ConstructionStateServiceImplB implements ConstructionStateServiceB {

    @Autowired
    ConstructionOrderMapper constructionOrderMapper;
    @Autowired
    CommonService commonService;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ConstructionOrderPayMapper constructionOrderPayMapper;
    @Autowired
    ProjectBigSchedulingMapper projectBigSchedulingMapper;
    @Autowired
    ConstructionAndPayStateService constructionAndPayStateService;


    /**
     * 查询当前状态
     *
     * @param type ，1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态
     * @return
     */
    @Override
    public MyRespBundle<String> getStateInfo(String orderNo, int type) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }
        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        String stateInfo = ConstructionStateEnumB.queryStateByRole(stageCode, type);
        return RespData.success(stateInfo);
    }

    /**
     * 查询当前状态/付款施工详细阶段
     *
     * @param type ，1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态
     * @return
     */
    @Override
    public MyRespBundle<Map<String, String>> getStateDetailInfo(String orderNo, int type) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }
        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        String stateInfo = ConstructionStateEnumB.queryStateByRole(stageCode, type);
        String stateDetailInfo = commonService.queryStateCodeDetailByOrderNo(orderNo);
        Map<String, String> map = new HashMap<>();
        map.put("bigStage", stateInfo);
        map.put("detailStage", stateDetailInfo);
        return RespData.success(map);
    }

    /**
     * 运营平台
     * 派单给装饰公司
     */
    @Override
    public MyRespBundle<String> operateDispatchToConstruction(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }
        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        List<ConstructionStateEnumB> nextStateCode = ConstructionStateEnumB.STATE_500.getNextStates();
        if (stageCode.equals(ConstructionStateEnumB.STATE_500.getState())) {
            if (commonService.updateStateCodeByOrderNo(orderNo, nextStateCode.get(0).getState())) {
                return RespData.success();
            }
        }
        return RespData.error(ResultMessage.ERROR.code, "该订单不符合派单状态");
    }


    /**
     * 装饰公司
     * 1派单给服务人员 2施工报价完成  5确认线下签约完成（自动创建工地项目）
     */
    @Override
    public MyRespBundle<String> constructionState(String orderNo, int type) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }
        Integer stage = null;
        List<ConstructionStateEnumB> nextStateCode = new ArrayList<>();
        switch (type) {
            case 1:
                stage = ConstructionStateEnumB.STATE_510.getState();
                nextStateCode = ConstructionStateEnumB.STATE_510.getNextStates();
                break;
            case 2:
                stage = ConstructionStateEnumB.STATE_520.getState();
                nextStateCode = ConstructionStateEnumB.STATE_520.getNextStates();
                break;
            case 5:
                stage = ConstructionStateEnumB.STATE_550.getState();
                nextStateCode = ConstructionStateEnumB.STATE_550.getNextStates();
                break;
            default:
                break;
        }
        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        if (stageCode.equals(stage)) {
            if (commonService.updateStateCodeByOrderNo(orderNo, nextStateCode.get(0).getState())) {
                return RespData.success();
            }
        }
        return RespData.error(ResultMessage.ERROR.code, "操作失败-请稍后重试");
    }

    /**
     * 装饰公司
     * 3审核完成 （审核是否通过）
     */
    @Override
    public MyRespBundle<String> constructionStateOfExamine(String orderNo, int type, int isPass) {

        if (StringUtils.isBlank(String.valueOf(isPass))) {
            return RespData.error(ResultMessage.ERROR.code, "审核是否通过状态未知");
        }


        Integer stage = ConstructionStateEnumB.STATE_530.getState();
        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);

        List<ConstructionStateEnumB> nextStateCode = ConstructionStateEnumB.STATE_530.getNextStates();

        if (stageCode.equals(stage)) {
            if (isPass == 1) {   //下一步
                if (commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_540.getState())) {
                    return RespData.success();
                }
            } else {  //上一步
                if (commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_520.getState())) {
                    return RespData.success();
                }
            }
        } else {
            return RespData.error(ResultMessage.ERROR.code, "该订单不符合审核状态");
        }

        return RespData.error(ResultMessage.ERROR.code, "状态更新失败状态-请稍后重试");
    }

    /**
     * 装饰公司
     * 4合同录入 （完成）
     * TODO 不用了
     */
    @Override
    public void contractState(String orderNo) {
        commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_540.getState());
    }

    /**
     * 装饰公司
     * 5确认线下签约完成（自动创建工地项目）
     */
    @Override
    public void contractCompleteState(String orderNo) {
        commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_550.getState());
    }


    /**
     * 支付
     */
    @Override
    public MyRespBundle<String> customerPay(String orderNo, String feeName, Integer sort,String isComplete) {

        MyRespBundle<String> boo = constructionAndPayStateService.isStagePay(orderNo, sort);
        if (!boo.getCode().equals(1000)) {
            return RespData.error(ResultMessage.ERROR.code, "该状态不能进行支付");
        }

        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }

        ConstructionOrderPayExample example = new ConstructionOrderPayExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<ConstructionOrderPay> list = constructionOrderPayMapper.selectByExample(example);
        if (list.size() > 0) {
            ConstructionOrderPay constructionOrderPay = new ConstructionOrderPay();
            constructionOrderPay.setFeeName(feeName);
            constructionOrderPay.setSort(sort.shortValue());
            constructionOrderPay.setIsEnd("pay");
            constructionOrderPayMapper.updateByExampleSelective(constructionOrderPay, example);
        } else {
            ConstructionOrderPay constructionOrderPay = new ConstructionOrderPay();
            constructionOrderPay.setOrderNo(orderNo);
            constructionOrderPay.setFeeName(feeName);
            constructionOrderPay.setSort(sort.shortValue());
            constructionOrderPay.setIsEnd("pay");
            constructionOrderPayMapper.insertSelective(constructionOrderPay);
        }
        // sort=0 支付首款
        if (sort == 0) {
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_600.getState());
        } else {
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_630.getState());
        }

        if ("2".equals(isComplete)){
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_700.getState());
        }

        return RespData.success();
    }


    /**
     * 施工阶段方案
     */
    @Override
    public MyRespBundle<String> constructionPlan(String projectNo, Integer sort) {

        if (!constructionAndPayStateService.isBeComplete(projectNo, sort)) {
            throw new RuntimeException("施工阶段状态变更异常");
        }

        if (StringUtils.isBlank(projectNo)) {
            throw new RuntimeException("施工阶段状态变更异常");
        }

        ConstructionOrderPay constructionOrderPay = new ConstructionOrderPay();

        //查询订单编号
        ConstructionOrderExample example = new ConstructionOrderExample();
        example.createCriteria().andProjectNoEqualTo(projectNo);
        List<ConstructionOrder> list = constructionOrderMapper.selectByExample(example);
        if (list.isEmpty()) {
            throw new RuntimeException("施工阶段状态变更异常");
        }
        String orderNo = list.get(0).getOrderNo();
        String schedulingNo = list.get(0).getSchemeNo();

        //更新状态
        ConstructionOrderPayExample examplePay = new ConstructionOrderPayExample();
        examplePay.createCriteria().andOrderNoEqualTo(orderNo);
        List<ConstructionOrderPay> listPay = constructionOrderPayMapper.selectByExample(examplePay);
        if (listPay.isEmpty()) {
            constructionOrderPay.setOrderNo(orderNo);
            constructionOrderPay.setFeeName("开工报告");
            constructionOrderPay.setSort(sort.shortValue());
            constructionOrderPay.setIsEnd("construction");
            constructionOrderPayMapper.insertSelective(constructionOrderPay);
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_610.getState());
        } else {
            if (sort == 0) {
                constructionOrderPay.setFeeName("开工报告");
                constructionOrderPay.setSort(sort.shortValue());
                constructionOrderPay.setIsEnd("construction");
                commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_610.getState());
            } else {
                //查询当前施工阶段名称
                ProjectBigSchedulingExample example2 = new ProjectBigSchedulingExample();
                example2.createCriteria().andSchemeNoEqualTo(schedulingNo).andSortEqualTo(sort);
                List<ProjectBigScheduling> schedulingList2 = projectBigSchedulingMapper.selectByExample(example2);
                if (schedulingList2.isEmpty()) {
                    throw new RuntimeException("施工阶段状态变更异常");
                }
                String schedulingName = schedulingList2.get(0).getName();

                constructionOrderPay.setFeeName(schedulingName);
                constructionOrderPay.setSort(sort.shortValue());
                constructionOrderPay.setIsEnd("construction");
                commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_620.getState());
                //支付阶段通知
                constructionAndPayStateService.notifyPay(orderNo,sort);
            }
            constructionOrderPayMapper.updateByExampleSelective(constructionOrderPay, examplePay);
        }

        return RespData.success();
    }


    /**
     * 消费者
     * 取消订单
     * 签约阶段逆向
     */
    @Override
    public MyRespBundle<String> customerCancelOrder(String userId, String orderNo, String cancelReason) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }

        if (StringUtils.isBlank(userId)) {
            return RespData.error(ResultMessage.ERROR.code, "用户ID不能为空");
        }

        ProjectExample example = new ProjectExample();
        example.createCriteria().andOwnerIdEqualTo(userId).andStatusEqualTo(1);
        List<Project> list = projectMapper.selectByExample(example);
        if (list.size() <= 0) {
            return RespData.error(ResultMessage.ERROR.code, "用户不存在");
        }

        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        if (ConstructionStateEnumB.STATE_600.getState() <= stageCode) {
            return RespData.error(ResultMessage.ERROR.code, "当前状态不能取消订单");
        }

        ConstructionOrderExample example2 = new ConstructionOrderExample();
        example2.createCriteria().andOrderNoEqualTo(orderNo);
        ConstructionOrder constructionOrder = new ConstructionOrder();
        constructionOrder.setOrderStage(ConstructionStateEnumB.STATE_710.getState());
        constructionOrder.setRemark(cancelReason);
        int isUpdate = constructionOrderMapper.updateByExampleSelective(constructionOrder, example2);
        if (isUpdate == 1) {
            return RespData.success();
        } else {
            return RespData.error(ResultMessage.ERROR.code, "取消订单失败-请稍后重试");
        }
    }

    /**
     * 消费者
     * 取消订单
     * 签约阶段逆向
     * 查看状态
     */
    @Override
    public Boolean customerCancelOrderState(String userId, String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return false;
        }

        if (StringUtils.isBlank(userId)) {
            return false;
        }

        ProjectExample example = new ProjectExample();
        example.createCriteria().andOwnerIdEqualTo(userId).andStatusEqualTo(1);
        List<Project> list = projectMapper.selectByExample(example);
        if (list.size() <= 0) {
            return false;
        }

        Integer stageCode = commonService.queryStateCodeByOrderNo(orderNo);
        if (ConstructionStateEnumB.STATE_600.getState() <= stageCode) {
            return false;
        }
        return true;
    }

    /**
     * 消费者
     * 取消订单
     * 支付未开工逆向
     * &审核通过
     */
    @Override
    public MyRespBundle<String> customerCancelOrderForPay(String orderNo, int type) {
        if (StringUtils.isBlank(orderNo)) {
            return RespData.error(ResultMessage.ERROR.code, "订单编号不能为空");
        }

        if (type == 1) {
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_720.getState());
        } else {
            commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_730.getState());
        }

        return RespData.success();
    }


    /**
     * 订单完成
     * @param orderNo
     */
    public void constructionComplete(String orderNo){

        commonService.updateStateCodeByOrderNo(orderNo, ConstructionStateEnumB.STATE_700.getState());
    }


}
