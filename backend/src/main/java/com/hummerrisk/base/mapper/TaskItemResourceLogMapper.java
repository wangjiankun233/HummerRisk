package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.TaskItemResourceLog;
import com.hummerrisk.base.domain.TaskItemResourceLogExample;
import com.hummerrisk.base.domain.TaskItemResourceLogWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskItemResourceLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    long countByExample(TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByExample(TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insert(TaskItemResourceLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int insertSelective(TaskItemResourceLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<TaskItemResourceLogWithBLOBs> selectByExampleWithBLOBs(TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    List<TaskItemResourceLog> selectByExample(TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    TaskItemResourceLogWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleSelective(@Param("record") TaskItemResourceLogWithBLOBs record, @Param("example") TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") TaskItemResourceLogWithBLOBs record, @Param("example") TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByExample(@Param("record") TaskItemResourceLog record, @Param("example") TaskItemResourceLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeySelective(TaskItemResourceLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(TaskItemResourceLogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_item_resource_log
     *
     * @mbg.generated Thu Oct 20 07:33:40 CST 2022
     */
    int updateByPrimaryKey(TaskItemResourceLog record);
}
