package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.HistoryFileSystemResult;
import com.hummerrisk.base.domain.HistoryFileSystemResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryFileSystemResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    long countByExample(HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int deleteByExample(HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int insert(HistoryFileSystemResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int insertSelective(HistoryFileSystemResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    List<HistoryFileSystemResult> selectByExampleWithBLOBs(HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    List<HistoryFileSystemResult> selectByExample(HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    HistoryFileSystemResult selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByExampleSelective(@Param("record") HistoryFileSystemResult record, @Param("example") HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") HistoryFileSystemResult record, @Param("example") HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByExample(@Param("record") HistoryFileSystemResult record, @Param("example") HistoryFileSystemResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByPrimaryKeySelective(HistoryFileSystemResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(HistoryFileSystemResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_file_system_result
     *
     * @mbg.generated Thu Oct 13 03:06:06 CST 2022
     */
    int updateByPrimaryKey(HistoryFileSystemResult record);
}
