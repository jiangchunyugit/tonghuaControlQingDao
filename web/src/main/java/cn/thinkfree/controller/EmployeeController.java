package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.service.platform.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xusonghui
 * 员工管理
 */
@Api(value = "员工管理API接口", tags = "员工管理API接口")
@Controller
@RequestMapping("employee")
public class EmployeeController extends AbsBaseController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("员工实名认证审核")
    @MyRespBody
    @RequestMapping(value = "review", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle reviewDesigner(
            @ApiParam(name = "userId", required = false, value = "员工ID") @RequestParam(name = "userId", required = false) String userId,
            @ApiParam(name = "authState", required = false, value = "审核状态") @RequestParam(name = "authState", required = false) int authState) {
        employeeService.reviewEmployee(userId, authState);
        return sendJsonData(ResultMessage.SUCCESS, null);
    }

    @ApiOperation("员工申请")
    @MyRespBody
    @RequestMapping(value = "apply", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle apply(
            @ApiParam(name = "userId", required = false, value = "员工ID") @RequestParam(name = "userId", required = false) String userId,
            @ApiParam(name = "employeeApplyState", required = false, value = "员工申请状态") @RequestParam(name = "employeeApplyState", required = false) int employeeApplyState) {
        employeeService.employeeApply(userId, employeeApplyState);
        return sendJsonData(ResultMessage.SUCCESS, null);
    }

    @ApiOperation("处理员工申请")
    @MyRespBody
    @RequestMapping(value = "dealApply", method = {RequestMethod.POST, RequestMethod.GET})
    public MyRespBundle dealApply(
            @ApiParam(name = "userId", required = false, value = "员工ID") @RequestParam(name = "userId", required = false) String userId,
            @ApiParam(name = "employeeApplyState", required = false, value = "员工申请状态") @RequestParam(name = "employeeApplyState", required = false) int employeeApplyState,
            @ApiParam(name = "dealExplain", required = false, value = "处理结果") @RequestParam(name = "dealExplain", required = false) String dealExplain,
            @ApiParam(name = "dealUserId", required = false, value = "处理人ID") @RequestParam(name = "dealUserId", required = false) String dealUserId) {
        employeeService.dealApply(userId, employeeApplyState, dealExplain, dealUserId);
        return sendJsonData(ResultMessage.SUCCESS, null);
    }

}
