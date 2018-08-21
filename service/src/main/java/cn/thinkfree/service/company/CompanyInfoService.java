package cn.thinkfree.service.company;

import cn.thinkfree.database.model.CompanyInfo;
import cn.thinkfree.database.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyInfoService {
    List<CompanyInfo> selectByCompany(UserVO userVO);

    /**
     * 添加公司
     */
    int addCompanyInfo(CompanyInfo companyInfo);

    /**
     * 修改公司信息
     */
    int updateCompanyInfo(CompanyInfo companyInfo);
    /**
     * 查询公司信息
     */
    PageInfo<CompanyInfo> list(CompanyInfo companyInfo);
}
