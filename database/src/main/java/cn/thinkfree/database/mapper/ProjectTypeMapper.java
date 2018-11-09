package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.ProjectType;
import cn.thinkfree.database.model.ProjectTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    long countByExample(ProjectTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int deleteByExample(ProjectTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int insert(ProjectType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int insertSelective(ProjectType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    List<ProjectType> selectByExample(ProjectTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    ProjectType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int updateByExampleSelective(@Param("record") ProjectType record, @Param("example") ProjectTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int updateByExample(@Param("record") ProjectType record, @Param("example") ProjectTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int updateByPrimaryKeySelective(ProjectType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_project_type

     */
    int updateByPrimaryKey(ProjectType record);
}