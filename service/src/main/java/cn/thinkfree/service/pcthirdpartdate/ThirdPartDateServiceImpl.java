package cn.thinkfree.service.pcthirdpartdate;

import cn.thinkfree.core.logger.AbsLogPrinter;
import cn.thinkfree.database.mapper.*;
import cn.thinkfree.database.model.*;
import cn.thinkfree.database.vo.MarginContractVO;
import cn.thinkfree.database.vo.remote.SyncOrderVO;
import cn.thinkfree.service.constants.CompanyConstants;
import cn.thinkfree.service.newscheduling.NewSchedulingService;
import cn.thinkfree.service.utils.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jiangchunyu(后台)
 * @date 20181109
 * @Description 第三方数据接口
 */
@Service
public class ThirdPartDateServiceImpl extends AbsLogPrinter implements ThirdPartDateService {

    @Autowired
    ContractInfoMapper contractInfoMapper;

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Autowired
    PcAuditInfoMapper pcAuditInfoMapper;

    @Value("${optionType}")
    private String type;

    @Autowired
    OrderContractMapper orderContractMapper;

    @Autowired
    ContractTermsMapper contractTermsMapper;

    @Autowired
    ConstructionOrderMapper  construtionOrderMapper;

    @Autowired
    DesignerOrderMapper designerOrderMapper;

    @Autowired
    NewSchedulingService newSchedulingService;

    @Autowired
	ContractTermsChildMapper contractTermsChildMapper;




    @Override
    public MarginContractVO getMarginContract(String contractNumber,String signedTime) {


        MarginContractVO marginContractVO = new MarginContractVO();
        ContractInfoExample contractInfoExample = new ContractInfoExample();
        contractInfoExample.createCriteria().andContractNumberEqualTo(contractNumber);
        List<ContractInfo> contractInfos = contractInfoMapper.selectByExample(contractInfoExample);

        if (contractInfos.size() > 0) {

            // 合同信息
            ContractInfo contractInfo = contractInfos.get(0);
            marginContractVO.setOptionType(type);
            marginContractVO.setContractNumber(contractInfo.getContractNumber());
            marginContractVO.setTransactionDate(String.valueOf(contractInfo.getSignedTime()));
            marginContractVO.setVendorId(contractInfo.getCompanyId());

            // 公司信息
            if (StringUtils.isNotBlank(contractInfo.getCompanyId())) {

//                CompanyInfoExample companyInfoExample = new CompanyInfoExample();
//                companyInfoExample.createCriteria().andCompanyIdEqualTo(contractInfo.getCompanyId());
                CompanyInfo companyInfo = companyInfoMapper.selectByCompanyId(contractInfo.getCompanyId());

                if (companyInfo != null) {
                    marginContractVO.setOperatingUnit(companyInfo.getSiteCompanyId());
                    marginContractVO.setVendorName(companyInfo.getCompanyName());
                }
            }

            // 审批人信息
            PcAuditInfoExample pcAuditInfoExample = new PcAuditInfoExample();
            pcAuditInfoExample.createCriteria().andContractNumberEqualTo(contractNumber);
            List<PcAuditInfo> pcAuditInfos = pcAuditInfoMapper.selectByExample(pcAuditInfoExample);
            if (pcAuditInfos.size() > 0) {

                PcAuditInfo pcAuditInfo = pcAuditInfos.get(0);
                marginContractVO.setOperationPerson(pcAuditInfo.getAuditPersion());
            }

            return marginContractVO;
        }
        return null;
    }
    
    
    

	@Override
	public List<SyncOrderVO> getOrderContract(String orderNumber) {

		List<SyncOrderVO> listVo = new ArrayList<>();
		OrderContractExample contractInfoExample = new OrderContractExample();
		contractInfoExample.createCriteria().andOrderNumberEqualTo(orderNumber);
		List<OrderContract> contractInfos = orderContractMapper.selectByExample(contractInfoExample);
		if (contractInfos != null && contractInfos.size() == 1) {

			OrderContract contract = contractInfos.get(0);

			CompanyInfo companyInfo = companyInfoMapper.findByCompanyId(contract.getCompanyId());

			if (contract != null) {
				// 初始化合同详情
				ContractTermsExample terms = new ContractTermsExample();
				terms.createCriteria().andCompanyIdEqualTo(contract.getCompanyId())
						.andContractNumberEqualTo(contract.getContractNumber());
				List<ContractTerms> listTerms = contractTermsMapper.selectByExample(terms);
				Map<String, String> resMap = new HashMap<>();
				for (int i = 0; i < listTerms.size(); i++) {
					resMap.put(listTerms.get(i).getContractDictCode(), listTerms.get(i).getContractValue());
				}
				// 判断当前合同类型 02设计合同_to_c 03施工合同_to_c
				if (contract.getContractType().equals("02")) {
					// 设计合同数据拼接
					designData(orderNumber, listVo, contract, companyInfo, resMap);

				} else {
					// 施工订单
					roadWorkData(orderNumber, listVo, contract, companyInfo, resMap);
				}
			}

		} else {
			printInfoMes("调用订单合同发生错误 ", "contractInfos is null or contractInfos.size() > 0 {}",
					contractInfos.toString());
			return null;

		}

		return listVo;
	}

   /**
    * 
    * 施工合同数据
    * @param orderNumber
    * @param listVo
    * @param contract
    * @param companyInfo
    * @param resMap
    */
	private void roadWorkData(String orderNumber, List<SyncOrderVO> listVo, OrderContract contract,
			CompanyInfo companyInfo, Map<String, String> resMap) {
		ConstructionOrderExample example = new ConstructionOrderExample();
		  example.createCriteria().andOrderNoEqualTo(orderNumber);
		  List<ConstructionOrder> conorder =  construtionOrderMapper.selectByExample(example);
		//分期 根据分期json循环数据  [{'sortNumber':'0','name':'设计3d方案','ratio': '30','costValue': '200000'},{'sortNumber': '1','name':'设计3d方案2','ratio': '40','costValue': '2222222222'}]
		 // String jsonSr = "[{'sortNumber':'0','name':'设计3d方案','ratio': '30','costValue': '200000'},{'sortNumber': '1','name':'设计3d方案2','ratio': '40','costValue': '2222222222'}]";
		  String jsonSr = resMap.get("c08");
		  if(!StringUtils.isEmpty(jsonSr)){
				  JSONArray jsonArray=JSONArray.parseArray(jsonSr);
			  //排序
			  jsonArray.sort(Comparator.comparing(obj -> ((JSONObject) obj).getShort("stageCode")));
				  for (int i = 0; i < jsonArray.size(); i++) {
					  SyncOrderVO vo = new SyncOrderVO();
					  //合同金额 全款
					  @SuppressWarnings("unchecked")
					  Map<String,String> jsonMap = (Map<String, String>) jsonArray.get(i);
					  vo.setActualAmount(jsonMap.get("payMoney"));//支付金额
					  vo.setCompanyId(contract.getCompanyId());
					  //公司名称
					  vo.setCompanyName(companyInfo==null?"系统数据错误":companyInfo.getCompanyName());
					  //支付名称jsonMap.get("progressName")
					  vo.setTypeSub("200"+(i+1)+"");
					  //是否全额支付
					  vo.setContractType("2");
					  //业主名称
					  vo.setConsumerName(resMap.get("c03"));
					  //合同开始时间
					  vo.setStartTime("");
					  //合同结束时间
					  vo.setEndTime("");
					  //订单编号
					  vo.setFromOrderid(orderNumber);
					  //是否全额支付

					  if (i == jsonArray.size() - 1) {
						  vo.setIsEnd("2");
					  } else if (jsonMap.get("stageCode").equals("-1")) {//施工订单为-1的是首款
						  vo.setIsEnd("1");
					  } else {
						  vo.setIsEnd("0");
					  }
					  //合同类型 订单类型：设计1、施工2、合同3
					  vo.setType("2");

					  vo.setProjectAddr(resMap.get("c12"));
					  //项目编号
					  vo.setProjectNo(conorder ==null?"":conorder.get(0).getProjectNo());
					  //签约时间
					  vo.setSignedTime(DateUtil.formartDate(contract.getSignTime(), "yyyy-MM-dd"));
					  //是否个性化
					  vo.setStyleType(conorder ==null?"":conorder.get(0).getType());

					  vo.setSort(jsonMap.get("stageCode"));
					  //阶段名称
					  vo.setTypeSubName(jsonMap.get("progressName"));
		              listVo.add(vo);
				  }
		 
	      } 
		else
		{
			  printInfoMes("调用订单合同发生错误 ","contractInfos is null or contractInfos.size() > 0 {}",jsonSr.toString());
		 }
		  
	}

	
	/**
	 * 
	 * 设计订单拼接数据
	 * @param orderNumber
	 * @param listVo
	 * @param contract
	 * @param companyInfo
	 * @param resMap
	 */
	private void designData(String orderNumber, List<SyncOrderVO> listVo, OrderContract contract,
							CompanyInfo companyInfo, Map<String, String> resMap) {
		//查询设计订单项目信息
		DesignerOrderExample example = new DesignerOrderExample();
		example.createCriteria().andOrderNoEqualTo(orderNumber);
		List<DesignerOrder> designerOrders = designerOrderMapper.selectByExample(example);
		//设计判断是分期 换是全款
		String cType = String.valueOf(resMap.get("c18"));
		printInfoMes("分期类型｛｝" + cType);
		//全款
		if (cType.equals("0")) {
			SyncOrderVO vo = new SyncOrderVO();
			//合同金额 全款
			BigDecimal amount = new BigDecimal(String.valueOf(resMap.get("c19")));
			amount = amount.setScale(2, RoundingMode.HALF_UP);
			vo.setActualAmount(String.valueOf(amount));
			vo.setCompanyId(contract.getCompanyId());
			//公司名称
			vo.setCompanyName(companyInfo == null ? "系统数据错误" : companyInfo.getCompanyName());
			//支付名称
			vo.setTypeSub("1001");
			//是否全额支付
			vo.setContractType("1");
			//业主名称
			vo.setConsumerName(resMap.get("c03"));
			//合同开始时间
			vo.setStartTime("");
			//合同结束时间
			vo.setEndTime("");
			//订单编号
			vo.setFromOrderid(orderNumber);
			vo.setIsEnd("1");
			//合同类型 订单类型：设计1、施工2、合同3
			vo.setType("1");
			//项目地址
			vo.setProjectAddr(resMap.get("c08") + resMap.get("c09") + resMap.get("c10") + resMap.get("c11"));
			//项目编号
			vo.setProjectNo(designerOrders.get(0) == null ? "" : designerOrders.get(0).getProjectNo());
			//签约时间
			vo.setSignedTime(DateUtil.formartDate(contract.getSignTime(), "yyyy-MM-dd"));
			//是否个性化
			vo.setStyleType(designerOrders.get(0) == null ? "" : designerOrders.get(0).getStyleType());
			vo.setSort("");
			vo.setTypeSubName("设计费总额");
			vo.setCompanyAddrNo(companyInfo.getId()+"");
			listVo.add(vo);
		} else {
			//分期 根据分期json循环数据  [{'sortNumber':'0','name':'设计3d方案','ratio': '30','costValue': '200000'},{'sortNumber': '1','name':'设计3d方案2','ratio': '40','costValue': '2222222222'}]
			String jsonSr = resMap.get("c20");
			printInfoMes("分期json 数据｛｝" + jsonSr);
			if (!StringUtils.isEmpty(jsonSr)) {
				JSONArray jsonArray = JSONArray.parseArray(jsonSr);
				for (int i = 0; i < jsonArray.size(); i++) {
					SyncOrderVO vo = new SyncOrderVO();
					//合同金额 全款
					@SuppressWarnings("unchecked")
					Map<String, String> jsonMap = (Map<String, String>) jsonArray.get(i);
					printInfoMes("分期金额" + jsonMap.get("costValue"));
					//vo.setActualAmount(jsonMap.get("costValue"));
					BigDecimal amount = new BigDecimal(String.valueOf(jsonMap.get("costValue")) == "" ? "0" : String.valueOf(jsonMap.get("costValue")));
					amount = amount.setScale(2, RoundingMode.HALF_UP);
					vo.setActualAmount(String.valueOf(amount));
					vo.setCompanyId(contract.getCompanyId());
					//公司名称
					vo.setCompanyName(companyInfo == null ? "系统数据错误" : companyInfo.getCompanyName());
					//支付名称
					vo.setTypeSub("100" + (i + 1) + "");
					//是否全额支付
					vo.setContractType("2");
					//业主名称
					vo.setConsumerName(resMap.get("c03"));
					//合同开始时间
					vo.setStartTime("");
					//合同结束时间
					vo.setEndTime("");
					//订单编号
					vo.setFromOrderid(orderNumber);
					vo.setFromContractId(contract.getContractNumber());

					//是否全额支付
					if (i == 0) {
						vo.setIsEnd("1");
						vo.setTypeSubName("首期");
					} else if (i == jsonArray.size() - 1) {
						vo.setIsEnd("2");
						vo.setTypeSubName("尾期");
					} else {
						vo.setIsEnd("0");
						vo.setTypeSubName("中期");
					}
					//合同类型 订单类型：设计1、施工2、合同3
					vo.setType("1");

					vo.setProjectAddr(resMap.get("c08") + resMap.get("c09") + resMap.get("c10") + resMap.get("c11"));
					//项目编号
					vo.setProjectNo(designerOrders == null ? "" : designerOrders.get(0).getProjectNo());
					//签约时间
					vo.setSignedTime(DateUtil.formartDate(contract.getSignTime(), "yyyy-MM-dd"));
					//是否个性化
					vo.setStyleType(designerOrders == null ? "" : designerOrders.get(0).getStyleType());

					vo.setSort(String.valueOf(jsonMap.get("sortNumber")));
					//阶段名称

					vo.setCompanyAddrNo(companyInfo.getId()+"");

					printInfoMes("json vo 数据｛｝" + vo);
					listVo.add(vo);
				}
			} else {
				printInfoMes("调用订单合同发生错误 ", "contractInfos is null or contractInfos.size() > 0 {}", jsonSr.toString());
			}
		}
	}

	

	@Override
	public List<SyncOrderVO> getOrderContractToB(String contractNumber) {
		List<SyncOrderVO> listVo = new ArrayList<>();
		//根据合同编号 查询 入住合同
        ContractInfoExample contractInfoExample = new ContractInfoExample();
        contractInfoExample.createCriteria().andContractNumberEqualTo(contractNumber);
		List<ContractInfo> contractInfo = contractInfoMapper.selectByExample(contractInfoExample);
		if (contractInfo.size() > 0) {
			ContractInfo contract = contractInfo.get(0);
        	CompanyInfo companyInfo = companyInfoMapper.findByCompanyId(contract.getCompanyId());
        	//合同信息
        	ContractTermsExample contractTermsExample = new ContractTermsExample();
			contractTermsExample.createCriteria()
			.andCompanyIdEqualTo(companyInfo.getCompanyId()).andContractNumberEqualTo(contractNumber);
			 List<ContractTerms> list = contractTermsMapper.selectByExample( contractTermsExample );
		    Map<String,String> resMap = new HashMap<>();
		    if(list != null){
			    for (int i = 0; i < list.size(); i++) {
			    	resMap.put(list.get(i).getContractDictCode(), list.get(i).getContractValue());
			    }
			}
        	/*保证金分期*/
    		ContractTermsChildExample example = new ContractTermsChildExample();
    		example.createCriteria().
    		andCompanyIdEqualTo((companyInfo.getCompanyId())).
    		andContractNumberEqualTo(contractNumber).andCostTypeEqualTo("13");
    		example.setOrderByClause(" c_type asc");
    		List<ContractTermsChild> childList = contractTermsChildMapper.selectByExample(example);
    		if(childList == null || childList.size() > 2){
    			throw new RuntimeException("入住合同"+contractNumber+"{}设置保证金金额数据错误");
    		}
    		List<ContractTermsChild> filterList = childList.stream().filter(child -> child.getcType().equals("1") ).collect(Collectors.toList());
    		printInfoMes("合同保证设置 一次交费记录为｛｝",filterList.size());
			//如果全部代扣不送数据
    		if(filterList != null && filterList.size() > 0){
    			
	        	if(companyInfo.getRoleId().equals(CompanyConstants.RoleType.SJ.code)){
	        		//设计
					designDataToB(contractNumber, listVo, contract, companyInfo, resMap, childList);
	        		  
	        	}else{
	        		//施工
					roadWorkDataToB(contractNumber, listVo, contract, companyInfo, resMap, childList);
	        	}
    		}
        }
		return listVo;
	}



	/***
	 * 施工合同数据
	 * @param contractNumber
	 * @param listVo
	 * @param contract
	 * @param companyInfo
	 * @param resMap
	 * @param childList
	 */
	private void roadWorkDataToB(String contractNumber, List<SyncOrderVO> listVo, ContractInfo contract,
			CompanyInfo companyInfo, Map<String, String> resMap, List<ContractTermsChild> childList) {
		//施工
			
			 SyncOrderVO vo = new SyncOrderVO();
			  //获取支付比例
			   String firstMoney = "0";
			   //按条件过滤
		       List<ContractTermsChild> filterList = childList.stream().filter(child -> child.getcType().equals("1") ).collect(Collectors.toList());
		       if(filterList !=null && filterList.size() > 0){
		    	   firstMoney = filterList.get(0).getCostValue();
		       }
			  //合同金额 全款
			  if(childList.size() == 0  ){
				  // vo.setActualAmount(String.valueOf(resMap.get("c17")));
				  BigDecimal amount = new BigDecimal(String.valueOf(resMap.get("c17")) == "" ? "0" : String.valueOf(resMap.get("c17")));
				  amount = amount.setScale(2, RoundingMode.HALF_UP);
				  vo.setActualAmount(String.valueOf(amount));
			  }else{
				  BigDecimal amount = new BigDecimal(firstMoney);
				  amount = amount.setScale(2, RoundingMode.HALF_UP);
				  vo.setActualAmount(String.valueOf(amount));
			  }
			  //
			  vo.setCompanyId(contract.getCompanyId());
			  //公司名称
			  vo.setCompanyName(companyInfo==null?"系统数据错误":companyInfo.getCompanyName());
			  //支付名称
			  vo.setTypeSub("8001");
				//合同類型
			  vo.setContractType("1");
			  vo.setIsEnd("2");
					  //业主名称
			  vo.setConsumerName(companyInfo.getLegalName());//法人名称
			  //合同开始时间 
			  vo.setStartTime(String.valueOf(resMap.get("c08")));
			  //合同结束时间
			  vo.setEndTime(String.valueOf(resMap.get("c09")));
			  //订单编号
				//订单编号
		      vo.setFromOrderid("");
				//合同编号
		      vo.setFromContractId(contractNumber);
			 
			  //合同类型 订单类型：设计1、施工2、合同3
			  vo.setType("8");
			  //项目地址
			  vo.setProjectAddr("");
			  //项目编号
			  vo.setProjectNo("");
			  //签约时间
			  vo.setSignedTime(contract.getSignedTime()==null?"":DateUtil.formartDate(contract.getSignedTime(), "yyyy-MM-dd"));
			  //是否个性化
			  vo.setStyleType("");
			  
			  vo.setSort("");
		vo.setTypeSubName("保证金");
		     listVo.add(vo);
	}



	/**
	 * 
	 * TOB设计合同数据
	 * @param contractNumber
	 * @param listVo
	 * @param contract
	 * @param companyInfo
	 * @param resMap
	 * @param childList
	 */

	private void designDataToB(String contractNumber, List<SyncOrderVO> listVo, ContractInfo contract,
			CompanyInfo companyInfo, Map<String, String> resMap, List<ContractTermsChild> childList) {
		SyncOrderVO vo = new SyncOrderVO();
		
		  //获取支付比例
		   String firstMoney = "0";
		   //按条件过滤
	       List<ContractTermsChild> filterList = childList.stream().filter(child -> child.getcType().equals("1") ).collect(Collectors.toList());
	       if(filterList !=null && filterList.size() > 0){
	    	   firstMoney = filterList.get(0).getCostValue();
	       }
		  //合同金额 全款
		  if(childList.size() == 0  ){
			  BigDecimal amount = new BigDecimal(String.valueOf(resMap.get("c15")) == "" ? "0" : String.valueOf(resMap.get("c15")));
			  amount = amount.setScale(2, RoundingMode.HALF_UP);
			  vo.setActualAmount(String.valueOf(amount));
			  // vo.setActualAmount(String.valueOf(resMap.get("c15")));
		  }else{
			  BigDecimal amount = new BigDecimal(firstMoney);
			  amount = amount.setScale(2, RoundingMode.HALF_UP);
			  vo.setActualAmount(String.valueOf(amount));
		  }
		  //
		  vo.setCompanyId(contract.getCompanyId());
		  //公司名称
		  vo.setCompanyName(companyInfo==null?"系统数据错误":companyInfo.getCompanyName());
		  //支付名称
		  vo.setTypeSub("7001");
		  //是否全额支付 ：1全款，2分期

		  vo.setContractType("1");
		  //业主名称
		  vo.setConsumerName(companyInfo.getLegalName());//法人名称
		  //合同开始时间 
		  vo.setStartTime(String.valueOf(resMap.get("c03")));
		  //合同结束时间
		  vo.setEndTime(String.valueOf(resMap.get("c04")));
		  //订单编号
		  vo.setFromOrderid("");
          //合同编号
		  vo.setFromContractId(contractNumber);
		  //是否全额支付
		  vo.setIsEnd("1");
		  //合同类型 订单类型：设计1、施工2、合同3
		  vo.setType("7");
		  //项目地址
		  vo.setProjectAddr("");
		  //项目编号
		  vo.setProjectNo("");
		  //签约时间
		  vo.setSignedTime(contract.getSignedTime()==null?"":DateUtil.formartDate(contract.getSignedTime(), "yyyy-MM-dd"));
		  //是否个性化
		  vo.setStyleType("");
		  
		  vo.setSort("");
		  vo.setCompanyAddrNo(companyInfo.getId()+"");
		  vo.setTypeSubName("保证金");
		  listVo.add(vo);
	}
	

    
    
    
}
