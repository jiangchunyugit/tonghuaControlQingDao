package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.HrPeopleEntity;
import cn.thinkfree.database.model.HrPeopleEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrPeopleEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    long countByExample(HrPeopleEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int deleteByExample(HrPeopleEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int insert(HrPeopleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int insertSelective(HrPeopleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    List<HrPeopleEntity> selectByExample(HrPeopleEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    HrPeopleEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") HrPeopleEntity record, @Param("example") HrPeopleEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") HrPeopleEntity record, @Param("example") HrPeopleEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(HrPeopleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hr_people_entity
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(HrPeopleEntity record);
}