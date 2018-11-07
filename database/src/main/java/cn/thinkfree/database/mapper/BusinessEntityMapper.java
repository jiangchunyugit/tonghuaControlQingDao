package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.BusinessEntity;
import cn.thinkfree.database.model.BusinessEntityExample;
import java.util.List;

import cn.thinkfree.database.vo.BusinessEntityVO;
import org.apache.ibatis.annotations.Param;

public interface BusinessEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    long countByExample(BusinessEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int deleteByExample(BusinessEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int insert(BusinessEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int insertSelective(BusinessEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    List<BusinessEntity> selectByExample(BusinessEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    BusinessEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int updateByExampleSelective(@Param("record") BusinessEntity record, @Param("example") BusinessEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int updateByExample(@Param("record") BusinessEntity record, @Param("example") BusinessEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int updateByPrimaryKeySelective(BusinessEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_business_entity

     */
    int updateByPrimaryKey(BusinessEntity record);

    List<BusinessEntityVO> selectWithCompany(BusinessEntityExample example);
}