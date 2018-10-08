package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.ApprovalFlow;
import cn.thinkfree.database.model.ApprovalFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalFlowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    long countByExample(ApprovalFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int deleteByExample(ApprovalFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int insert(ApprovalFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int insertSelective(ApprovalFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    List<ApprovalFlow> selectByExample(ApprovalFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    ApprovalFlow selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ApprovalFlow record, @Param("example") ApprovalFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ApprovalFlow record, @Param("example") ApprovalFlowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ApprovalFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approval_flow
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ApprovalFlow record);
}