package cn.thinkfree.service.companysubmit;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import cn.thinkfree.core.event.BaseEvent;
import cn.thinkfree.database.constants.CompanyAuditStatus;
import cn.thinkfree.database.event.sync.CompanyJoin;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.*;
import cn.thinkfree.database.vo.contract.ContractCostVo;
import cn.thinkfree.service.companyapply.CompanyApplyService;
import cn.thinkfree.service.constants.AuditStatus;
import cn.thinkfree.service.constants.CompanyApply;
import cn.thinkfree.service.constants.ContractStatus;
import cn.thinkfree.service.contract.ContractService;
import cn.thinkfree.service.event.EventService;
import cn.thinkfree.service.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.thinkfree.core.constants.SysConstants;
import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.core.utils.SpringBeanUtil;
import cn.thinkfree.core.utils.WebFileUtil;
import cn.thinkfree.service.constants.CompanyConstants;

/**
 * @author ying007
 * 公司入驻业务
 */
@Service
public class CompanySubmitServiceImpl implements CompanySubmitService {

    @Autowired
    CompanyInfoExpandMapper qcompanyInfoExpandMapper;

    @Autowired
    PcCompanyFinancialMapper pcCompanyFinancialMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;
    
    @Autowired
	MyContractInfoMapper contractInfoMapper;
	
	@Autowired
	PcAuditInfoMapper pcAuditInfoMapper;

	@Autowired
	PcAuditTemporaryInfoMapper pcAuditTemporaryInfoMapper;

	@Autowired
	CompanyApplyService companyApplyService;

	@Autowired
	CompanySubmitService companySubmitService;

	@Autowired
	PcApplyInfoMapper pcApplyInfoMapper;

	@Autowired
    ContractTermsMapper pcContractTermsMapper;

	@Autowired
    ContractTermsChildMapper contractTermsChildMapper;

	@Autowired
	ContractInfoMapper contractInfoMappers;

	@Autowired
	ContractService contractService;

	@Autowired
	CompanyInfoExpandMapper companyInfoExpandMapper;

	@Autowired
	EventService eventService;


	final static String TARGET = "static/";



	@Override
	public CompanyDetailsVO companyDetails(String contractNumber, String companyId, String auditType, String applyDate) {
		CompanyDetailsVO companyDetailsVO = new CompanyDetailsVO();
		//公司详情
		CompanySubmitVo companySubmitVo = companySubmitService.findCompanyInfo(companyId);
		companyDetailsVO.setCompanySubmitVO(companySubmitVo);

		List<String> list = new ArrayList<>();
		list.add(auditType);
		list.add(CompanyConstants.AuditType.ENTRY.stringVal());

        //审批信息
		PcAuditInfoExample autit = new PcAuditInfoExample();
		if(CompanyConstants.AuditType.JOINON.stringVal().equals(auditType)){
			autit.createCriteria().andCompanyIdEqualTo(companyId)
					.andAuditTypeIn(list);
		}else{
			autit.createCriteria().andCompanyIdEqualTo(companyId)
					.andAuditTypeEqualTo(auditType).andAuditTimeGreaterThan(DateUtils.strToDate(applyDate));
		}

		if(StringUtils.isNotBlank(contractNumber)){
			/* 合同详情 */
			List<ContractCostVo> contractCostVos = contractService.queryListContractCostVoBycontractNumber(contractNumber, companySubmitVo.getCompanyInfo().getRoleId());
			companyDetailsVO.setContractTermsList(contractCostVos);

			/* 合同信息 */
			ContractVo vo = new ContractVo();
			vo.setContractNumber( contractNumber );
			ContractVo	newVo = contractInfoMapper.selectContractBycontractNumber( vo );
			companyDetailsVO.setContractVo(newVo);

			//审批信息
			autit.createCriteria().andContractNumberEqualTo(contractNumber);
		}else{
			companyDetailsVO.setContractTermsList(null);
			companyDetailsVO.setContractVo(null);
		}
		autit.setOrderByClause("create_time asc");
		List<PcAuditInfo> auList =  pcAuditInfoMapper.selectByExample(autit);
		companyDetailsVO.setPcAuditInfo(auList);

        return companyDetailsVO;
	}

    @Override
	public PcAuditInfo findAuditCase(String companyId) {
		PcAuditInfo pcAuditInfo = pcAuditInfoMapper.findAuditCase(companyId);

//		if(pcAuditInfos.size() > 0){
//			return pcAuditInfos.get(0);
//		}
		return pcAuditInfo;
	}

	@Override
	public AuditInfoVO findAuditStatus(String companyId) {
		Map<String, String> map = new HashMap<>();
		map.put("companyId", companyId);
		map.put("auditType", CompanyConstants.AuditType.JOINON.stringVal());

		AuditInfoVO auditInfoVO = pcAuditInfoMapper.findAuditStatus(map);
		if(auditInfoVO == null){
			auditInfoVO = new AuditInfoVO();
			auditInfoVO.setCompanyAuditType(CompanyAuditStatus.AUDITING.stringVal());
			auditInfoVO.setCompanyAuditName("资质审核中");
			return auditInfoVO;
		}

		CompanyInfoExample example = new CompanyInfoExample();
		example.createCriteria().andCompanyIdEqualTo(companyId);
		List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(example);

		if(companyInfos.size() > 0){
			CompanyInfo companyInfo = companyInfos.get(0);
			//如果公司入驻状态是7：确认保证金  说明运营，财务审核完成审核，合同签约
			if(CompanyAuditStatus.NOTPAYBAIL.code.toString().equals(companyInfo.getAuditStatus())){
				auditInfoVO.setCompanyAuditName("签约完成");
			}else if(CompanyAuditStatus.FAILAUDIT.stringVal().equals(companyInfo.getAuditStatus())){
				auditInfoVO.setCompanyAuditName(CompanyAuditStatus.FAILAUDIT.mes);

			}else if(CompanyAuditStatus.FAILCHECK.stringVal().equals(companyInfo.getAuditStatus())){
				auditInfoVO.setCompanyAuditName(CompanyAuditStatus.FAILCHECK.mes);

			}else if(CompanyAuditStatus.NOTPAYBAIL.code > Integer.parseInt(companyInfo.getAuditStatus())){
				auditInfoVO.setCompanyAuditName("资质审核中");
			}
		}

		return auditInfoVO;
	}

	@Override
	public CompanySubmitVo findCompanyInfo(String companyId) {
		if(companyId == null){
			return null;
		}
		CompanySubmitVo companySubmitVo = new CompanySubmitVo();

		//查询companyInfo表：平台状态：platform_type=0;
		// 删除状态：is_delete=2;

		CompanyInfoVo companyInfo = companyInfoMapper.selectByCompanyId(companyId);
		companySubmitVo.setCompanyInfo(companyInfo);

		//查询companyInfoExpand表：
		CompanyInfoExpandVO companyInfoExpandVO = companyInfoExpandMapper.findCompanyExpand(companyId);

		if(companyInfoExpandVO != null &&  companyInfoExpandVO.getCompanyType()!= null) {
			companySubmitVo.setCompanyTypeName(CompanyConstants.CompanySharesType.getDesc(companyInfoExpandVO.getCompanyType().intValue()));
		}
		companySubmitVo.setCompanyInfoExpand(companyInfoExpandVO);



//		对公账信息PcCompanyFinancial
		CompanyFinancialVO companyFinancials = pcCompanyFinancialMapper.findFinancialVOByCompanyId(companyId);

		companySubmitVo.setPcCompanyFinancial(companyFinancials);


		return companySubmitVo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean changeCompanyInfo(CompanyTemporaryVo companyTemporaryVo) {
		Date date = new Date();
		//插入资质变更表
		PcAuditTemporaryInfo pcAuditTemporaryInfo = new PcAuditTemporaryInfo();
		SpringBeanUtil.copy(companyTemporaryVo, pcAuditTemporaryInfo);
		pcAuditTemporaryInfo.setCreateTime(date);
		pcAuditTemporaryInfo.setUpdateTime(date);
		pcAuditTemporaryInfo.setChangeDate(date);
		pcAuditTemporaryInfo.setChangeStatus(Short.valueOf(AuditStatus.AUDITING.shortVal()));
		int line = pcAuditTemporaryInfoMapper.insertSelective(pcAuditTemporaryInfo);

		//插入申请表
		PcApplyInfo pcApplyInfo = new PcApplyInfo();
		pcApplyInfo.setTransactType(SysConstants.YesOrNo.NO.shortVal());
		pcApplyInfo.setCompanyId(pcAuditTemporaryInfo.getCompanyId());
		pcApplyInfo.setApplyType(CompanyApply.applyTpye.COMPANYAPPLY.shortVal());
		pcApplyInfo.setIsDelete(SysConstants.YesOrNo.NO.shortVal());
		pcApplyInfo.setApplyDate(date);
		pcApplyInfo.setApplyThingType(CompanyApply.applyThinkType.APPLYCHANGE.shortVal());
		pcApplyInfo.setAreaCode(pcAuditTemporaryInfo.getAreaCode());
		pcApplyInfo.setCompanyName(pcAuditTemporaryInfo.getCompanyName());
		pcApplyInfo.setCompanyRole(pcAuditTemporaryInfo.getRoleId());
		pcApplyInfo.setProvinceCode(pcAuditTemporaryInfo.getProvinceCode());
		pcApplyInfo.setCityCode(pcAuditTemporaryInfo.getCityCode());
		pcApplyInfo.setContactName(pcAuditTemporaryInfo.getContactName());
		pcApplyInfo.setContactPhone(pcAuditTemporaryInfo.getContactPhone());
		int applyLine = pcApplyInfoMapper.insertSelective(pcApplyInfo);
		if(line > 0 && applyLine > 0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String auditChangeCompany(PcAuditInfo pcAuditInfo) {
		String companyId = pcAuditInfo.getCompanyId();
		Date date = new Date();
		//1：查询公司资质临时表
		PcAuditTemporaryInfoExample example = new PcAuditTemporaryInfoExample();
		example.createCriteria().andCompanyIdEqualTo(companyId).andChangeStatusEqualTo(Short.valueOf(AuditStatus.AUDITING.shortVal()));
		List<PcAuditTemporaryInfo>
				pcAuditTemporaryInfo = pcAuditTemporaryInfoMapper.selectByExample(example);

		//audit_type:审核状态 1通过  0不通过
		if(pcAuditTemporaryInfo.size() <= 0){
			return "审批失败";
		}
		if(AuditStatus.AuditPass.shortVal().equals(pcAuditInfo.getAuditStatus())){

			//2：修改公司临时表状态：change_status:资质变更状态：0：审批成功 1：审批失败 2:审批中
			pcAuditTemporaryInfo.get(0).setChangeStatus(Short.valueOf(AuditStatus.AuditPass.shortVal()));
			int addLine = pcAuditTemporaryInfoMapper.updateByExampleSelective(pcAuditTemporaryInfo.get(0), example);
			if(addLine <= 0){
				return "审批失败";
			}
			//3：审批通过更新公司表
			CompanyInfo companyInfo = new CompanyInfo();

			SpringBeanUtil.copy(pcAuditTemporaryInfo, companyInfo);

			companyInfo.setId(null);
			companyInfo.setUpdateTime(date);
			CompanyInfoExample companyInfoExample = new CompanyInfoExample();
			companyInfoExample.createCriteria().andCompanyIdEqualTo(companyId);
			int companyLine = companyInfoMapper.updateByExampleSelective(companyInfo, companyInfoExample);
			if(companyLine <= 0){
				return "审批失败";
			}

			//4:审批通过更新公司拓展表
			CompanyInfoExpand companyInfoExpand = new CompanyInfoExpand();
			CompanyInfoExpandExample companyInfoExpandExample = new CompanyInfoExpandExample();
			companyInfoExpandExample.createCriteria().andCompanyIdEqualTo(companyId);
			SpringBeanUtil.copy(pcAuditTemporaryInfo, companyInfoExpand);
			companyInfoExpand.setId(null);
			companyInfoExpand.setUpdateTime(date);
			int companyExpandLine = companyInfoExpandMapper.updateByExampleSelective(companyInfoExpand, companyInfoExpandExample);
			if(companyExpandLine <= 0){
				return "审批失败";
			}

			//5:审批通过更新公司银行账户表
			PcCompanyFinancial pcCompanyFinancial = new PcCompanyFinancial();
			PcCompanyFinancialExample pcCompanyFinancialExample = new PcCompanyFinancialExample();
			pcCompanyFinancialExample.createCriteria().andCompanyIdEqualTo(companyId);
			SpringBeanUtil.copy(pcAuditTemporaryInfo, pcCompanyFinancial);
			pcCompanyFinancial.setId(null);
			pcCompanyFinancial.setUpdateTime(date);
			int financialLine = pcCompanyFinancialMapper.updateByExampleSelective(pcCompanyFinancial, pcCompanyFinancialExample);
			if(financialLine <= 0){
				return "审批失败";
			}

			//运营审核通过添加一条审批记录
			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			String auditAccount = userVO ==null?"":userVO.getUserRegister().getPhone();
			//添加审核记录表
			PcAuditInfo record = new PcAuditInfo(CompanyConstants.AuditType.CHANGE.toString(), pcAuditInfo.getAuditLevel(), auditPersion, pcAuditInfo.getAuditStatus(), date,
					companyId, pcAuditInfo.getAuditCase(), "", date, auditAccount);

			int flagi = pcAuditInfoMapper.insertSelective(record);
			if(flagi <= 0){
				return "审批失败";
			}

			return "审批成功";

		}else{//审核失败

			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			String auditAccount = userVO ==null?"":userVO.getUserRegister().getPhone();
			//添加审核记录表
			PcAuditInfo record = new PcAuditInfo(CompanyConstants.AuditType.CHANGE.toString(), pcAuditInfo.getAuditLevel(), auditPersion, pcAuditInfo.getAuditStatus(), date,
					companyId, pcAuditInfo.getAuditCase(), "", date, auditAccount);
			int line = pcAuditInfoMapper.insertSelective(record);
			//2：修改公司临时表状态：change_status:资质变更状态：0：审批失败 1：审批成功
			pcAuditTemporaryInfo.get(0).setChangeStatus(Short.valueOf(AuditStatus.AuditDecline.shortVal()));
			int addLine = pcAuditTemporaryInfoMapper.updateByExampleSelective(pcAuditTemporaryInfo.get(0), example);
			if(addLine <= 0 && line <= 0){
				return "审批失败";
			}
			return "审批成功";

		}
	}

	@Override
	public PcAuditTemporaryInfo findCompanyTemporaryInfo(String companyId) {
		PcAuditTemporaryInfo pcAuditTemporaryInfo = pcAuditTemporaryInfoMapper.findCompanyTemporaryInfo(companyId);
		return pcAuditTemporaryInfo;
	}

	/**
	 * 公司列表
	 * @param companyListSEO
	 * map.put("company_id","desc");排序形式
	 * @return
	 */
	@Override
	public PageInfo<CompanyListVo> list(CompanyListSEO companyListSEO) {
		UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();

		List<String> relationMap = null;
//		relationMap.add("10000000");
//		companyListSEO.setRelationMap(relationMap);

		//todo 获取分站id？？？？星级
		if(userVO != null){
			relationMap = new ArrayList<>();
			relationMap = userVO.getRelationMap();
			if(relationMap != null && relationMap.size() > 0){
				companyListSEO.setRelationMap(relationMap);
			}
		}

		if(StringUtils.isNotBlank(companyListSEO.getParam())){
			companyListSEO.setParam("%"+companyListSEO.getParam()+"%");
		}
		PageHelper.startPage(companyListSEO.getPage(),companyListSEO.getRows());
		List<CompanyListVo> companyListVoList = companyInfoMapper.list(companyListSEO);
		return new PageInfo<>(companyListVoList);
	}

	@Override
	public void downLoad(HttpServletResponse response, CompanyListSEO companyListSEO) {
		ExcelData data = new ExcelData();
		data.setName("用户信息数据");
		//添加表头
		String[] titleArrays = {"公司编号","公司类型","所属站点","公司名称",
				"入驻日期","截至时间","签约时间","法人","联系人","联系电话","保证金","状态"};
		List<String> titles = new ArrayList<>();
		for(String title: titleArrays){
			titles.add(title);
		}
		data.setTitles(titles);
		//添加列
		List<List<Object>> rows = new ArrayList<>();
		List<Object> row = null;
		List<CompanyListVo> companyListVoList = companyInfoMapper.downLoad(companyListSEO);

		for(CompanyListVo vo: companyListVoList){
			row=new ArrayList<>();
			row.add(vo.getCompanyId());
			row.add(vo.getRoleName());
//			row.add(vo.getComapnyNature());
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

        //2.更新表pc_company_financial
        int pcf = updateFinancial(companySubmitVo, date);

        //3.更新表company_info_expand
        int cie = updateCompanyExpand(companySubmitVo, date);

        if(ci > 0 && pcf > 0 && cie > 0){
            return true;
        }
        return false;
    }

    private int updateCompanyExpand(CompanySubmitVo companySubmitVo, Date date) {

        CompanyInfoExpand companyInfoExpand = companySubmitVo.getCompanyInfoExpand();
        companyInfoExpand.setUpdateTime(date);

        CompanyInfoExpandExample companyInfoExpandExample = new CompanyInfoExpandExample();
        companyInfoExpandExample.createCriteria()
				.andCompanyIdEqualTo(companySubmitVo.getCompanyInfo().getCompanyId());
        return companyInfoExpandMapper.updateByExampleSelective(companyInfoExpand,companyInfoExpandExample);
    }

    private int updateFinancial(CompanySubmitVo companySubmitVo, Date date) {

        PcCompanyFinancial pcCompanyFinancial = new PcCompanyFinancial();
		SpringBeanUtil.copy(companySubmitVo.getPcCompanyFinancial(),pcCompanyFinancial);
        pcCompanyFinancial.setCompanyId(companySubmitVo.getCompanyInfo().getCompanyId());
        pcCompanyFinancial.setUpdateTime(date);
        PcCompanyFinancialExample example = new PcCompanyFinancialExample();
        example.createCriteria().andCompanyIdEqualTo(companySubmitVo.getCompanyInfo().getCompanyId());
        return pcCompanyFinancialMapper.updateByExampleSelective(pcCompanyFinancial, example);
    }

    private int updateCompanyInfo(CompanySubmitVo companySubmitVo, Date date) {
        CompanyInfo companyInfo = companySubmitVo.getCompanyInfo();

        companyInfo.setPhone(companyInfo.getLegalPhone());
        companyInfo.setUpdateTime(date);
        //资质上传成功后审批状态改为资质待审核
        companyInfo.setAuditStatus(CompanyAuditStatus.AUDITING.stringVal());

        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.createCriteria().andCompanyIdEqualTo(companyInfo.getCompanyId());
        return companyInfoMapper.updateByExampleSelective(companyInfo,companyInfoExample);
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String,Object> auditContract(PcAuditInfoVO pcAuditInfo) {
		Date date = new Date();
		Map<String,Object> map = new HashMap<>();
		String companyId = pcAuditInfo.getCompanyId();
		if(StringUtils.isBlank(companyId)){
			map.put("code", false);
			map.put("msg", "公司编号不能为空");
			return map;
		}
		boolean applyFlag = false;
		//审核通过  运营审核通过生成合同编号
		if(AuditStatus.AuditPass.shortVal().equals(pcAuditInfo.getAuditStatus())){
			//判断公司类型是设计 或 装饰  或  设计装饰
			CompanyInfo con = companyInfoMapper.findByCompanyId(companyId);
			String roleLent []  = con.getRoleId().split(",");
			if(roleLent.length > 1) {
				//判断审核表中2级审核通过记录大于2条
				PcAuditInfoExample example = new PcAuditInfoExample();
				example.createCriteria().andAuditTypeEqualTo(CompanyConstants.AuditType.JOINON.stringVal()).andAuditStatusEqualTo(AuditStatus.AuditPass.shortVal()).
						andCompanyIdEqualTo(companyId).andAuditLevelEqualTo(CompanyConstants.auditLevel.JOINON.stringVal());
				List<PcAuditInfo> auditlist = pcAuditInfoMapper.selectByExample(example);
				if (auditlist.size() >= 2) {
					//1.修改公司表
					applyFlag = companyApplyService.updateStatus(companyId, CompanyAuditStatus.SUCCESSAUDIT.code.toString());
				}else{
                    applyFlag = companyApplyService.updateStatus(companyId, CompanyAuditStatus.AUDITING.code.toString());
                }
			}else{
                applyFlag = companyApplyService.updateStatus(companyId, CompanyAuditStatus.SUCCESSAUDIT.code.toString());
            }
			String contractNumber =ContractNum.getInstance().GenerateOrder(pcAuditInfo.getRoleId());
		//	String contractNumber = String.valueOf(UUID.randomUUID());
			int flag = 0;
			
			//2.修改合同表 0草稿 1待审批 2 审批通过 3 审批拒绝ContractStatus
				ContractInfo contractInfo = new ContractInfo();
				contractInfo.setRoleId(pcAuditInfo.getRoleId());
				contractInfo.setCompanyId(companyId);
				contractInfo.setContractNumber(contractNumber);
				contractInfo.setContractStatus(ContractStatus.DraftStatus.shortVal());
				contractInfo.setCreateTime(date);
				ContractInfoExample example = new ContractInfoExample();
				example.createCriteria().andCompanyIdEqualTo(companyId);
			    List<ContractInfo>	list = contractInfoMappers.selectByExample(example);
				if(list == null || list.size() == 0 ){
					
				  flag = contractInfoMappers.insertSelective(contractInfo);
				  
				}else {
					
					flag = 1;
				}
			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			String auditAccount = userVO ==null?"":userVO.getUserRegister().getPhone();
			//3.添加审核记录表
			PcAuditInfo record = new PcAuditInfo(pcAuditInfo.getAuditType(), CompanyConstants.auditLevel.JOINON.stringVal(), auditPersion, pcAuditInfo.getAuditStatus(), date,
					companyId, pcAuditInfo.getAuditCase(), contractNumber, date, auditAccount);
			
			int flagon = pcAuditInfoMapper.insertSelective(record);
		    
			if(flag > 0 && applyFlag &&  flagon  > 0 ){
				//todo 调取事件同步埃森哲
				eventService.publish(new CompanyJoin(companyId));
				map.put("code", true);
				map.put("msg", "审核成功");
				return map;
			}else{
				map.put("code", false);
				map.put("msg", "审核失败");
				return map;
			}
		}else{//审核失败
			applyFlag = companyApplyService.updateStatus(pcAuditInfo.getCompanyId(), CompanyAuditStatus.FAILAUDIT.code.toString());

			UserVO userVO = (UserVO) SessionUserDetailsUtil.getUserDetails();
			String auditPersion = userVO ==null?"":userVO.getUsername();
			String auditAccount = userVO ==null?"":userVO.getUserRegister().getPhone();
			//添加审核记录表
			PcAuditInfo record = new PcAuditInfo(pcAuditInfo.getAuditType(),  CompanyConstants.auditLevel.JOINON.stringVal(), auditPersion, pcAuditInfo.getAuditStatus(), date,
					companyId, pcAuditInfo.getAuditCase(), "",date , auditAccount);
		    int line = pcAuditInfoMapper.insertSelective(record);
		    if(applyFlag && line > 0){
				map.put("code", true);
				map.put("msg", "审核成功");
				return map;
			}else{
				map.put("code", false);
				map.put("msg", "审核失败");
				return map;
			}
		}
	}

    @Override
    public boolean signSuccess(String companyId, String contractNumber) {
	    boolean aLine = companyApplyService.updateStatus(companyId, CompanyAuditStatus.NOTPAYBAIL.stringVal());

		ContractInfo contractInfo = new ContractInfo();
		contractInfo.setCompanyId(companyId);
		contractInfo.setContractNumber(contractNumber);
		contractInfo.setContractStatus(ContractStatus.Waitdeposit.shortVal());
		ContractInfoExample example = new ContractInfoExample();
		example.createCriteria().andCompanyIdEqualTo(companyId).andContractNumberEqualTo(contractNumber);
		int line = contractInfoMappers.updateByExampleSelective(contractInfo,example);
		if(aLine && line > 0){
			return true;
		}
	    return false;
    }

	@Override
	public boolean isEdit(String companyId) {
		boolean flag = false;
		boolean aflag = false;
		CompanyInfoExample exampleC = new CompanyInfoExample();
		exampleC.createCriteria().andCompanyIdEqualTo(companyId);
		List<CompanyInfo>  companyInfos = companyInfoMapper.selectByExample(exampleC);
		PcAuditTemporaryInfoExample example = new PcAuditTemporaryInfoExample();
		example.createCriteria().andCompanyIdEqualTo(companyId);
		List<PcAuditTemporaryInfo> pcAuditTemporaryInfos = pcAuditTemporaryInfoMapper.selectByExample(example);
		//公司状态只有是入驻成功才可以编辑资质
		if(companyInfos.size() > 0){
			CompanyInfo companyInfo = companyInfos.get(0);
			if(CompanyAuditStatus.SUCCESSJOIN.stringVal().equals(companyInfo.getAuditStatus())){
				flag = true;
			}
		}
		//如果资质变更表没有信息或者审批状态是通过或者未通过都可以对资质进行编辑
		if(pcAuditTemporaryInfos.size() > 0){
			PcAuditTemporaryInfo pcAuditTemporaryInfo = pcAuditTemporaryInfos.get(0);
			if(!AuditStatus.AUDITING.shortVal().equals(pcAuditTemporaryInfo.getChangeStatus().toString())){
				aflag = true;
			}
		}else if(pcAuditTemporaryInfos.size() == 0){
			aflag = true;
		}

		if(flag && aflag){
			return true;
		}
		return false;
	}

	@Override
	public AuditInfoVO findTempAuditStatus(String companyId) {
		Map<String, String> map = new HashMap<>();
		map.put("companyId", companyId);
		map.put("auditType", CompanyConstants.AuditType.CHANGE.stringVal());
		AuditInfoVO auditInfoVO = pcAuditInfoMapper.findTempAuditStatus(map);
		if(auditInfoVO == null){
			auditInfoVO = new AuditInfoVO();
			auditInfoVO.setCompanyAuditType(CompanyAuditStatus.AUDITING.stringVal());
			auditInfoVO.setCompanyAuditName("资质审核中");
		}else{
			auditInfoVO.setCompanyAuditName(CompanyAuditStatus.getDesc(Integer.parseInt(auditInfoVO.getCompanyAuditType())));
		}
		return auditInfoVO;
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateByParam(String companyId, String platformType, String isDelete) {
        Date date = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("updateTime", date);
        map.put("companyId", companyId);
        if(StringUtils.isNotBlank(platformType)){
            map.put("platformType", Short.valueOf(platformType));
        }
        if(StringUtils.isNotBlank(isDelete)){
            map.put("isDelete", Short.valueOf(isDelete));
        }
        int line = companyInfoMapper.updateByParam(map);
        return line;
    }
}
