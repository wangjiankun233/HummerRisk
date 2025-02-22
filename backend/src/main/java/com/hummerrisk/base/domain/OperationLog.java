package com.hummerrisk.base.domain;

import java.io.Serializable;

public class OperationLog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.resource_user_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String resourceUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.resource_user_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String resourceUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.resource_type
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String resourceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.resource_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.resource_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.operation
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String operation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.time
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.source_ip
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String sourceIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operation_log.message
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table operation_log
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.id
     *
     * @return the value of operation_log.id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.id
     *
     * @param id the value for operation_log.id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.resource_user_id
     *
     * @return the value of operation_log.resource_user_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getResourceUserId() {
        return resourceUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.resource_user_id
     *
     * @param resourceUserId the value for operation_log.resource_user_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setResourceUserId(String resourceUserId) {
        this.resourceUserId = resourceUserId == null ? null : resourceUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.resource_user_name
     *
     * @return the value of operation_log.resource_user_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getResourceUserName() {
        return resourceUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.resource_user_name
     *
     * @param resourceUserName the value for operation_log.resource_user_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setResourceUserName(String resourceUserName) {
        this.resourceUserName = resourceUserName == null ? null : resourceUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.resource_type
     *
     * @return the value of operation_log.resource_type
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.resource_type
     *
     * @param resourceType the value for operation_log.resource_type
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.resource_id
     *
     * @return the value of operation_log.resource_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.resource_id
     *
     * @param resourceId the value for operation_log.resource_id
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.resource_name
     *
     * @return the value of operation_log.resource_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.resource_name
     *
     * @param resourceName the value for operation_log.resource_name
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.operation
     *
     * @return the value of operation_log.operation
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.operation
     *
     * @param operation the value for operation_log.operation
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.time
     *
     * @return the value of operation_log.time
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.time
     *
     * @param time the value for operation_log.time
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.source_ip
     *
     * @return the value of operation_log.source_ip
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.source_ip
     *
     * @param sourceIp the value for operation_log.source_ip
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp == null ? null : sourceIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operation_log.message
     *
     * @return the value of operation_log.message
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operation_log.message
     *
     * @param message the value for operation_log.message
     *
     * @mbg.generated Mon Nov 28 00:41:09 CST 2022
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}