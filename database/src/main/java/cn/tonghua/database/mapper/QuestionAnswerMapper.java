package cn.tonghua.database.mapper;

import cn.tonghua.database.model.QuestionAnswer;
import cn.tonghua.database.model.QuestionAnswerExample;
import java.util.List;

import cn.tonghua.database.vo.QuestionAnswerVO;
import org.apache.ibatis.annotations.Param;

public interface QuestionAnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    long countByExample(QuestionAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int deleteByExample(QuestionAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int insert(QuestionAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int insertSelective(QuestionAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    List<QuestionAnswer> selectByExample(QuestionAnswerExample example);

    List<QuestionAnswerVO> selectByExampleVO(QuestionAnswerExample example);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    QuestionAnswer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") QuestionAnswer record, @Param("example") QuestionAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") QuestionAnswer record, @Param("example") QuestionAnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(QuestionAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QuestionAnswer record);
}