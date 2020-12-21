package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_visit")
public class Visit {
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
     * 1、一次性创建随访计划  2、等上次完成，再生成下次
     */
    @Column(name = "visit_model")
    private String visitModel;

    /**
     * 1、绝对时间模式 2、相对时间模式
     */
    @Column(name = "visit_time_model")
    private String visitTimeModel;

    /**
     * 随访类型
     */
    @Column(name = "visit_type")
    private String visitType;

    /**
     * 随访模板id
     */
    @Column(name = "template_id")
    private String templateId;

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
     * 预约挂号id
     */
    @Column(name = "registration_id")
    private String registrationId;

    /**
     * 创建人（页面选择的）
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 诊所id
     */
    @Column(name = "clinic_id")
    private String clinicId;

    @Transient
    private String name;

    @Transient
    private String no;

    @Transient
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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
     * 获取1、一次性创建随访计划  2、等上次完成，再生成下次
     *
     * @return visit_model - 1、一次性创建随访计划  2、等上次完成，再生成下次
     */
    public String getVisitModel() {
        return visitModel;
    }

    /**
     * 设置1、一次性创建随访计划  2、等上次完成，再生成下次
     *
     * @param visitModel 1、一次性创建随访计划  2、等上次完成，再生成下次
     */
    public void setVisitModel(String visitModel) {
        this.visitModel = visitModel;
    }

    /**
     * 获取1、绝对时间模式 2、相对时间模式
     *
     * @return visit_time_model - 1、绝对时间模式 2、相对时间模式
     */
    public String getVisitTimeModel() {
        return visitTimeModel;
    }

    /**
     * 设置1、绝对时间模式 2、相对时间模式
     *
     * @param visitTimeModel 1、绝对时间模式 2、相对时间模式
     */
    public void setVisitTimeModel(String visitTimeModel) {
        this.visitTimeModel = visitTimeModel;
    }

    /**
     * 获取随访类型
     *
     * @return visit_type - 随访类型
     */
    public String getVisitType() {
        return visitType;
    }

    /**
     * 设置随访类型
     *
     * @param visitType 随访类型
     */
    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    /**
     * 获取随访模板id
     *
     * @return template_id - 随访模板id
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置随访模板id
     *
     * @param templateId 随访模板id
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
     * 获取创建人（页面选择的）
     *
     * @return creator_id - 创建人（页面选择的）
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人（页面选择的）
     *
     * @param creatorId 创建人（页面选择的）
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取诊所id
     *
     * @return clinic_id - 诊所id
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 设置诊所id
     *
     * @param clinicId 诊所id
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }
}