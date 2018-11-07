package cn.thinkfree.database.mapper;

import cn.thinkfree.database.model.BaseDic;
import cn.thinkfree.database.model.BaseDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    long countByExample(BaseDicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    int deleteByExample(BaseDicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    int insert(BaseDic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    int insertSelective(BaseDic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    List<BaseDic> selectByExample(BaseDicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    int updateByExampleSelective(@Param("record") BaseDic record, @Param("example") BaseDicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_base_dic

     */
    int updateByExample(@Param("record") BaseDic record, @Param("example") BaseDicExample example);
}