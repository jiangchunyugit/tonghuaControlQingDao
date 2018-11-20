package cn.thinkfree.service.citybranch;

import cn.thinkfree.database.model.City;
import cn.thinkfree.database.model.CityBranch;
import cn.thinkfree.database.vo.CityBranchSEO;
import cn.thinkfree.database.vo.CityBranchVO;
import cn.thinkfree.database.vo.CityBranchWtihProCitVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jiangchunyu(后台)
 * @date 2018
 * @Description 城市分站 接口
 */
public interface CityBranchService {

    /**
     * 添加城市分站
     * @param cityBranch
     * @return
     */
    int addCityBranch(CityBranch cityBranch);

    /**
     * 修改城市分站信息
     * @param cityBranch
     * @return
     */
    int updateCityBranch(CityBranch cityBranch);

    /**
     * 查询城市分站信息
     * @param cityBranchSEO
     * @return
     */
    PageInfo<CityBranchVO> cityBranchList(CityBranchSEO cityBranchSEO);

    /**
     * 分公司查看详细城市分站
     * @param cityBranchSEO
     * @return
     */
    PageInfo<CityBranchWtihProCitVO> cityBranchWithProList(CityBranchSEO cityBranchSEO);

    /**
     * 根据城市分站id查询详情(带有店面信息)
     * @param id
     * @return
     */
    CityBranchVO cityBranchDetails(Integer id);

    /**
     * 更新城市分站状态（启动，禁用，删除）
     * @return
     * @param cityBranch
     * @return
     */
    int updateCityBranchStatus(CityBranch cityBranch);

    /**
     * 根据城市查询城市分站（过滤入驻权限）
     * @param branchCompanyCode
     * @param cityCode
     * @return
     */
    List<CityBranch> selectByProCit(String branchCompanyCode, Integer cityCode);

    /**
     * 根据省市查询城市分站
     * @param province
     * @param city
     * @return
     */
    List<CityBranch> selectByProCitCode(Integer province,Integer city);

    /**
     * 城市分站城市信息
     * @return
     */
    List<City> selectCity();

    /**
     * 编辑回写
     * @param id
     * @return
     */
    CityBranchVO cityBranchById (Integer id);

    /**
     * 通过分公司id查询全部城市分站信息
     * @param id
     * @return
     */
    List<CityBranch> cityBranchesByCompany(Integer id);

    /**
     * 通过分公司编号查询全部城市分站信息
     * @param flag
     * @param branchCompanyCode
     * @return
     */
    List<CityBranch> cityBranchesByCompanyCode (Integer flag,String branchCompanyCode);
}
