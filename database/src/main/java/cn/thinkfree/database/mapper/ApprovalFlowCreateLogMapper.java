package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.ApprovalFlowCreateLog;
import cn.thinkfree.database.model.ApprovalFlowCreateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalFlowCreateLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    long countByExample(ApprovalFlowCreateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int deleteByExample(ApprovalFlowCreateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int insert(ApprovalFlowCreateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int insertSelective(ApprovalFlowCreateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    List<ApprovalFlowCreateLog> selectByExample(ApprovalFlowCreateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    ApprovalFlowCreateLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ApprovalFlowCreateLog record, @Param("example") ApprovalFlowCreateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ApprovalFlowCreateLog record, @Param("example") ApprovalFlowCreateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ApprovalFlowCreateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow_create_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ApprovalFlowCreateLog record);
}