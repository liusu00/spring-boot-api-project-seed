package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "medical_record")
public class MedicalRecord {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 预约id
     */
    @Column(name = "appointment_id")
    private String appointmentId;

    /**
     * 患者id
     */
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 1：初诊病历，2：复诊病历
     */
    @Column(name = "medical_record_type")
    private String medicalRecordType;

    /**
     * 医生ID
     */
    @Column(name = "doctor_id")
    private String doctorId;

    /**
     * 护士id
     */
    @Column(name = "nurse_id")
    private String nurseId;

    /**
     * 主诉
     */
    @Column(name = "chief_complaint")
    private String chiefComplaint;

    /**
     * 现病史
     */
    @Column(name = "hp_illness")
    private String hpIllness;

    /**
     * 既往史
     */
    @Column(name = "past_history")
    private String pastHistory;

    /**
     * 医嘱
     */
    @Column(name = "medical_advice")
    private String medicalAdvice;

    /**
     * 标签
     */
    private String tag;

    /**
     * 0 未写 1 待评审 2 待整改 3 已通过 4 已忽略
     */
    private Integer status;

    /**
     * 诊所ID
     */
    @Column(name = "clinic_id")
    private String clinicId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建日期
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

    @Transient
    private String name;

    @Transient
    private String no;

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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取预约id
     *
     * @return appointment_id - 预约id
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * 设置预约id
     *
     * @param appointmentId 预约id
     */
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
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
     * 获取1：初诊病历，2：复诊病历
     *
     * @return medical_record_type - 1：初诊病历，2：复诊病历
     */
    public String getMedicalRecordType() {
        return medicalRecordType;
    }

    /**
     * 设置1：初诊病历，2：复诊病历
     *
     * @param medicalRecordType 1：初诊病历，2：复诊病历
     */
    public void setMedicalRecordType(String medicalRecordType) {
        this.medicalRecordType = medicalRecordType;
    }

    /**
     * 获取医生ID
     *
     * @return doctor_id - 医生ID
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * 设置医生ID
     *
     * @param doctorId 医生ID
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取护士id
     *
     * @return nurse_id - 护士id
     */
    public String getNurseId() {
        return nurseId;
    }

    /**
     * 设置护士id
     *
     * @param nurseId 护士id
     */
    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    /**
     * 获取主诉
     *
     * @return chief_complaint - 主诉
     */
    public String getChiefComplaint() {
        return chiefComplaint;
    }

    /**
     * 设置主诉
     *
     * @param chiefComplaint 主诉
     */
    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    /**
     * 获取现病史
     *
     * @return hp_illness - 现病史
     */
    public String getHpIllness() {
        return hpIllness;
    }

    /**
     * 设置现病史
     *
     * @param hpIllness 现病史
     */
    public void setHpIllness(String hpIllness) {
        this.hpIllness = hpIllness;
    }

    /**
     * 获取既往史
     *
     * @return past_history - 既往史
     */
    public String getPastHistory() {
        return pastHistory;
    }

    /**
     * 设置既往史
     *
     * @param pastHistory 既往史
     */
    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    /**
     * 获取医嘱
     *
     * @return medical_advice - 医嘱
     */
    public String getMedicalAdvice() {
        return medicalAdvice;
    }

    /**
     * 设置医嘱
     *
     * @param medicalAdvice 医嘱
     */
    public void setMedicalAdvice(String medicalAdvice) {
        this.medicalAdvice = medicalAdvice;
    }

    /**
     * 获取标签
     *
     * @return tag - 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取0 未写 1 待评审 2 待整改 3 已通过 4 已忽略
     *
     * @return status - 0 未写 1 待评审 2 待整改 3 已通过 4 已忽略
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0 未写 1 待评审 2 待整改 3 已通过 4 已忽略
     *
     * @param status 0 未写 1 待评审 2 待整改 3 已通过 4 已忽略
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取诊所ID
     *
     * @return clinic_id - 诊所ID
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 设置诊所ID
     *
     * @param clinicId 诊所ID
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
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
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
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