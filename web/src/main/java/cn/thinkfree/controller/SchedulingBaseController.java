package cn.thinkfree.controller;

import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.model.ProjectBigScheduling;
import cn.thinkfree.database.vo.ProjectBigSchedulingVO;
import cn.thinkfree.database.vo.ProjectSmallSchedulingVO;
import cn.thinkfree.database.vo.SchedulingSeo;
import cn.thinkfree.service.newscheduling.NewSchedulingBaseService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gejiaming
 */
@Api(tags = "PC-排期基础信息操作")
@RestController
@RequestMapping(value = "schedulingBase")
public class SchedulingBaseController extends AbsBaseController {
    @Autowired
    private NewSchedulingBaseService schedulingBaseService;

    @RequestMapping(value = "listSmallScheduling", method = RequestMethod.POST)
    @ApiOperation(value = "基础施工项同步(获取列表)-获取本地基础小排期信息")
    public MyRespBundle<PageInfo<ProjectSmallSchedulingVO>> listSmallScheduling(@ApiParam(name = "schedulingSeo", value = "排期入参分页实体") SchedulingSeo schedulingSeo) {
        PageInfo<ProjectSmallSchedulingVO> page = schedulingBaseService.listSmallScheduling(schedulingSeo);
        return sendJsonData(ResultMessage.SUCCESS, page);
    }

    @RequestMapping(value = "listShangHai", method = RequestMethod.POST)
    @ApiOperation(value = "基础施工项同步(同步上海)-同步上海基础小排期")
    public MyRespBundle<PageInfo<ProjectSmallSchedulingVO>> listShangHai( @ApiParam(name = "schedulingSeo", value = "排期入参分页实体") SchedulingSeo schedulingSeo) {
//        PageInfo<ProjectSmallSchedulingVO> pageInfo = schedulingBaseService.listShangHai(schedulingSeo);
//        return sendJsonData(ResultMessage.SUCCESS, pageInfo);
        String result = schedulingBaseService.listShangHai(schedulingSeo);
        return sendSuccessMessage(result);
    }

    @RequestMapping(value = "addBigScheduling", method = RequestMethod.POST)
    @ApiOperation("施工阶段工期设置-添加基础大排期")
    public MyRespBundle<String> addBigScheduling(@RequestBody@ApiParam(name = "projectBigSchedulingVO", value = "基础大排期信息") List<ProjectBigSchedulingVO> projectBigSchedulingVOList) {
        String result = schedulingBaseService.addBigScheduling(projectBigSchedulingVOList);
        return sendSuccessMessage(result);
    }

    @RequestMapping(value = "listBigScheduling", method = RequestMethod.POST)
    @ApiOperation("施工阶段工期设置-获取基础大排期")
    public MyRespBundle<PageInfo<ProjectBigSchedulingVO>> listBigScheduling(@ApiParam(name = "schedulingSeo", value = "排期入参分页实体") SchedulingSeo schedulingSeo) {
        PageInfo<ProjectBigSchedulingVO> page = schedulingBaseService.listBigScheduling(schedulingSeo);
        return sendJsonData(ResultMessage.SUCCESS, page);
    }

    @RequestMapping(value = "updateSmallScheduling", method = RequestMethod.POST)
    @ApiOperation(value = "施工项关联(修改)-关联小排期与大排期")
    public MyRespBundle<String> updateSmallScheduling(@ApiParam(name = "projectSmallSchedulingVO", value = "小排期实体") ProjectSmallSchedulingVO projectSmallSchedulingVO) {
        String result = schedulingBaseService.updateSmallScheduling(projectSmallSchedulingVO);
        return sendSuccessMessage(result);
    }

    @RequestMapping(value = "updateBigScheduling", method = RequestMethod.POST)
    @ApiOperation(value = "阶段验收配置(修改)-修改基础大排期")
    public MyRespBundle<String> updateBigScheduling( @ApiParam(name = "projectBigSchedulingVO", value = "基础大排期信息") ProjectBigSchedulingVO projectBigSchedulingVO) {
        return schedulingBaseService.updateBigScheduling(projectBigSchedulingVO);
    }

}
