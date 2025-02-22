package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.CloudTaskItem;
import com.hummerrisk.base.domain.CloudTaskItemExample;
import com.hummerrisk.base.domain.CloudTaskItemWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudTaskItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    long countByExample(CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int deleteByExample(CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int insert(CloudTaskItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int insertSelective(CloudTaskItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    List<CloudTaskItemWithBLOBs> selectByExampleWithBLOBs(CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    List<CloudTaskItem> selectByExample(CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    CloudTaskItemWithBLOBs selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByExampleSelective(@Param("record") CloudTaskItemWithBLOBs record, @Param("example") CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") CloudTaskItemWithBLOBs record, @Param("example") CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByExample(@Param("record") CloudTaskItem record, @Param("example") CloudTaskItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByPrimaryKeySelective(CloudTaskItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(CloudTaskItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_task_item
     *
     * @mbg.generated Wed Nov 02 11:13:50 CST 2022
     */
    int updateByPrimaryKey(CloudTaskItem record);
}
