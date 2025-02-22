package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.CloudNativeResultLog;
import com.hummerrisk.base.domain.CloudNativeResultLogExample;
import com.hummerrisk.base.domain.CloudNativeResultLogWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudNativeResultLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    long countByExample(CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByExample(CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insert(CloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insertSelective(CloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<CloudNativeResultLogWithBLOBs> selectByExampleWithBLOBs(CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<CloudNativeResultLog> selectByExample(CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    CloudNativeResultLogWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleSelective(@Param("record") CloudNativeResultLogWithBLOBs record, @Param("example") CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CloudNativeResultLogWithBLOBs record, @Param("example") CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExample(@Param("record") CloudNativeResultLog record, @Param("example") CloudNativeResultLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeySelective(CloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CloudNativeResultLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_native_result_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKey(CloudNativeResultLog record);
}
