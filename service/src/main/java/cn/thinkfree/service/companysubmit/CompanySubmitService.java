package cn.thinkfree.service.companysubmit;

import java.util.Map;

import cn.thinkfree.database.vo.CompanyListSEO;
import cn.thinkfree.database.vo.CompanyListVo;
import cn.thinkfree.database.vo.CompanySubmitVo;
import com.github.pagehelper.PageInfo;

/**
 * @author ying007
 * 公司入驻业务
 */
public interface CompanySubmitService {
    /**
     * 公司资质上传是否成功
     * @param companySubmitVo 公司资质
     * @return true false
     */
    boolean upCompanyInfo(CompanySubmitVo companySubmitVo);
    
    
    /**
     * 运营审批
     * @author lvqidong
     * 
     */
    
    Map<String,String>  auditContract(String companyId,String auditStatus,String auditCase);

    /**
     * 公司列表
     * @param companyListSEO
     * @return
     */
    PageInfo<CompanyListVo> list(CompanyListSEO companyListSEO);
}
