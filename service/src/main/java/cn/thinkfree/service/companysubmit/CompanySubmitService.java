package cn.thinkfree.service.companysubmit;

import java.util.List;
import java.util.Map;

import cn.thinkfree.database.model.PcAuditInfo;
import cn.thinkfree.database.model.PcAuditTemporaryInfo;
import cn.thinkfree.database.vo.*;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ying007
 * 公司入驻业务
 */
public interface CompanySubmitService {

    /**
     * 查询资质变更审批信息
     * @param companyId
     * @return
     */
    PcAuditInfo findTempAudit(String companyId);

    /**
     * 查询审批不通过的原因
     * @param companyId
     * @return
     */
    PcAuditInfo findAuditCase(String companyId);

    /**
     * 审批详情查询
     * @param companyId
     * @return
     */
    AuditInfoVO findAuditStatus(String companyId);

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

    Map<String,Object>  auditContract(PcAuditInfoVO pcAuditInfo);

    /**
     * 公司列表
     * @param companyListSEO
     * @return
     */
    PageInfo<CompanyListVo> list(CompanyListSEO companyListSEO);

    /**
     * 列表导出
     * @param companyListSEO
     */
    void downLoad(HttpServletResponse response, CompanyListSEO companyListSEO);

    /**
     * 入驻公司资质变更回显
     * @param companyId
     * @return
     */
    CompanySubmitVo findCompanyInfo(String companyId);

    /**
     * 入驻公司资质变更更新
     * @param companyTemporaryVo
     * @return
     */
    boolean changeCompanyInfo(CompanyTemporaryVo companyTemporaryVo);

    /**
     * 入驻公司资质变更审批
     * @param auditInfoVO
     * @return
     */
    String auditChangeCompany(PcAuditInfoVO auditInfoVO);

    /**
     * 入驻公司资质变更审批回显。注：申请列表的申请事项如果是资质变更，则使用此接口
     * @param companyId
     * @return
     */
    PcAuditTemporaryInfo findCompanyTemporaryInfo(String companyId);

    /**
     * 公司详情
     * @param contractNumber
     * @param companyId
     * @return
     */
    CompanyDetailsVO companyDetails(String contractNumber,String companyId, String auditType ,String applyDate);

    /**
     * 签约完成
     * @param companyId
     * @return
     */
    boolean signSuccess(String companyId, String contractNumber);

    /**
     * 是否可以编辑
     * @param companyId
     * @return
     */
    boolean isEdit(String companyId);

    /**
     * 入驻公司资质变更查询审批状态
     * @param companyId
     * @return
     */
    AuditInfoVO findTempAuditStatus(String companyId);

    /**
     * 下架，冻结，删除
     * @param companyId
     * @param platformType
     * @param isDelete
     * @return
     */
    Integer updateByParam(String companyId,String platformType,String isDelete);

    /**
     * 运营平台资质变更
     * @param companySubmitVo
     * @return
     */
    Map<String, Object> updateCompanyInfo(CompanySubmitVo companySubmitVo);

    /**
     * 公司经销商查询list
     * @param companyListSEO
     * @return
     */
    PageInfo<CompanyListVo> agencyList(CompanyListSEO companyListSEO);

}
