package cn.thinkfree.controller;

import java.util.Map;

import cn.thinkfree.database.vo.CompanyListSEO;
import cn.thinkfree.database.vo.CompanyListVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.thinkfree.core.annotation.MyRespBody;
import cn.thinkfree.core.base.AbsBaseController;
import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.constants.ResultMessage;
import cn.thinkfree.database.vo.CompanySubmitVo;
import cn.thinkfree.database.vo.ContractDetails;
import cn.thinkfree.service.companysubmit.CompanySubmitService;
import cn.thinkfree.service.contract.ContractService;
import cn.thinkfree.service.contractTemplate.ContractTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ying007
 * @date 2018/09/14
 * 公司资质
 */
@RestController
@RequestMapping(value = "/companyAudit")
@Api(value = "公司入驻",description = "公司入驻")
public class CompanyInfoSubmitController extends AbsBaseController {
    @Autowired
    CompanySubmitService companySubmitService;
    
    @Autowired
	ContractService contractService;
    @Autowired
    ContractTemplateService contractTemplateService;

    @RequestMapping(value = "/upCompanyInfo", method = RequestMethod.POST)
    @MyRespBody
    @ApiOperation(value="审核资质上传")
    public MyRespBundle<String> upCompanyInfo(@ApiParam("公司资质信息")CompanySubmitVo companySubmitVo){
        boolean flag = companySubmitService.upCompanyInfo(companySubmitVo);
        if(flag){
            return sendJsonData(ResultMessage.SUCCESS, "操作成功");
        }
        return sendJsonData(ResultMessage.FAIL, "操作失败");
    }

    /**
     * 公司资质查询list
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @MyRespBody
    @ApiOperation(value="公司申请信息审批列表")
    public MyRespBundle<String> list(@ApiParam("条件查询参数")CompanyListSEO companyListSEO){
        PageInfo<CompanyListVo> pageInfo = companySubmitService.list(companyListSEO);
        return sendJsonData(success, "操作成功", pageInfo);
    }

    /**
     * 导出
     */
    @RequestMapping(value = "/downLoad", method = RequestMethod.GET)
    @ExceptionHandler(value=Exception.class)
    @ApiOperation(value="公司申请信息审批列表导出")
    public void downLoad(HttpServletResponse response, @ApiParam("条件查询参数")CompanyListSEO companyListSEO){
        companySubmitService.downLoad(response, companyListSEO);
    }

    //补全合同
    
    /**
     * 查看合同
     * @author lqd
     * @return Message
     * 
     */
    @ApiOperation(value = "查看合同", notes = "查看合同",consumes = "application/text")
    @PostMapping("/getContractDetailInfo")
    public MyRespBundle<String> getContractDetailInfo(@ApiParam("合同编号")@RequestParam(required = true) String contractNumber,
    		@ApiParam("公司编号")@RequestParam(required = true) String companyId){
    	Map<String,Object>   resMap  =  contractService.getContractDetailInfo(contractNumber, companyId);
        return sendJsonData(ResultMessage.SUCCESS,resMap);
    }
    /**
     * 查询字典
     * @author lqd
     * @return Message
     * 
     */
    @ApiOperation(value = "查看合同条款字典", notes = "合同条款设置(设置合同条款需要查询字典接口)",consumes = "application/text")
    @PostMapping("/queryContractDic/")
    public MyRespBundle<String> queryContractDic(@RequestParam String type){
    	 Map<String,String>  resMap  =  contractTemplateService.queryContractDic(type);
        return sendJsonData(ResultMessage.SUCCESS,resMap);
    }
    
    
    
    /**
     * 
     * 合同条款设置
     * @author lqd
     * @return Message
     */
    @ApiOperation(value = "合同条款设置", notes = "合同条款设置(设置合同条款需要查询字典接口)",consumes = "application/json")
    @PostMapping("/settingContractClause/{contractNumber}/{companyId}")
    @MyRespBody
    public MyRespBundle<String> settingContractClause(@PathVariable("contractNumber") String contractNumber,
    		@PathVariable("companyId") String companyId,
    		@ApiParam("合同条款key和value值")@RequestBody (required = true) Map<String,String> paramMap){
    	 Map<String,String>  resMap  =  contractService.insertContractClause(contractNumber, companyId, paramMap);
        return sendJsonData(ResultMessage.SUCCESS,resMap);
    }


    
    
    /**
     * 公司详情
     * @author lqd
     * @return Message
     */
    
    @ApiOperation(value = "公司详情", notes = "公司详情")
    @PostMapping("/companyDetails")
    @MyRespBody
    public MyRespBundle<String> companyDetails(@ApiParam("合同编号")@RequestParam String contractNumber,
    		@ApiParam("公司编号")@RequestParam String companyId){
    	ContractDetails jbj =  contractService.contractDetails(contractNumber, companyId);
        return sendJsonData(ResultMessage.SUCCESS,jbj);
    }

    
    /**
     * 运营人员审批
     * @author lqd
     * @return Message
     */
    @ApiOperation(value = "资质审批", notes = "运营审核")
    @PostMapping("/auditCompany")
    @MyRespBody
    //@MySysLog(action = SysLogAction.DEL,module = SysLogModule.PC_CONTRACT,desc = "合同审批")
    public MyRespBundle<String> auditCompany(
    		@ApiParam("公司编号")@RequestParam String companyId,
    		@ApiParam("审批状态 0 代表通过 1 拒绝 ")@RequestParam String auditStatus,
    		@ApiParam("审核成功或者失败的原因 ")@RequestParam String auditCase){
        
    	 Map<String,String>  resMap = companySubmitService.auditContract(companyId,auditStatus,auditCase);
    	 
    	 String code = String.valueOf(resMap.get("code"));
    	 
    	 String mes = String.valueOf(resMap.get("msg"));
    	 
    	 if(code.equals("1")){//失败的情况
    		 return sendFailMessage(mes);
    	 }else{//成功的情况
    		 return sendSuccessMessage(mes);
    	 }
       
    }
}
