package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.vo.AfCheckResultVO;
import cn.thinkfree.database.vo.AfInstanceDetailVO;
import cn.thinkfree.database.vo.AfInstanceListVO;
import cn.thinkfree.service.approvalflow.AfInstanceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 审批流实例控制层
 *
 * @author song
 * @version 1.0
 * @date 2018/10/25 18:22
 */
@RestController
@Api(description = "app-审批流实例")
@RequestMapping("af-instance")
public class AfInstanceController extends AbsBaseController {


    @Autowired
    private AfInstanceService instanceService;


    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="app-访问审批开始页面-宋传让")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true),
            @ApiImplicitParam(name = "configNo", value = "审批流配置编号", required = true),
            @ApiImplicitParam(name = "projectNo", value = "项目编号", required = true),
            @ApiImplicitParam(name = "scheduleSort", value = "排期编号")
    })
    public MyRespBundle<AfInstanceDetailVO> start(@RequestParam(name = "userId") String userId,
                                                  @RequestParam(name = "configNo") String configNo,
                                                  @RequestParam(name = "projectNo") String projectNo,
                                                  @RequestParam(name = "scheduleSort", required = false) Integer scheduleSort){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.start(projectNo, userId, configNo, scheduleSort));
    }

    @RequestMapping(value = "/submitStart", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="app-发起审批-宋传让")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectNo", value = "项目编号", required = true),
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true),
            @ApiImplicitParam(name = "configNo", value = "审批流配置编号", required = true),
            @ApiImplicitParam(name = "scheduleSort", value = "排期编号"),
            @ApiImplicitParam(name = "data", value = "数据（json格式）"),
            @ApiImplicitParam(name = "remark", value = "备注")
    })
    public MyRespBundle submitStart(@RequestParam(name = "projectNo") String projectNo,
                                    @RequestParam(name = "userId") String userId,
                                    @RequestParam(name = "configNo") String configNo,
                                    @RequestParam(name = "scheduleSort", required = false) Integer scheduleSort,
                                    @RequestParam(name = "data", required = false) String data,
                                    @RequestParam(name = "remark", required = false) String remark){
        instanceService.submitStart(projectNo, userId, configNo, scheduleSort, data, remark);
        return sendSuccessMessage(ResultMessage.SUCCESS.message);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="app-审批流实例详情-宋传让")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "instanceNo", value = "审批流实例编码", required = true),
            @ApiImplicitParam(name = "userId", value = "用户编码", required = true)
    })
    public MyRespBundle<AfInstanceDetailVO> detail(@RequestParam(name = "instanceNo") String instanceNo, @RequestParam(name = "userId") String userId){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.detail(instanceNo, userId));
    }

    @RequestMapping(value = "/approval", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="app-执行审批-宋传让")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "instanceNo", value = "审批流实例编码", required = true),
            @ApiImplicitParam(name = "userId", value = "用户编码", required = true),
            @ApiImplicitParam(name = "option", value = "用户选择，1；同意，0：拒绝", required = true),
            @ApiImplicitParam(name = "remark", value = "备注")
    })
    public MyRespBundle<Integer> approval(@RequestParam(name = "instanceNo") String instanceNo,
                                 @RequestParam(name = "userId") String userId,
                                 @RequestParam(name = "option") Integer option,
                                 @RequestParam(name = "remark", required = false) String remark){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.approval(instanceNo, userId, option, remark));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="app-审批实例列表-宋传让")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编码", required = true),
            @ApiImplicitParam(name = "projectNo", value = "项目编码", required = true),
            @ApiImplicitParam(name = "approvalType", value = "审批类型", required = true),
            @ApiImplicitParam(name = "scheduleSort", value = "排期编码")
    })
    public MyRespBundle<AfInstanceListVO> list(@RequestParam(name = "userId") String userId,
                                               @RequestParam(name = "projectNo") String projectNo,
                                               @RequestParam(name = "approvalType") String approvalType,
                                               @RequestParam(name = "scheduleSort", required = false) Integer scheduleSort){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.list(userId, projectNo, approvalType, scheduleSort));
    }

    @RequestMapping(value = "/projectApprovalList", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="前端-审批实例列表-宋传让")
    @ApiParam(name = "projectNo", value = "项目编号", required = true)
    public MyRespBundle<List<String>> projectApprovalList(@RequestParam(name = "projectNo") String projectNo){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.projectApprovalList(projectNo));
    }

    @RequestMapping(value = "/checkList", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="前端-审批实例列表-宋传让")
    @ApiParam(name = "projectNo", value = "项目编号", required = true)
    public MyRespBundle<List<AfCheckResultVO>> checkList(@RequestParam(name = "projectNo") String projectNo){
        return sendJsonData(ResultMessage.SUCCESS, instanceService.checkList(projectNo));
    }
}
