package cn.thinkfree.controller;


import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.base.RespData;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ConstructionStateEnum;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.service.construction.ConstructionAndPayStateService;
import cn.thinkfree.service.construction.ConstructionStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 *  施工状态相关接口
 */
@Api(value = "施工订单状态接口API", tags = "施工订单状态接口API---->刘博/佳明/传让/江宁哥/../..")
@Controller
@RequestMapping("constructionState")
public class ConstructionStateController extends AbsBaseController {

    @Autowired
    ConstructionStateService constructionStateService;
    @Autowired
    ConstructionAndPayStateService constructionAndPayStateService;

    @ApiOperation("获取所有订单状态==江宁哥")
    @MyRespBody
    @RequestMapping(value = "getAllState", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<List<Map<String, Object>>> getAllState(@RequestParam @ApiParam(value = "1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态",required = true) int type) {
        List<Map<String, Object>> list = ConstructionStateEnum.allStates(type);
        return  RespData.success(list,"操作成功!");
    }


    @ApiOperation("根据不同角色-查询施工订单当前状态")
    @MyRespBody
    @RequestMapping(value = "getState", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> getState(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                         @RequestParam @ApiParam(value = "1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态",required = true) int type) {

        return constructionStateService.getStateInfo(orderNo,type);
    }

    @ApiOperation("查询当前详细阶段状态(支付/施工)")
    @MyRespBody
    @RequestMapping(value = "getStateDetail", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<Map<String,String>> getStateDetail(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                         @RequestParam @ApiParam(value = "1获取平台状态，2获取装饰公司状态，3获取施工人员状态，4获取消费者状态",required = true) int type) {

        return constructionStateService.getStateDetailInfo(orderNo,type);
    }


    @ApiOperation("运营平台-派单给装饰公司")
    @MyRespBody
    @RequestMapping(value = "upOperateDispatch", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> operateDispatchToConstruction(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {

        return constructionStateService.operateDispatchToConstruction(orderNo);
    }

    @ApiOperation("装饰公司-派单给服务人员")
    @MyRespBody
    @RequestMapping(value = "constructionForEmployee", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionStateForEmployee(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {
        try{
            constructionStateService.constructionState(orderNo,1);
        }catch (Exception e){
            e.printStackTrace();
            return sendFailMessage(e.getMessage());
        }
        return sendSuccessMessage(null);
    }

    @ApiOperation("装饰公司-施工报价完成")
    @MyRespBody
    @RequestMapping(value = "constructionPriceComplete", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionPriceComplete(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {
        try{
            constructionStateService.constructionState(orderNo,2);
        }catch (Exception e){
            e.printStackTrace();
            return sendFailMessage(e.getMessage());
        }
        return sendSuccessMessage(null);
    }

    @ApiOperation("装饰公司-审核完成(是否通过)")
    @MyRespBody
    @RequestMapping(value = "constructionExamineComplete", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionExamineComplete(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                                            @RequestParam @ApiParam(value = "审核是否通过",required = true) Integer isPass) {

        return constructionStateService.constructionStateOfExamine(orderNo,3,isPass);
    }

    @ApiOperation("装饰公司-合同录入")
    @MyRespBody
    @RequestMapping(value = "constructionContractEntry", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionContractEntry(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {
        try{
            constructionStateService.constructionState(orderNo,4);
        }catch (Exception e){
            e.printStackTrace();
            return sendFailMessage(e.getMessage());
        }
        return sendSuccessMessage(null);
    }

    @ApiOperation("装饰公司-确认线下签约完成（自动创建工地项目）")
    @MyRespBody
    @RequestMapping(value = "constructionSignComplete", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionSignComplete(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {
        try{
            constructionStateService.constructionState(orderNo,5);
        }catch (Exception e){
            e.printStackTrace();
            return sendFailMessage(e.getMessage());
        }
        return sendSuccessMessage(null);
    }

    /**
     *  订单支付
     */
    @ApiOperation("消费者-订单支付===刘博")
    @MyRespBody
    @RequestMapping(value = "firstPay", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<Boolean> firstPay(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo) {

        return constructionStateService.firstPay(orderNo);
    }

    /**
     *  订单支付接口
     */
    @ApiOperation("消费者-订单支付===刘博")
    @MyRespBody
    @RequestMapping(value = "constructionOrderPay", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionOrderPay(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                                     @RequestParam @ApiParam(value = "支付阶段名称",required = true) String feeName,
                                                     @RequestParam @ApiParam(value = "阶段排序（-1为首款）",required = true) Integer sort,
                                                     @RequestParam @ApiParam(value = "尾款",required = true) String isComplete) {

        return constructionStateService.customerPay(orderNo,feeName,sort,isComplete);
    }

    /**
     *  订单是否可以支付-查询接口
     */
    @ApiOperation("消费者-订单支付===刘博")
    @MyRespBody
    @RequestMapping(value = "isOrderPay", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> isOrderPay(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                                     @RequestParam @ApiParam(value = "阶段排序",required = true) Integer sort) {

        return constructionAndPayStateService.isStagePay(orderNo,sort);
    }


    /**
     *  开工报告/阶段竣工验收 接口
     */
    @ApiOperation("施工人员-开工报告/施工阶段==传让")
    @MyRespBody
    @RequestMapping(value = "constructionPlan", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> constructionPlan(@RequestParam @ApiParam(value = "项目编号",required = true) String projectNo,
                                                 @RequestParam @ApiParam(value = "序号 0为开工报告",required = true) Integer sort) {

        return constructionStateService.constructionPlan(projectNo,sort);

    }

    /**
     *  是否可以 开工报告/阶段竣工验收 查询接口
     */
    @ApiOperation("开工报告/施工阶段 查询 ==传让")
    @MyRespBody
    @RequestMapping(value = "isConstructionPlan", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<Boolean> isConstructionPlan(@RequestParam @ApiParam(value = "项目编号",required = true) String projectNo,
                                                    @RequestParam @ApiParam(value = "阶段排序",required = true) Integer sort) {

        if (constructionAndPayStateService.isBeComplete(projectNo,sort)){
            return RespData.success(true);
        }else {
            return RespData.error(ResultMessage.ERROR.code, "false");
        }
    }


    /**
     *  消费者签约阶段取消接口
     */
    @ApiOperation("消费者-取消订单(签约阶段逆向)")
    @MyRespBody
    @RequestMapping(value = "customerCancelOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> customerCancelOrder(@RequestParam @ApiParam(value = "用户编号",required = true) String userId,
                                                    @RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                                    @RequestParam(required = false) @ApiParam(value = "理由")  String cancelReason) {

        constructionStateService.customerCancelOrder(userId, orderNo,cancelReason);
        return sendSuccessMessage(ResultMessage.SUCCESS.message);
    }

    /**
     *  消费者 支付后 取消接口
     * @param orderNo
     * @param type
     * @return
     */
    @ApiOperation("消费者-取消订单(支付未开工逆向)&审核是否通过")
    @MyRespBody
    @RequestMapping(value = "customerCancelOrderForPay", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle<String> customerCancelOrderForPay(@RequestParam @ApiParam(value = "订单编号",required = true) String orderNo,
                                                          @RequestParam @ApiParam(value = "1消费者取消,2审核是否通过",required = true) int type) {

        return constructionStateService.customerCancelOrderForPay(orderNo,type);
    }


}
