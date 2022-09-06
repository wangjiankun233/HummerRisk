package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.PackageDependencyJsonItem;
import com.hummerrisk.base.domain.PackageDependencyJsonItemExample;
import com.hummerrisk.base.domain.PackageDependencyJsonItemWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageDependencyJsonItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    long countByExample(PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int deleteByExample(PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int insert(PackageDependencyJsonItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int insertSelective(PackageDependencyJsonItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    List<PackageDependencyJsonItemWithBLOBs> selectByExampleWithBLOBs(PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    List<PackageDependencyJsonItem> selectByExample(PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    PackageDependencyJsonItemWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByExampleSelective(@Param("record") PackageDependencyJsonItemWithBLOBs record, @Param("example") PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") PackageDependencyJsonItemWithBLOBs record, @Param("example") PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByExample(@Param("record") PackageDependencyJsonItem record, @Param("example") PackageDependencyJsonItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByPrimaryKeySelective(PackageDependencyJsonItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(PackageDependencyJsonItemWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table package_dependency_json_item
     *
     * @mbg.generated Fri Sep 02 05:45:55 CST 2022
     */
    int updateByPrimaryKey(PackageDependencyJsonItem record);
}
