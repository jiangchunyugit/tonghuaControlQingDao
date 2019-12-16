package cn.tonghua.database.mapper;

import cn.tonghua.database.model.SiteInfo;
import cn.tonghua.database.model.SiteInfoExample;
import java.util.List;

import cn.tonghua.database.vo.SiteVO;
import org.apache.ibatis.annotations.Param;

public interface SiteInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    long countByExample(SiteInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int deleteByExample(SiteInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int insert(SiteInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int insertSelective(SiteInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    List<SiteInfo> selectByExample(SiteInfoExample example);

    List<SiteVO> selectByExampleVO(SiteInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    SiteInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SiteInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SiteInfo record);
}