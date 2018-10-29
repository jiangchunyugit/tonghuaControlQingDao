package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.UserLoginLog;
import cn.thinkfree.database.model.UserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    long countByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int deleteByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int insert(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int insertSelective(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    List<UserLoginLog> selectByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    UserLoginLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int updateByExampleSelective(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int updateByExample(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int updateByPrimaryKeySelective(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log

     */
    int updateByPrimaryKey(UserLoginLog record);
}