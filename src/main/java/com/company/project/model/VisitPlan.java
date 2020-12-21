package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_visit_plan")
public class VisitPlan {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 计划间隔时间
     */
    @Column(name = "interval_day")
    private String intervalDay;

    /**
     * 随访id
     */
    @Column(name = "visit_id")
    private String visitId;

    /**
     * 医生id
     */
    @Column(name = "doctor_id")
    private String doctorId;

    /**
     * 计划名称
     */
    private String name;

    /**
     * 计划随访时间
     */
    @Column(name = "plan_visit_time")
    private Date planVisitTime;

    /**
     * 随访人员id
     */
    @Column(name = "visit_staff")
    private String visitStaff;

    /**
     * 随访项目
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 随访内容id
     */
    @Column(name = "content_id")
    private String contentId;

    /**
     * 随访内容
     */
    private String content;

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
     * 随访时间
     */
    @Column(name = "visit_time")
    private Date visitTime;

    /**
     * 随访结果id
     */
    @Column(name = "result_id")
    private String resultId;

    /**
     * 随访结果
     */
    @Column(name = "result_info")
    private String resultInfo;

    /**
     * 1、满意 0、不满意
     */
    private String satisfaction;

    /**
     * 1 待计划 2 随访完成 3 已取消 4未成功
     */
    private String status;

    /**
     * 消息回复
     */
    @Column(name = "reurn_info")
    private String reurnInfo;

    /**
     * 沟通方式
     */
    @Column(name = "communication_method")
    private String communicationMethod;

    /**
     * 执行随访者
     */
    @Column(name = "visit_by")
    private String visitBy;

    /**
     * 医生类型
     */
    @Column(name = "doctor_type")
    private String doctorType;

    /**
     * 随访人员类型
     */
    @Column(name = "visit_staff_type")
    private String visitStaffType;

    /**
     * 1、显示  0、隐藏
     */
    private String flag;

    /**
     * 就诊时间
     */
    @Column(name = "diagnose_time")
    private Date diagnoseTime;

    /**
     * 序号
     */
    @Column(name = "show_order")
    private Integer showOrder;

    /**
     * 时间数
     */
    @Column(name = "delay_count")
    private Integer delayCount;

    /**
     * 时间类型（天，周，月）
     */
    @Column(name = "delay_unit")
    private String delayUnit;

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
     * 获取计划间隔时间
     *
     * @return interval_day - 计划间隔时间
     */
    public String getIntervalDay() {
        return intervalDay;
    }

    /**
     * 设置计划间隔时间
     *
     * @param intervalDay 计划间隔时间
     */
    public void setIntervalDay(String intervalDay) {
        this.intervalDay = intervalDay;
    }

    /**
     * 获取随访id
     *
     * @return visit_id - 随访id
     */
    public String getVisitId() {
        return visitId;
    }

    /**
     * 设置随访id
     *
     * @param visitId 随访id
     */
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    /**
     * 获取医生id
     *
     * @return doctor_id - 医生id
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * 设置医生id
     *
     * @param doctorId 医生id
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取计划名称
     *
     * @return name - 计划名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置计划名称
     *
     * @param name 计划名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取计划随访时间
     *
     * @return plan_visit_time - 计划随访时间
     */
    public Date getPlanVisitTime() {
        return planVisitTime;
    }

    /**
     * 设置计划随访时间
     *
     * @param planVisitTime 计划随访时间
     */
    public void setPlanVisitTime(Date planVisitTime) {
        this.planVisitTime = planVisitTime;
    }

    /**
     * 获取随访人员id
     *
     * @return visit_staff - 随访人员id
     */
    public String getVisitStaff() {
        return visitStaff;
    }

    /**
     * 设置随访人员id
     *
     * @param visitStaff 随访人员id
     */
    public void setVisitStaff(String visitStaff) {
        this.visitStaff = visitStaff;
    }

    /**
     * 获取随访项目
     *
     * @return project_id - 随访项目
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 设置随访项目
     *
     * @param projectId 随访项目
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取随访内容id
     *
     * @return content_id - 随访内容id
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 设置随访内容id
     *
     * @param contentId 随访内容id
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取随访内容
     *
     * @return content - 随访内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置随访内容
     *
     * @param content 随访内容
     */
    public void setContent(String content) {
        this.content = content;
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
     * 获取随访时间
     *
     * @return visit_time - 随访时间
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * 设置随访时间
     *
     * @param visitTime 随访时间
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * 获取随访结果id
     *
     * @return result_id - 随访结果id
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * 设置随访结果id
     *
     * @param resultId 随访结果id
     */
    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    /**
     * 获取随访结果
     *
     * @return result_info - 随访结果
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * 设置随访结果
     *
     * @param resultInfo 随访结果
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    /**
     * 获取1、满意 0、不满意
     *
     * @return satisfaction - 1、满意 0、不满意
     */
    public String getSatisfaction() {
        return satisfaction;
    }

    /**
     * 设置1、满意 0、不满意
     *
     * @param satisfaction 1、满意 0、不满意
     */
    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    /**
     * 获取1 待计划 2 随访完成 3 已取消 4未成功
     *
     * @return status - 1 待计划 2 随访完成 3 已取消 4未成功
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置1 待计划 2 随访完成 3 已取消 4未成功
     *
     * @param status 1 待计划 2 随访完成 3 已取消 4未成功
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取消息回复
     *
     * @return reurn_info - 消息回复
     */
    public String getReurnInfo() {
        return reurnInfo;
    }

    /**
     * 设置消息回复
     *
     * @param reurnInfo 消息回复
     */
    public void setReurnInfo(String reurnInfo) {
        this.reurnInfo = reurnInfo;
    }

    /**
     * 获取沟通方式
     *
     * @return communication_method - 沟通方式
     */
    public String getCommunicationMethod() {
        return communicationMethod;
    }

    /**
     * 设置沟通方式
     *
     * @param communicationMethod 沟通方式
     */
    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

    /**
     * 获取执行随访者
     *
     * @return visit_by - 执行随访者
     */
    public String getVisitBy() {
        return visitBy;
    }

    /**
     * 设置执行随访者
     *
     * @param visitBy 执行随访者
     */
    public void setVisitBy(String visitBy) {
        this.visitBy = visitBy;
    }

    /**
     * 获取医生类型
     *
     * @return doctor_type - 医生类型
     */
    public String getDoctorType() {
        return doctorType;
    }

    /**
     * 设置医生类型
     *
     * @param doctorType 医生类型
     */
    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    /**
     * 获取随访人员类型
     *
     * @return visit_staff_type - 随访人员类型
     */
    public String getVisitStaffType() {
        return visitStaffType;
    }

    /**
     * 设置随访人员类型
     *
     * @param visitStaffType 随访人员类型
     */
    public void setVisitStaffType(String visitStaffType) {
        this.visitStaffType = visitStaffType;
    }

    /**
     * 获取1、显示  0、隐藏
     *
     * @return flag - 1、显示  0、隐藏
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置1、显示  0、隐藏
     *
     * @param flag 1、显示  0、隐藏
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取就诊时间
     *
     * @return diagnose_time - 就诊时间
     */
    public Date getDiagnoseTime() {
        return diagnoseTime;
    }

    /**
     * 设置就诊时间
     *
     * @param diagnoseTime 就诊时间
     */
    public void setDiagnoseTime(Date diagnoseTime) {
        this.diagnoseTime = diagnoseTime;
    }

    /**
     * 获取序号
     *
     * @return show_order - 序号
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * 设置序号
     *
     * @param showOrder 序号
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * 获取时间数
     *
     * @return delay_count - 时间数
     */
    public Integer getDelayCount() {
        return delayCount;
    }

    /**
     * 设置时间数
     *
     * @param delayCount 时间数
     */
    public void setDelayCount(Integer delayCount) {
        this.delayCount = delayCount;
    }

    /**
     * 获取时间类型（天，周，月）
     *
     * @return delay_unit - 时间类型（天，周，月）
     */
    public String getDelayUnit() {
        return delayUnit;
    }

    /**
     * 设置时间类型（天，周，月）
     *
     * @param delayUnit 时间类型（天，周，月）
     */
    public void setDelayUnit(String delayUnit) {
        this.delayUnit = delayUnit;
    }
}