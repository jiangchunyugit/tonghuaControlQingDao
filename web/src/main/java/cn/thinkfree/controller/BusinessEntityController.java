package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.annotation.MySysLog;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.core.constants.SysLogAction;
import cn.thinkfree.core.constants.SysLogModule;
import cn.thinkfree.database.constants.OneTrue;
import cn.thinkfree.database.constants.UserEnabled;
import cn.thinkfree.database.model.BusinessEntity;
import cn.thinkfree.database.utils.BeanValidator;
import cn.thinkfree.database.vo.BusinessEntitySEO;
import cn.thinkfree.database.vo.BusinessEntityStoreVO;
import cn.thinkfree.database.vo.BusinessEntityVO;
import cn.thinkfree.database.vo.Severitys;
import cn.thinkfree.service.businessentity.BusinessEntityService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiangchunyu(后台)
 * @date 2018
 * @Description 经营主体
 */
@RestController
@RequestMapping(value = "/businessEntity")
@Api(value = "前端使用---经营主体数据---蒋春雨",description = "前端使用---经营主体数据---蒋春雨")
public class BusinessEntityController extends AbsBaseController{

    @Autowired
    BusinessEntityService businessEntityService;

    /**
     * 创建经营主体
     */
    @PostMapping(value = "/saveBusinessEntity")
    @MyRespBody
    @ApiOperation(value="经营主体数据：创建主体")
    @MySysLog(action = SysLogAction.SAVE,module = SysLogModule.PC_PROJECT,desc = "创建经营主体")
    public MyRespBundle<String> saveBusinessEntity(@ApiParam("经营主体信息") BusinessEntity businessEntity){
        BeanValidator.validate(businessEntity, Severitys.Insert.class);
        if (businessEntityService.checkRepeat(businessEntity)) {
            return sendFailMessage("经营主体名称已存在");
        }
        if(businessEntityService.addBusinessEntity(businessEntity)){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 编辑经营主体信息
     */
    @PostMapping(value = "/updateBusinessEntity")
    @MyRespBody
    @ApiOperation(value="经营主体数据：编辑主体")
    @MySysLog(action = SysLogAction.EDIT,module = SysLogModule.PC_PROJECT,desc = "编辑经营主体")
    public MyRespBundle<String> updateBusinessEntity(@ApiParam("经营主体信息")BusinessEntity businessEntity){
        BeanValidator.validate(businessEntity, Severitys.Update.class);
        if (businessEntityService.checkRepeat(businessEntity)) {
            return sendFailMessage("经营主体名称已存在");
        }
        if(businessEntityService.updateBusinessEntity(businessEntity)){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 经营主体详情
     */
    @GetMapping(value = "/businessEntityByid")
    @MyRespBody
    @ApiOperation(value="经营主体数据：编辑回写")
    public MyRespBundle<BusinessEntityVO> businessEntityByid(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntity businessEntity = businessEntityService.businessEntityById(id);
        return sendJsonData(ResultMessage.SUCCESS, businessEntity);
    }

    /**
     * 编辑经营主体信息
     */
    @PostMapping(value = "/businessEntityStore")
    @MyRespBody
    @ApiOperation(value="经营主体数据：经营主体门店保存")
    @MySysLog(action = SysLogAction.SAVE,module = SysLogModule.PC_PROJECT,desc = "经营主体选择门店")
    public MyRespBundle<String> businessEntityStore(@ApiParam("经营主体信息")BusinessEntityStoreVO businessEntityStoreVO){
        BeanValidator.validate(businessEntityStoreVO, Severitys.Insert.class);
        try {
            if(businessEntityService.insertBusinessEntityStore(businessEntityStoreVO)){
                return sendJsonData(ResultMessage.SUCCESS, "操作成功");
            }
        }catch (DataAccessException e) {
            return sendFailMessage("门店已存在,请重新选择");
        }

        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 查询经营主体信息
     */
    @GetMapping(value = "/businessEntitylist")
    @MyRespBody
    @ApiOperation(value="经营主体数据：经营主体数据维护（经营主体分页查询）")
    public MyRespBundle<PageInfo<BusinessEntityVO>> businessEntitylist(@ApiParam("查询经营主体参数")BusinessEntitySEO businessEntitySEO){

        PageInfo<BusinessEntityVO> pageInfo = businessEntityService.businessEntityList(businessEntitySEO);

        return sendJsonData(ResultMessage.SUCCESS, pageInfo);
    }

    /**
     * 经营主体详情
     */
    @GetMapping(value = "/businessEntityDetails")
    @MyRespBody
    @ApiOperation(value="经营主体数据：查看主体详情")
    public MyRespBundle<BusinessEntityVO> businessEntityDetails(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntityVO businessEntityVO = businessEntityService.businessEntityDetails(id);
        return sendJsonData(ResultMessage.SUCCESS, businessEntityVO);
    }

    /**
     * 经营主体详情
     */
    @GetMapping(value = "/businessEntityStoreInfos")
    @MyRespBody
    @ApiOperation(value="经营主体数据：选择门店回写")
    public MyRespBundle<BusinessEntityStoreVO> businessEntityStoreInfos(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntityStoreVO businessEntityStoreVO = businessEntityService.businessEntityStoreDetails(id);
        return sendJsonData(ResultMessage.SUCCESS, businessEntityStoreVO);
    }

    /**
     * 经营主体
     */
    @GetMapping(value = "/businessEntitys")
    @MyRespBody
    @ApiOperation(value="经营主体数据：经营主体信息")
    public MyRespBundle<List<BusinessEntity>> businessEntitys(){

        List<BusinessEntity> businessEntitys = businessEntityService.businessEntices();

        return sendJsonData(ResultMessage.SUCCESS, businessEntitys);
    }

    /**
     * 经营主体
     */
    @PostMapping(value = "/businessEntityDelete")
    @MyRespBody
    @ApiOperation(value="经营主体数据：删除")
    @MySysLog(action = SysLogAction.DEL,module = SysLogModule.PC_PROJECT,desc = "删除经营主体")
    public MyRespBundle<String> businessEntityDelete(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.setId(id);
        businessEntity.setIsDel(OneTrue.YesOrNo.YES.val.shortValue());
        if(businessEntityService.deleteBusinessEntity(businessEntity)){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 经营主体
     */
    @PostMapping(value = "/businessEntityEnable")
    @MyRespBody
    @ApiOperation(value="经营主体数据：启用")
    @MySysLog(action = SysLogAction.CHANGE_STATE,module = SysLogModule.PC_PROJECT,desc = "启用经营主体")
    public MyRespBundle<String> businessEntityEnable(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntityVO businessEntity = new BusinessEntityVO();
        businessEntity.setId(id);
        businessEntity.setIsEnable(UserEnabled.Enabled_true.shortVal().shortValue());
        if(businessEntityService.updateBusinessEntity(businessEntity)){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 经营主体
     */
    @RequestMapping(value = "/businessEntityDisable", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="经营主体数据：禁用")
    @MySysLog(action = SysLogAction.CHANGE_STATE,module = SysLogModule.PC_PROJECT,desc = "禁用经营主体")
    public MyRespBundle<String> businessEntityDisable(@ApiParam("经营主体id")@RequestParam(value = "id") Integer id){

        BusinessEntityVO businessEntity = new BusinessEntityVO();
        businessEntity.setId(id);
        businessEntity.setIsEnable(UserEnabled.Disable.shortVal());
        if(businessEntityService.updateBusinessEntity(businessEntity)){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }
}

