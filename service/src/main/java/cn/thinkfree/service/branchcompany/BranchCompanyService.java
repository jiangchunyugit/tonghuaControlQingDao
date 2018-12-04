package cn.thinkfree.service.branchcompany;

import cn.thinkfree.database.model.BranchCompany;
import cn.thinkfree.database.model.CompanyInfo;
import cn.thinkfree.database.model.HrOrganizationEntity;
import cn.thinkfree.database.vo.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jiangchunyu(后台)
 * @date 2018
 * @Description 分公司（省分站）接口
 */
public interface BranchCompanyService {

    /**
     * 校验重复信息
     * @param branchCompanyVO
     * @return
     */
    boolean checkRepeat(BranchCompanyVO branchCompanyVO);

    /**
     * 埃森哲分公司
     * @return
     */
    List<HrOrganizationEntity> ebsBranchCompanylist();
    /**
     * 添加分公司
     * @param branchCompanyVO
     * @return
     */
    boolean addBranchCompany(BranchCompanyVO branchCompanyVO);

    /**
     * 修改分公司信息
     * @param branchCompanyVO
     * @return
     */
    boolean updateBranchCompany(BranchCompanyVO branchCompanyVO);

    /**
     * 启用禁用删除分公司信息
     * @param branchCompany
     * @return
     */
    boolean enableBranchCompany(BranchCompany branchCompany);

    /**
     * 查询分公司信息(分页)
     * @param branchCompanySEO
     * @return
     */
    PageInfo<BranchCompanyVO> branchCompanyList(BranchCompanySEO branchCompanySEO);

    /**
     * 根据分公司id查询公司详情(带城市分站)
     * @param id
     * @return
     */
    BranchCompanyVO branchCompanyDetails(Integer id);

    /**
     * 分公司list（不带城市分站）
     * @return
     * @param flag
     * @return
     */
    List<BranchCompany> branchCompanies(Integer flag);

    /**
     * 城市分站创建时。分公司数据
     * @return
     */
    List<BranchCompanyVO> addCitybranchCompany();

    /**
     * 分公司和其所属城市分站信息
     * @return
     */
    List<CompanyRelationVO> companyRelationList();

    /**
     * 权限站点信息
     * @return
     */
    SiteInfo getSiteInfo();

    /**
     * 通过省份编码查询分公司信息（过滤入驻权限）
     * @return
     */
    List<BranchCompany> getBranchCompanyByIdList();

    /**
     * 根据用户查询用户组织架构
     * @return
     * @param userId
     * @return
     */
    List<CompanyInfo> getCompanyOrganizationByUser(String userId);

    /**
     * 根据入驻公司名称获取组织架构
     * @param companyId
     * @return
     */
    EnterCompanyOrganizationVO getCompanyOrganizationByCompanyId(String companyId);
}
