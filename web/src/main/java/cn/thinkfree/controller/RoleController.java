package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.service.approvalFlow.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/role")
@Api(value = "角色",description = "角色")
public class RoleController extends AbsBaseController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="查询所有角色信息")
    public MyRespBundle findAll(){
        return sendJsonData(ResultMessage.SUCCESS, roleService.findAll());
    }
}
