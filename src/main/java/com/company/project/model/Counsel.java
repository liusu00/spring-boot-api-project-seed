package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_counsel")
public class Counsel {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 患者id
     */
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 咨询项目
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 预约挂号id
     */
    @Column(name = "registration_id")
    private String registrationId;

    /**
     * 成交意愿
     */
    @Column(name = "transaction_intention")
    private String transactionIntention;

    /**
     * 意向说明
     */
    @Column(name = "explain_detail")
    private String explainDetail;

    /**
     * 状态
     */
    private String status;

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
     * 忽略标记
     */
    @Column(name = "ignore_flag")
    private String ignoreFlag;

    /**
     * 咨询类型，1：现场咨询，2：网店咨询
     */
    @Column(name = "counsel_type")
    private String counselType;

    /**
     * 咨询方式
     */
    @Column(name = "counsel_mode")
    private String counselMode;

    /**
     * 咨询内容
     */
    private String context;

    @Transient
    private String tel;
    @Transient
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

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
     * 获取患者id
     *
     * @return patient_id - 患者id
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * 设置患者id
     *
     * @param patientId 患者id
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取咨询项目
     *
     * @return project_id - 咨询项目
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 设置咨询项目
     *
     * @param projectId 咨询项目
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取预约挂号id
     *
     * @return registration_id - 预约挂号id
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * 设置预约挂号id
     *
     * @param registrationId 预约挂号id
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * 获取成交意愿
     *
     * @return transaction_intention - 成交意愿
     */
    public String getTransactionIntention() {
        return transactionIntention;
    }

    /**
     * 设置成交意愿
     *
     * @param transactionIntention 成交意愿
     */
    public void setTransactionIntention(String transactionIntention) {
        this.transactionIntention = transactionIntention;
    }

    /**
     * 获取意向说明
     *
     * @return explain_detail - 意向说明
     */
    public String getExplainDetail() {
        return explainDetail;
    }

    /**
     * 设置意向说明
     *
     * @param explainDetail 意向说明
     */
    public void setExplainDetail(String explainDetail) {
        this.explainDetail = explainDetail;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * 获取忽略标记
     *
     * @return ignore_flag - 忽略标记
     */
    public String getIgnoreFlag() {
        return ignoreFlag;
    }

    /**
     * 设置忽略标记
     *
     * @param ignoreFlag 忽略标记
     */
    public void setIgnoreFlag(String ignoreFlag) {
        this.ignoreFlag = ignoreFlag;
    }

    /**
     * 获取咨询类型，1：现场咨询，2：网店咨询
     *
     * @return counsel_type - 咨询类型，1：现场咨询，2：网店咨询
     */
    public String getCounselType() {
        return counselType;
    }

    /**
     * 设置咨询类型，1：现场咨询，2：网店咨询
     *
     * @param counselType 咨询类型，1：现场咨询，2：网店咨询
     */
    public void setCounselType(String counselType) {
        this.counselType = counselType;
    }

    /**
     * 获取咨询方式
     *
     * @return counsel_mode - 咨询方式
     */
    public String getCounselMode() {
        return counselMode;
    }

    /**
     * 设置咨询方式
     *
     * @param counselMode 咨询方式
     */
    public void setCounselMode(String counselMode) {
        this.counselMode = counselMode;
    }

    /**
     * 获取咨询内容
     *
     * @return context - 咨询内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置咨询内容
     *
     * @param context 咨询内容
     */
    public void setContext(String context) {
        this.context = context;
    }
}