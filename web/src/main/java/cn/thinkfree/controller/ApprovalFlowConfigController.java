package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.model.ApprovalFlow;
import cn.thinkfree.service.approvalFlow.ApprovalFlowConfigLogService;
import cn.thinkfree.service.approvalFlow.ApprovalFlowConfigService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/approvalFlowConfig")
@Api(value = "审批流",description = "审批流")
public class ApprovalFlowConfigController extends AbsBaseController{

    @Autowired
    private ApprovalFlowConfigService configService;
    @Autowired
    private ApprovalFlowConfigLogService configLogService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="查询所有审批流")
    public MyRespBundle list(){
        return sendJsonData(ResultMessage.SUCCESS, configService.list());
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="审批流节点信息")
    @ApiParam(name = "approvalFlowNum" ,value = "审批流编号", required = true)
    public MyRespBundle detail(@RequestParam(name = "approvalFlowNum",required = false) String approvalFlowNum){
        return sendJsonData(ResultMessage.SUCCESS, configLogService.detail(approvalFlowNum));
    }
}

