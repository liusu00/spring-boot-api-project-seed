package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sms_template")
public class SmsTemplate {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 上级Id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 短信json模板
     */
    @Column(name = "json_param")
    private String jsonParam;

    /**
     * 短信编码
     */
    private String code;

    /**
     * 短信名
     */
    private String name;

    /**
     * 短信内容
     */
    @Column(name = "sms_content")
    private String smsContent;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取上级Id
     *
     * @return parent_id - 上级Id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级Id
     *
     * @param parentId 上级Id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取短信json模板
     *
     * @return json_param - 短信json模板
     */
    public String getJsonParam() {
        return jsonParam;
    }

    /**
     * 设置短信json模板
     *
     * @param jsonParam 短信json模板
     */
    public void setJsonParam(String jsonParam) {
        this.jsonParam = jsonParam;
    }

    /**
     * 获取短信编码
     *
     * @return code - 短信编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置短信编码
     *
     * @param code 短信编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取短信名
     *
     * @return name - 短信名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置短信名
     *
     * @param name 短信名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取短信内容
     *
     * @return sms_content - 短信内容
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * 设置短信内容
     *
     * @param smsContent 短信内容
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}