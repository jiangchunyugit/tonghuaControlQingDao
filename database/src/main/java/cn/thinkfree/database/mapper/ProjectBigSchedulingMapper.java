package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.ProjectBigScheduling;
import cn.thinkfree.database.model.ProjectBigSchedulingExample;
import java.util.List;
import java.util.TreeSet;

import cn.thinkfree.database.vo.ProjectBigSchedulingVO;
import org.apache.ibatis.annotations.Param;

public interface ProjectBigSchedulingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    long countByExample(ProjectBigSchedulingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int deleteByExample(ProjectBigSchedulingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int insert(ProjectBigScheduling record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int insertSelective(ProjectBigScheduling record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    List<ProjectBigScheduling> selectByExample(ProjectBigSchedulingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    ProjectBigScheduling selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ProjectBigScheduling record, @Param("example") ProjectBigSchedulingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ProjectBigScheduling record, @Param("example") ProjectBigSchedulingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProjectBigScheduling record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_base_big_scheduling
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProjectBigScheduling record);
    /**
     * @return
     * @Author chengpunan
     * @Description 根据公司编号查找大排期基础信息
     * @Date
     * @Param
     **/
    ProjectBigSchedulingVO selectProjectBigSchedulingByCompanyId(@Param("companyId") String companyId);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int updateByProjectBigScheduling(@Param("record") ProjectBigScheduling record);

    /**
     * 查询已有基础大排期
     *
     * @param status
     * @param companyId
     * @return
     */
    TreeSet<String> selectByStatus(@Param("status") Integer status, @Param("companyId") String companyId);
}