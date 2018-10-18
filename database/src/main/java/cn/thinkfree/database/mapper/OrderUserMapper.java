package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.OrderUser;
import cn.thinkfree.database.model.OrderUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    long countByExample(OrderUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int deleteByExample(OrderUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int insert(OrderUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int insertSelective(OrderUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    List<OrderUser> selectByExample(OrderUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    OrderUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OrderUser record, @Param("example") OrderUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OrderUser record, @Param("example") OrderUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrderUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrderUser record);
}