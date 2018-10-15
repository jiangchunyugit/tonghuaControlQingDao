package cn.thinkfree.service.contractTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.StringUtil;
import com.mysql.fabric.xmlrpc.base.Data;

import cn.thinkfree.core.bundle.MyRequBundle;
import cn.thinkfree.core.utils.WebFileUtil;
import cn.thinkfree.database.mapper.PcContractTemplateCategoryMapper;
import cn.thinkfree.database.mapper.PcContractTemplateDictMapper;
import cn.thinkfree.database.mapper.PcContractTemplateMapper;
import cn.thinkfree.database.model.PcContractTemplate;
import cn.thinkfree.database.model.PcContractTemplateCategory;
import cn.thinkfree.database.model.PcContractTemplateDict;
import cn.thinkfree.database.model.PcContractTemplateDictExample;
import cn.thinkfree.database.vo.MyContractTemplateDetails;

@Service
public class ContractInfoTemplateServiceImpl implements ContractTemplateService {

	
	@Autowired
    PcContractTemplateMapper pcContractTemplateMapper;
	
	@Autowired
	PcContractTemplateCategoryMapper pcContractTemplateCategoryMapper;
	
	@Autowired
	PcContractTemplateDictMapper pcContractTemplateDictMapper;
	
	@Override
	public List<PcContractTemplate> PcContractTemplateList(String type) {
		return pcContractTemplateMapper.queryListByType(type);
	}

	
	@Override
	public Map<String, String> getTemplateCategoryList(String type) {
		Map<String,String> map = new HashMap<>();
		PcContractTemplateCategory example = new  PcContractTemplateCategory();
		example.setCompanyType(type);
		List<PcContractTemplateCategory> list = pcContractTemplateCategoryMapper.selectPcContractTemplateCategoryByType(example);
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getCategoryCode(),list.get(i).getCategoryName());
		}
		return map;
	}

	
	
	@Override
	public Map<String, String> insertInfoContractTemplate(PcContractTemplate pcContractTemplate) {
		
		return null;
	}

	@Override
	public MyContractTemplateDetails getMyContractTemplateDetailsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public Map<String, String> insertdict(String CategoryId, Map<String, String> map) {
		Map<String, String> resMap = new HashMap<>();
		if(StringUtil.isEmpty(CategoryId)){
			resMap.put("code", "1");
			resMap.put("msg", "分类CategoryId is null");
			return resMap;
		}
		
		for (int i = 0; i < map.size(); i++) {
			PcContractTemplateDict record = new PcContractTemplateDict();
			record.setCategoryCode(CategoryId);
			Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator(); 
			while (entries.hasNext()) { 
			  Map.Entry<String, String> entry = entries.next(); 
			  record.setCode(entry.getKey());
			  record.setName(entry.getValue());
			  pcContractTemplateDictMapper.insertSelective(record);
			}
			
		}
		resMap.put("code", "0");
		resMap.put("msg", "添加数据成功");
		return resMap;
	}


	@Override
	public Map<String, String> updateContractTemplateStatus(String type,String stauts) {
		Map<String, String> resMap = new HashMap<>();
		if(StringUtil.isEmpty(type)){
			resMap.put("code", "1");
			resMap.put("msg", "type is null");
			return resMap;
		}
		if(StringUtil.isEmpty(stauts)){
			resMap.put("code", "1");
			resMap.put("msg", "stauts is null");
			return resMap;
		}
		PcContractTemplate tl = new PcContractTemplate();
		tl.setContractStatus(stauts);
		tl.setContractTpType(type);
		int  flag = pcContractTemplateMapper.updatePcContractTemplateStatus(tl);
		if(flag > 0){
			resMap.put("code", "1");
			resMap.put("msg", "操作成功");
		}
		return resMap;
	}


	@Override
	public Map<String, String> updateContractTemplateInfo(String type,String contractTpName, String contractTpRemark, MultipartFile file) {
		//生成pdf 返回url 
		String url = WebFileUtil.fileCopy("static/contractTemplate/", file);//上传合同模板
		
		Map<String, String> map = new HashMap<>();
		
		PcContractTemplate con = new PcContractTemplate();
		
		con.setContractTpName(contractTpName);
		
		con.setContractStatus("0");
		
		con.setContractTpRemark(contractTpRemark);
		
		con.setUpdateTime(new Date());
		
		return map;
	}


	@Override
	public String getTemplatePdfUrl(String type) {
		// TODO Auto-generated method stub
		return pcContractTemplateMapper.queryListByType(type).get(0).getPdfUrl();
	}


	@Override
	public Map<String, String> queryContractDic(String type) {
		PcContractTemplateDictExample example = new PcContractTemplateDictExample();
		if (type.equals("0")) {
			example.createCriteria().andTypeEqualTo(type);
		} else if (type.equals("1")) {
			example.createCriteria().andTypeEqualTo(type);
		}

		List<PcContractTemplateDict> list = pcContractTemplateDictMapper.selectByExample(example);
		Map<String,String> resMap = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			resMap.put(list.get(i).getCode(), list.get(i).getName());
		}
		return resMap;
	}

	
	
   
}
