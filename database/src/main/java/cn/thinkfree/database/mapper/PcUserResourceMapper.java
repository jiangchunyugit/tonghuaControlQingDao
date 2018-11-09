package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.PcUserResource;
import cn.thinkfree.database.model.PcUserResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PcUserResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    long countByExample(PcUserResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int deleteByExample(PcUserResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int insert(PcUserResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int insertSelective(PcUserResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    List<PcUserResource> selectByExample(PcUserResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    PcUserResource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int updateByExampleSelective(@Param("record") PcUserResource record, @Param("example") PcUserResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int updateByExample(@Param("record") PcUserResource record, @Param("example") PcUserResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int updateByPrimaryKeySelective(PcUserResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_user_resource

     */
    int updateByPrimaryKey(PcUserResource record);

    /**
     * 根据userID查询资源权限
     * @param userId
     * @return
     */

    List<Integer> selectByUserId(String userId);

    int deleteByUserId(String userId);

    /**
     *
     * @return
     */
    int insertBatch(List<PcUserResource> list);
}