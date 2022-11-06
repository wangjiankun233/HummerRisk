package com.hummerrisk.base.domain;

import java.io.Serializable;

public class OssBucket implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.bucket_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String bucketName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.storage_class
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String storageClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.location
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.create_time
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.intranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String intranetEndpoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.extranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String extranetEndpoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.oss_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String ossId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.oss_item_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String ossItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.sync_status
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String syncStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.domain_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String domainName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.size
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private Long size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.object_number
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private Long objectNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oss_bucket.canned_acl
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private String cannedAcl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oss_bucket
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.id
     *
     * @return the value of oss_bucket.id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.id
     *
     * @param id the value for oss_bucket.id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.bucket_name
     *
     * @return the value of oss_bucket.bucket_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.bucket_name
     *
     * @param bucketName the value for oss_bucket.bucket_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName == null ? null : bucketName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.storage_class
     *
     * @return the value of oss_bucket.storage_class
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getStorageClass() {
        return storageClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.storage_class
     *
     * @param storageClass the value for oss_bucket.storage_class
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass == null ? null : storageClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.location
     *
     * @return the value of oss_bucket.location
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.location
     *
     * @param location the value for oss_bucket.location
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.create_time
     *
     * @return the value of oss_bucket.create_time
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.create_time
     *
     * @param createTime the value for oss_bucket.create_time
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.intranet_endpoint
     *
     * @return the value of oss_bucket.intranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getIntranetEndpoint() {
        return intranetEndpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.intranet_endpoint
     *
     * @param intranetEndpoint the value for oss_bucket.intranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setIntranetEndpoint(String intranetEndpoint) {
        this.intranetEndpoint = intranetEndpoint == null ? null : intranetEndpoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.extranet_endpoint
     *
     * @return the value of oss_bucket.extranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getExtranetEndpoint() {
        return extranetEndpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.extranet_endpoint
     *
     * @param extranetEndpoint the value for oss_bucket.extranet_endpoint
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setExtranetEndpoint(String extranetEndpoint) {
        this.extranetEndpoint = extranetEndpoint == null ? null : extranetEndpoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.oss_id
     *
     * @return the value of oss_bucket.oss_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getOssId() {
        return ossId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.oss_id
     *
     * @param ossId the value for oss_bucket.oss_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setOssId(String ossId) {
        this.ossId = ossId == null ? null : ossId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.oss_item_id
     *
     * @return the value of oss_bucket.oss_item_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getOssItemId() {
        return ossItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.oss_item_id
     *
     * @param ossItemId the value for oss_bucket.oss_item_id
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setOssItemId(String ossItemId) {
        this.ossItemId = ossItemId == null ? null : ossItemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.sync_status
     *
     * @return the value of oss_bucket.sync_status
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getSyncStatus() {
        return syncStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.sync_status
     *
     * @param syncStatus the value for oss_bucket.sync_status
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus == null ? null : syncStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.domain_name
     *
     * @return the value of oss_bucket.domain_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.domain_name
     *
     * @param domainName the value for oss_bucket.domain_name
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.size
     *
     * @return the value of oss_bucket.size
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public Long getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.size
     *
     * @param size the value for oss_bucket.size
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.object_number
     *
     * @return the value of oss_bucket.object_number
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public Long getObjectNumber() {
        return objectNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.object_number
     *
     * @param objectNumber the value for oss_bucket.object_number
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setObjectNumber(Long objectNumber) {
        this.objectNumber = objectNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oss_bucket.canned_acl
     *
     * @return the value of oss_bucket.canned_acl
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public String getCannedAcl() {
        return cannedAcl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oss_bucket.canned_acl
     *
     * @param cannedAcl the value for oss_bucket.canned_acl
     *
     * @mbg.generated Sun Nov 06 08:31:33 CST 2022
     */
    public void setCannedAcl(String cannedAcl) {
        this.cannedAcl = cannedAcl == null ? null : cannedAcl.trim();
    }
}