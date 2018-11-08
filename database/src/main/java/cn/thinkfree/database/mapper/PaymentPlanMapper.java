package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.PaymentPlan;
import cn.thinkfree.database.model.PaymentPlanExample;
import java.util.List;

import cn.thinkfree.database.vo.PaymentPlanVO;
import org.apache.ibatis.annotations.Param;

public interface PaymentPlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    long countByExample(PaymentPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    int deleteByExample(PaymentPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    int insert(PaymentPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    int insertSelective(PaymentPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    List<PaymentPlan> selectByExample(PaymentPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PaymentPlan record, @Param("example") PaymentPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_payment_plan
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PaymentPlan record, @Param("example") PaymentPlanExample example);

    PaymentPlanVO paymentPlanDetails (String paymentCode);
}