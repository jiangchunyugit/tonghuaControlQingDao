package cn.thinkfree.service.companysubmit;

import java.text.SimpleDateFormat;
import java.util.*;

import cn.thinkfree.core.constants.SysConstants;
import cn.thinkfree.database.constants.UserLevel;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.*;
import cn.thinkfree.service.constants.AuditStatus;
import cn.thinkfree.service.constants.CompanyConstants;
import cn.thinkfree.service.utils.ExcelData;
import cn.thinkfree.service.utils.ExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.core.utils.WebFileUtil;
import cn.thinkfree.database.mapper.CompanyInfoExpandMapper;
import cn.thinkfree.database.mapper.CompanyInfoMapper;
import cn.thinkfree.database.mapper.MyContractInfoMapper;
import cn.thinkfree.database.mapper.PcAuditInfoMapper;
import cn.thinkfree.database.mapper.PcCompanyFinancialMapper;
import cn.thinkfree.service.constants.CompanyAuditStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ying007
 * 公司入驻业务
 */
@Service
public class CompanySubmitServiceImpl implements CompanySubmitService {

    @Autowired
    CompanyInfoExpandMapper companyInfoExpandMapper;

    @Autowired
    PcCompanyFinancialMapper pcCompanyFinancialMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;
    
    @Autowired
	MyContractInfoMapper contractInfoMapper;
	
	@Autowired
	PcAuditInfoMapper pcAuditInfoMapper;


	@Override
	public CompanySubmitVo findCompanyInfo(String companyId) {
		CompanySubmitVo companySubmitVo = new CompanySubmitVo();

		//查询companyInfo表：平台状态：platform_type=0;
		// 删除状态：is_delete=2;    审核状态：is_check=1;    审批状态：audit_status=7
		CompanyInfoExample companyInfoExample = new CompanyInfoExample();
		companyInfoExample.createCriteria().andCompanyIdEqualTo(companyId)
				.andIsDeleteEqualTo(SysConstants.YesOrNoSp.NO.shortVal())
				.andIsCheckEqualTo(SysConstants.YesOrNo.YES.shortVal())
				.andAuditStatusEqualTo(CompanyAuditStatus.SUCCESSJOIN.stringVal())
				.andPlatformTypeEqualTo(SysConstants.YesOrNo.NO.shortVal());

		List<CompanyInfo> companyInfo = companyInfoMapper.selectByExample(companyInfoExample);
		if(companyInfo.get(0) == null){
			return null;
		}
		companySubmitVo.setCompanyInfo(companyInfo.get(0));

		//查询companyInfoExpand表：
		CompanyInfoExpandExample companyInfoExpandExample = new CompanyInfoExpandExample();
		companyInfoExpandExample.createCriteria().andCompanyIdEqualTo(companyId);
		List<CompanyInfoExpand> companyInfoExpand = companyInfoExpandMapper.selectByExample(companyInfoExpandExample);
		companySubmitVo.setCompanyTypeName(CompanyConstants.CompanySharesType.getDesc(companyInfoExpand.get(0).getCompanyType().intValue()));
		companySubmitVo.setCompanyInfoExpand(companyInfoExpand.get(0));


//		对公账信息PcCompanyFinancial
		PcCompanyFinancialExample pcCompanyFinancialExample = new PcCompanyFinancialExample();
		pcCompanyFinancialExample.createCriteria().andCompanyIdEqualTo(companyId);
		List<PcCompanyFinancial> companyFinancials = pcCompanyFinancialMapper.selectByExample(pcCompanyFinancialExample);
		companySubmitVo.setPcCompanyFinancial(companyFinancials.get(0));

		return companySubmitVo;
	}

	@Override
	public boolean changeCompanyInfo(CompanyTemporaryVo companyTemporaryVo) {
		//图片重新生成
		return false;
	}

	/**
	 * 公司列表
	 * @param companyListSEO
	 * @return
	 */
	@Override
	public PageInfo<CompanyListVo> list(CompanyListSEO companyListSEO) {
		UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
		List<String> relationMap = userVO.getRelationMap();
		companyListSEO.setRelationMap(relationMap);

		PageHelper.startPage(companyListSEO.getPage(),companyListSEO.getRows());
		List<CompanyListVo> companyListVoList = companyInfoMapper.list(companyListSEO);
		return new PageInfo<>(companyListVoList);
	}

	@Override
	public void downLoad(HttpServletResponse response, CompanyListSEO companyListSEO) {
		ExcelData data = new ExcelData();
		data.setName("用户信息数据");
		//添加表头
		String[] titleArrays = {"公司编号","公司类型","公司性质","所属站点","公司名称",
				"入驻日期","截至时间","签约时间","法人","联系人","联系电话","保证金","状态"};
		List<String> titles = new ArrayList();
		for(String title: titleArrays){
			titles.add(title);
		}
		data.setTitles(titles);
		//添加列
		List<List<Object>> rows = new ArrayList();
		List<Object> row = null;
		List<CompanyListVo> companyListVoList = companyInfoMapper.list(companyListSEO);

		for(CompanyListVo vo: companyListVoList){
			row=new ArrayList();
			row.add(vo.getCompanyId());
			row.add(vo.getRoleName());
			row.add(vo.getComapnyNature());
			row.add(vo.getSiteProvinceName()+vo.getSiteCityName()+vo.getSiteName());
			row.add(vo.getCompanyName());
			row.add(vo.getStartTime());
			row.add(vo.getEndTime());
			row.add(vo.getSignedTime());
			row.add(vo.getLegalName());
			row.add(vo.getContactName());
			row.add(vo.getContactPhone());
			row.add(vo.getDepositMoney());
			row.add(CompanyAuditStatus.getDesc(Integer.parseInt(vo.getAuditStatus())));
			rows.add(row);
		}
		data.setRows(rows);

		SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String fileName=fdate.format(new Date())+".xls";
		try{
			ExcelUtils.exportExcel(response, fileName, data);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
    public boolean upCompanyInfo(CompanySubmitVo companySubmitVo) {
        Date date = new Date();

        //1.更新表company_info
        int ci = updateCompanyInfo(companySubmitVo, date);

        //2.插入表pc_company_financial
        int pcf = addFinancial(companySubmitVo, date);

        //3.更新表company_info_expand
        int cie = updateCompanyExpand(companySubmitVo, date);

        if(ci > 0 && pcf > 0 && cie > 0){
            return true;
        }
        return false;
    }

    private int updateCompanyExpand(CompanySubmitVo companySubmitVo, Date date) {
        //公司资质上传文件
        CompanySubmitFileVo companySubmitFileVo = companySubmitVo.getCompanySubmitFileVo();

        CompanyInfoExpand companyInfoExpand = companySubmitVo.getCompanyInfoExpand();
        companyInfoExpand.setUpdateTime(date);
        //企业税务登记证
        companyInfoExpand.setTaxCodePhotoUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getTaxCodePhotoUrl()));
        CompanyInfoExpandExample companyInfoExpandExample = new CompanyInfoExpandExample();
        companyInfoExpandExample.createCriteria()
				.andCompanyIdEqualTo(companySubmitVo.getCompanyInfo().getCompanyId());
        return companyInfoExpandMapper.updateByExampleSelective(companyInfoExpand,companyInfoExpandExample);
    }

    private int addFinancial(CompanySubmitVo companySubmitVo, Date date) {
        //公司资质上传文件
        CompanySubmitFileVo companySubmitFileVo = companySubmitVo.getCompanySubmitFileVo();

        PcCompanyFinancial pcCompanyFinancial = companySubmitVo.getPcCompanyFinancial();
        pcCompanyFinancial.setCompanyId(companySubmitVo.getCompanyInfo().getCompanyId());
        pcCompanyFinancial.setCreateTime(date);
        pcCompanyFinancial.setUpdateTime(date);
        //开户行许可证
        pcCompanyFinancial.setLicenseUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getLicenseUrl()));
        return pcCompanyFinancialMapper.insertSelective(pcCompanyFinancial);
    }

    private int updateCompanyInfo(CompanySubmitVo companySubmitVo, Date date) {
        //公司资质上传文件
        CompanySubmitFileVo companySubmitFileVo = companySubmitVo.getCompanySubmitFileVo();
        CompanyInfo companyInfo = companySubmitVo.getCompanyInfo();

        companyInfo.setPhone(companyInfo.getLegalPhone());
        companyInfo.setUpdateTime(date);
        //资质上传成功后审批状态改为已激活
        companyInfo.setAuditStatus(CompanyAuditStatus.ACTIVATION.stringVal());
        //营业执照
        companyInfo.setBusinessPhotoUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getBusinessPhotoUrl()));
        //装修施工资质证书
        companyInfo.setWorkPhotoUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getWorkPhotoUrl()));
        //法人身份证正面
        companyInfo.setLefalCardUpUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getLefalCardUpUrl()));
        //法人身份证反面
        companyInfo.setLefalCardDownUrl(WebFileUtil.fileCopy("static/", companySubmitFileVo.getLefalCardDownUrl()));
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.createCriteria().andCompanyIdEqualTo(companyInfo.getCompanyId());
        return companyInfoMapper.updateByExampleSelective(companyInfo,companyInfoExample);
    }

	@Override
	public Map<String, String> auditContract( String companyId, String auditStatus,
			String auditCase) {
		Map<String,String> map = new HashMap<>();
		
		if(StringUtils.isEmpty(companyId)){
			map.put("code", "1");
			map.put("msg", "公司编号为空");
			return  map;
		}if(StringUtils.isEmpty(auditStatus)){
			map.put("code", "1");
			map.put("msg", "审核状态为空");
			return  map;
		}if(!StringUtils.isEmpty(auditStatus) && auditCase.equals("1") && StringUtils.isEmpty(auditCase)){
			map.put("code", "1");
			map.put("msg", "清填写审核不通过原因");
			return  map;
		}
		if(auditCase.equals("0")){
	        //运营审核通过生成合同编号
			String contractNumber = String.valueOf(UUID.randomUUID());
			
			//修改合同表 0草稿 1待审批 2 审批通过 3 审批拒绝
			ContractVo vo = new ContractVo();
			vo.setCompanyId(companyId);
			vo.setContractNumber(contractNumber);
			vo.setContractStatus("0");
			int flag = contractInfoMapper.updateContractStatus(vo);
			//修改公司表 
		
			CompanyInfo companyInfo = new CompanyInfo();
			companyInfo.setCompanyId(companyId);
			if(auditCase.equals("0")){//运营审核通过
				companyInfo.setAuditStatus(CompanyAuditStatus.APTITUDETG.stringVal());
			}else{//财务审核不通过
				companyInfo.setAuditStatus(CompanyAuditStatus.SUCCESSJOSB.stringVal());
			}
			int flagT = companyInfoMapper.updateauditStatus(companyInfo);
			
			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			//添加审核记录表
			PcAuditInfo record = new PcAuditInfo("1", "1", auditPersion, auditStatus, new Date(),
					companyId, auditCase, contractNumber);
			
			int flagi = pcAuditInfoMapper.insertSelective(record);
		    
			if(flag > 0 && flagT > 0 &&  flagi  > 0 ){
				
				map.put("code", "0");
				map.put("msg", "审核成功");
				
			}else{
				map.put("code", "1");
				map.put("msg", "审核失败");
			}
		}else{//审核失败

			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			//添加审核记录表
			PcAuditInfo record = new PcAuditInfo("1", "1", auditPersion, auditStatus, new Date(),
					companyId, auditCase, "");
		    pcAuditInfoMapper.insertSelective(record);
			
		}
		return map;
	}
}
