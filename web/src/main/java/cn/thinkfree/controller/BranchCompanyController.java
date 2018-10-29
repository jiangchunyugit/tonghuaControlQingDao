package cn.thinkfree.controller;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.constants.OneTrue;
import cn.thinkfree.database.constants.UserEnabled;
import cn.thinkfree.database.model.BranchCompany;
import cn.thinkfree.database.utils.BeanValidator;
import cn.thinkfree.database.vo.*;
import cn.thinkfree.service.branchcompany.BranchCompanyService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/branchCompany")
@Api(value = "分公司",description = "分公司")
public class BranchCompanyController extends AbsBaseController{

    @Autowired
    BranchCompanyService branchCompanyService;

    /**
     * 创建分公司
     */
    @RequestMapping(value = "/saveBranchCompany", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="分公司管理：新增")
    public MyRespBundle<String> saveBranchCompany(@ApiParam("分公司信息") BranchCompany branchCompany){
//        BeanValidator.validate(branchCompany, Severitys.Insert.class);
        int line = branchCompanyService.addBranchCompany(branchCompany);
        if(line > 0){
            return sendJsonData(ResultMessage.SUCCESS, line);
        }
        return sendJsonData(ResultMessage.FAIL, line);
    }

    /**
     * 编辑分公司信息
     */
    @RequestMapping(value = "/updateBranchCompany", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="分公司管理：编辑")
    public MyRespBundle<String> updateBranchCompany(@ApiParam("分公司信息")BranchCompany branchCompany){
        BeanValidator.validate(branchCompany, Severitys.Update.class);
        int line = branchCompanyService.updateBranchCompany(branchCompany);
        if(line > 0){
            return sendJsonData(ResultMessage.SUCCESS, line);
        }
        return sendJsonData(ResultMessage.FAIL, line);
    }

    /**
     * 查询分公司信息
     */
    @RequestMapping(value = "/branchCompanylist", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="分公司管理：分公司分页查询")
    public MyRespBundle<PageInfo<BranchCompanyVO>> branchCompanylist(@ApiParam("查询分公司参数")BranchCompanySEO branchCompanySEO){

        PageInfo<BranchCompanyVO> pageInfo = branchCompanyService.branchCompanyList(branchCompanySEO);

        return sendJsonData(ResultMessage.SUCCESS, pageInfo);
    }

    /**
     * 分公司详情
     */
    @RequestMapping(value = "/branchCompanyDetails", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="分公司管理：查看")
    public MyRespBundle<BranchCompanyVO> branchCompanyDetails(@ApiParam("分公司id")@RequestParam(value = "id") Integer id){

        BranchCompanyVO branchCompanyVO = branchCompanyService.branchCompanyDetails(id);
        return sendJsonData(ResultMessage.SUCCESS, branchCompanyVO);
    }

    /**
     * 分公司详情
     */
    @RequestMapping(value = "/branchCompanyById", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="分公司管理：编辑回写")
    public MyRespBundle<BranchCompany> branchCompanyById(@ApiParam("分公司id")@RequestParam(value = "id") Integer id){

        BranchCompany branchCompany = branchCompanyService.branchCompanyById(id);
        return sendJsonData(ResultMessage.SUCCESS, branchCompany);
    }

    /**
     * 分公司
     */
    @RequestMapping(value = "/branchCompanys", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="分公司管理：分公司全部信息")
    public MyRespBundle<List<BranchCompany>> branchCompanys(){

        List<BranchCompany> branchCompanys = branchCompanyService.branchCompanys();

        return sendJsonData(ResultMessage.SUCCESS, branchCompanys);
    }

    /**
     * 分公司
     */
    @RequestMapping(value = "/companyRelations", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="分公司管理：分公司全部信息和所属期城市分站信息")
    public MyRespBundle<List<CompanyRelationVO>> companyRelations(){

        List<CompanyRelationVO> companyRelationVOList = branchCompanyService.companyRelationList();

        return sendJsonData(ResultMessage.SUCCESS, companyRelationVOList);
    }

    /**
     * 分公司
     */
    @DeleteMapping(value = "/branchCompanyDelete")
    @MyRespBody
    @ApiOperation(value="分公司管理：删除")
    public MyRespBundle<String> branchCompanyDelete(@ApiParam("分公司id")@RequestParam(value = "id") Integer id){

        BeanValidator.validate(id, Severitys.Update.class);
        BranchCompany branchCompany = new BranchCompany();
        branchCompany.setId(id);
        branchCompany.setIsDel(OneTrue.YesOrNo.YES.val.shortValue());
        int line = branchCompanyService.updateBranchCompany(branchCompany);
        if(line > 0){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 分公司
     */
    @RequestMapping(value = "/branchCompanyEnable", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="分公司管理：启用")
    public MyRespBundle<String> branchCompanyEnable(@ApiParam("分公司id")@RequestParam(value = "id") Integer id){

        BeanValidator.validate(id, Severitys.Update.class);
        BranchCompany branchCompany = new BranchCompany();
        branchCompany.setId(id);
        branchCompany.setIsEnable(UserEnabled.Enabled_true.shortVal().shortValue());
        int line = branchCompanyService.updateBranchCompany(branchCompany);
        if(line > 0){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 分公司
     */
    @RequestMapping(value = "/branchCompanyDisable", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="分公司管理：禁用")
    public MyRespBundle<PageInfo<String>> branchCompanyDisable(@ApiParam("分公司id")@RequestParam(value = "id") Integer id){

        BeanValidator.validate(id, Severitys.Update.class);
        BranchCompany branchCompany = new BranchCompany();
        branchCompany.setId(id);
        branchCompany.setIsEnable(UserEnabled.Disable.shortVal());
        int line = branchCompanyService.updateBranchCompany(branchCompany);
        if(line > 0){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }
}
