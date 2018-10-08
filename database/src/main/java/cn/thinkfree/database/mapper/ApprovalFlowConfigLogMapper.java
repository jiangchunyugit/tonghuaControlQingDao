package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.ApprovalFlowConfigLog;
import cn.thinkfree.database.model.ApprovalFlowConfigLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalFlowConfigLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    long countByExample(ApprovalFlowConfigLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int deleteByExample(ApprovalFlowConfigLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int insert(ApprovalFlowConfigLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int insertSelective(ApprovalFlowConfigLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    List<ApprovalFlowConfigLog> selectByExample(ApprovalFlowConfigLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    ApprovalFlowConfigLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ApprovalFlowConfigLog record, @Param("example") ApprovalFlowConfigLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ApprovalFlowConfigLog record, @Param("example") ApprovalFlowConfigLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ApprovalFlowConfigLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_config_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ApprovalFlowConfigLog record);
}