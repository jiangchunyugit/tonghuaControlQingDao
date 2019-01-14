package cn.thinkfree.service.companysubmit;

import cn.thinkfree.database.model.DealerBrandInfo;
import cn.thinkfree.database.model.PcAuditInfo;
import cn.thinkfree.database.vo.*;

import java.util.List;
import java.util.Map;


/**
 * 经销商接口
 */
public interface DealerBrandService {

    /**
     * 添加经销商品牌
     * @param dealerBrandInfoVO
     * @return
     */
    Map<String, Object> saveBrand(DealerBrandInfoVO dealerBrandInfoVO);

    /**
     * 经销商品牌审核回显
     * @param brandDetailVO
     * @return
     */
    List<AuditBrandInfoVO> showBrandDetail(BrandDetailVO brandDetailVO);

    /**
     * 经销商品牌审核回显品牌品类条目
     * @param companyId
     * @param agencyCode
     * @return
     */
    List<BrandItemsVO> showBrandItems(String companyId, String agencyCode);

    /**
     * 品牌审批
     * @param pcAuditInfoVO
     * @return
     */
    Map<String,Object> auditBrand(PcAuditInfoVO pcAuditInfoVO);

    /**
     * 品牌变更
     * @param dealerBrandInfoVO
     * @return
     */
    Map<String,Object> updateBrand(DealerBrandInfoVO dealerBrandInfoVO);

    /**
     * 审批变更品牌
     * @param pcAuditInfoVO
     * @return
     */
    Map<String,Object> auditChangeBrand(PcAuditInfoVO pcAuditInfoVO);

    /**
     * 显示已经签约的品牌
     * @param companyId
     * @return
     */
    List<DealerBrandInfo> showSignBrand(String companyId);

    /**
     * 品牌编辑
     * @param dealerBrandInfoVO
     * @return
     */
    Map<String, Object> editBrand(DealerBrandInfoVO dealerBrandInfoVO);

    /**
     * 查询已申请品牌信息
     * @return
     */
//    List<AuditBrandInfoVO> applyBrandDetail(BrandDetailVO brandDetailVO);

    /**
     * 是否可以变更
     * @param companyId
     * @param agencyCode
     * @param brandNo
     * @return
     */
    Map<String,Object> isSignChange(String companyId, String agencyCode, String brandNo);

    /**
     *入驻公司申请品牌的审批信息
     * @param brandId
     * @return
     */
    List<PcAuditInfo> findAuditList(String brandId, String companyId);

}
