package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_registration")
public class Registration {
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
     * 病历号
     */
    @Column(name = "anamnesis_no")
    private String anamnesisNo;

    /**
     * 挂号序列号
     */
    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 诊所id
     */
    @Column(name = "clinic_id")
    private String clinicId;

    /**
     * 症疗卡号
     */
    @Column(name = "card_id")
    private String cardId;

    /**
     * 医保号
     */
    @Column(name = "insure_code")
    private String insureCode;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 科室
     */
    @Column(name = "department_id")
    private String departmentId;

    /**
     * 医生id
     */
    @Column(name = "doctor_id")
    private String doctorId;

    /**
     * 挂号费
     */
    private BigDecimal cash;

    /**
     * 挂号员
     */
    private String operator;

    /**
     * 挂号时间
     */
    @Column(name = "event_time")
    private Date eventTime;

    /**
     * 预约时间
     */
    @Column(name = "appointment_time")
    private Date appointmentTime;

    /**
     * 医生排班id
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 上次就诊时间
     */
    @Column(name = "last_diagnose_time")
    private Date lastDiagnoseTime;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 1、初诊 2、复诊初治3 复诊 4、复查 5、复诊再治疗
     */
    @Column(name = "symptomatic_type")
    private String symptomaticType;

    /**
     * 1、普通  2、待定
     */
    @Column(name = "subscribe_type")
    private String subscribeType;

    /**
     * 咨询师
     */
    private String counselor;

    /**
     * 助理
     */
    private String assistant;

    /**
     * 1、开始治疗 2、治疗完成  3、离开
     */
    @Column(name = "treatment_status")
    private String treatmentStatus;

    /**
     * 1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
     */
    @Column(name = "appointment_status")
    private String appointmentStatus;

    /**
     * 预约时段(开始时间)
     */
    @Column(name = "appointment_period_begin")
    private Date appointmentPeriodBegin;

    /**
     * 预约时段(结束时间)
     */
    @Column(name = "appointment_period_end")
    private Date appointmentPeriodEnd;

    /**
     * 持续时间
     */
    @Column(name = "sustain_time")
    private String sustainTime;

    /**
     * 预约来源 1、网络预约 2 门店
     */
    private String resource;

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
     * 取消时间
     */
    @Column(name = "del_time")
    private Date delTime;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 待定时间
     */
    @Column(name = "undetermined_date")
    private Date undeterminedDate;

    /**
     * 类型 1：预约 2：到店
     */
    @Column(name = "type_status")
    private String typeStatus;

    /**
     * 诊室id
     */
    @Column(name = "consulting_room_id")
    private String consultingRoomId;

    /**
     * 网电咨询师id
     */
    @Column(name = "network_electrical_counselor_id")
    private String networkElectricalCounselorId;

    /**
     * 短信提醒次数
     */
    @Column(name = "remind_number")
    private Integer remindNumber;

    /**
     * 是否已接诊
     */
    @Column(name = "is_reception")
    private Boolean isReception;

    /**
     * 是否已检查
     */
    @Column(name = "is_check")
    private Boolean isCheck;

    /**
     * 是否已转诊
     */
    @Column(name = "is_transfer_treatment")
    private Boolean isTransferTreatment;

    /**
     * 是否治疗完成
     */
    @Column(name = "is_end_therapy")
    private Boolean isEndTherapy;

    /**
     * 是否分诊
     */
    @Column(name = "is_triage")
    private Boolean isTriage;

    @Column(name = "counselor_reception")
    private Boolean counselorReception;

    /**
     * 10待确认 20确认成功 30确认失败
     */
    @Column(name = "telephone_confirmation_status")
    private String telephoneConfirmationStatus;

    /**
     * 大类ID
     */
    @Column(name = "class_id")
    private String classId;

    /**
     * 电话确认人
     */
    @Column(name = "telephone_confirmation_user")
    private String telephoneConfirmationUser;

    /**
     * 电话确认时间
     */
    @Column(name = "telephone_confirmation_time")
    private Date telephoneConfirmationTime;

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
     * 获取病历号
     *
     * @return anamnesis_no - 病历号
     */
    public String getAnamnesisNo() {
        return anamnesisNo;
    }

    /**
     * 设置病历号
     *
     * @param anamnesisNo 病历号
     */
    public void setAnamnesisNo(String anamnesisNo) {
        this.anamnesisNo = anamnesisNo;
    }

    /**
     * 获取挂号序列号
     *
     * @return serial_number - 挂号序列号
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 设置挂号序列号
     *
     * @param serialNumber 挂号序列号
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    /**
     * 获取症疗卡号
     *
     * @return card_id - 症疗卡号
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置症疗卡号
     *
     * @param cardId 症疗卡号
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取医保号
     *
     * @return insure_code - 医保号
     */
    public String getInsureCode() {
        return insureCode;
    }

    /**
     * 设置医保号
     *
     * @param insureCode 医保号
     */
    public void setInsureCode(String insureCode) {
        this.insureCode = insureCode;
    }

    /**
     * 获取患者姓名
     *
     * @return name - 患者姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置患者姓名
     *
     * @param name 患者姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取科室
     *
     * @return department_id - 科室
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置科室
     *
     * @param departmentId 科室
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
     * 获取挂号费
     *
     * @return cash - 挂号费
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * 设置挂号费
     *
     * @param cash 挂号费
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * 获取挂号员
     *
     * @return operator - 挂号员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置挂号员
     *
     * @param operator 挂号员
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取挂号时间
     *
     * @return event_time - 挂号时间
     */
    public Date getEventTime() {
        return eventTime;
    }

    /**
     * 设置挂号时间
     *
     * @param eventTime 挂号时间
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * 获取预约时间
     *
     * @return appointment_time - 预约时间
     */
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * 设置预约时间
     *
     * @param appointmentTime 预约时间
     */
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * 获取医生排班id
     *
     * @return work_id - 医生排班id
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * 设置医生排班id
     *
     * @param workId 医生排班id
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }

    /**
     * 获取上次就诊时间
     *
     * @return last_diagnose_time - 上次就诊时间
     */
    public Date getLastDiagnoseTime() {
        return lastDiagnoseTime;
    }

    /**
     * 设置上次就诊时间
     *
     * @param lastDiagnoseTime 上次就诊时间
     */
    public void setLastDiagnoseTime(Date lastDiagnoseTime) {
        this.lastDiagnoseTime = lastDiagnoseTime;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取1、初诊 2、复诊初治3 复诊 4、复查 5、复诊再治疗
     *
     * @return symptomatic_type - 1、初诊 2、复诊初治3 复诊 4、复查 5、复诊再治疗
     */
    public String getSymptomaticType() {
        return symptomaticType;
    }

    /**
     * 设置1、初诊 2、复诊初治3 复诊 4、复查 5、复诊再治疗
     *
     * @param symptomaticType 1、初诊 2、复诊初治3 复诊 4、复查 5、复诊再治疗
     */
    public void setSymptomaticType(String symptomaticType) {
        this.symptomaticType = symptomaticType;
    }

    /**
     * 获取1、普通  2、待定
     *
     * @return subscribe_type - 1、普通  2、待定
     */
    public String getSubscribeType() {
        return subscribeType;
    }

    /**
     * 设置1、普通  2、待定
     *
     * @param subscribeType 1、普通  2、待定
     */
    public void setSubscribeType(String subscribeType) {
        this.subscribeType = subscribeType;
    }

    /**
     * 获取咨询师
     *
     * @return counselor - 咨询师
     */
    public String getCounselor() {
        return counselor;
    }

    /**
     * 设置咨询师
     *
     * @param counselor 咨询师
     */
    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    /**
     * 获取助理
     *
     * @return assistant - 助理
     */
    public String getAssistant() {
        return assistant;
    }

    /**
     * 设置助理
     *
     * @param assistant 助理
     */
    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    /**
     * 获取1、开始治疗 2、治疗完成  3、离开
     *
     * @return treatment_status - 1、开始治疗 2、治疗完成  3、离开
     */
    public String getTreatmentStatus() {
        return treatmentStatus;
    }

    /**
     * 设置1、开始治疗 2、治疗完成  3、离开
     *
     * @param treatmentStatus 1、开始治疗 2、治疗完成  3、离开
     */
    public void setTreatmentStatus(String treatmentStatus) {
        this.treatmentStatus = treatmentStatus;
    }

    /**
     * 获取1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
     *
     * @return appointment_status - 1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
     */
    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    /**
     * 设置1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
     *
     * @param appointmentStatus 1、预约  2、已确定  3、已到店 4已挂号 5、治疗中 6、治疗完成 7、已结账 8、已离开 9、已失约
     */
    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    /**
     * 获取预约时段(开始时间)
     *
     * @return appointment_period_begin - 预约时段(开始时间)
     */
    public Date getAppointmentPeriodBegin() {
        return appointmentPeriodBegin;
    }

    /**
     * 设置预约时段(开始时间)
     *
     * @param appointmentPeriodBegin 预约时段(开始时间)
     */
    public void setAppointmentPeriodBegin(Date appointmentPeriodBegin) {
        this.appointmentPeriodBegin = appointmentPeriodBegin;
    }

    /**
     * 获取预约时段(结束时间)
     *
     * @return appointment_period_end - 预约时段(结束时间)
     */
    public Date getAppointmentPeriodEnd() {
        return appointmentPeriodEnd;
    }

    /**
     * 设置预约时段(结束时间)
     *
     * @param appointmentPeriodEnd 预约时段(结束时间)
     */
    public void setAppointmentPeriodEnd(Date appointmentPeriodEnd) {
        this.appointmentPeriodEnd = appointmentPeriodEnd;
    }

    /**
     * 获取持续时间
     *
     * @return sustain_time - 持续时间
     */
    public String getSustainTime() {
        return sustainTime;
    }

    /**
     * 设置持续时间
     *
     * @param sustainTime 持续时间
     */
    public void setSustainTime(String sustainTime) {
        this.sustainTime = sustainTime;
    }

    /**
     * 获取预约来源 1、网络预约 2 门店
     *
     * @return resource - 预约来源 1、网络预约 2 门店
     */
    public String getResource() {
        return resource;
    }

    /**
     * 设置预约来源 1、网络预约 2 门店
     *
     * @param resource 预约来源 1、网络预约 2 门店
     */
    public void setResource(String resource) {
        this.resource = resource;
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
     * 获取取消时间
     *
     * @return del_time - 取消时间
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     * 设置取消时间
     *
     * @param delTime 取消时间
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
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
     * 获取待定时间
     *
     * @return undetermined_date - 待定时间
     */
    public Date getUndeterminedDate() {
        return undeterminedDate;
    }

    /**
     * 设置待定时间
     *
     * @param undeterminedDate 待定时间
     */
    public void setUndeterminedDate(Date undeterminedDate) {
        this.undeterminedDate = undeterminedDate;
    }

    /**
     * 获取类型 1：预约 2：到店
     *
     * @return type_status - 类型 1：预约 2：到店
     */
    public String getTypeStatus() {
        return typeStatus;
    }

    /**
     * 设置类型 1：预约 2：到店
     *
     * @param typeStatus 类型 1：预约 2：到店
     */
    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    /**
     * 获取诊室id
     *
     * @return consulting_room_id - 诊室id
     */
    public String getConsultingRoomId() {
        return consultingRoomId;
    }

    /**
     * 设置诊室id
     *
     * @param consultingRoomId 诊室id
     */
    public void setConsultingRoomId(String consultingRoomId) {
        this.consultingRoomId = consultingRoomId;
    }

    /**
     * 获取网电咨询师id
     *
     * @return network_electrical_counselor_id - 网电咨询师id
     */
    public String getNetworkElectricalCounselorId() {
        return networkElectricalCounselorId;
    }

    /**
     * 设置网电咨询师id
     *
     * @param networkElectricalCounselorId 网电咨询师id
     */
    public void setNetworkElectricalCounselorId(String networkElectricalCounselorId) {
        this.networkElectricalCounselorId = networkElectricalCounselorId;
    }

    /**
     * 获取短信提醒次数
     *
     * @return remind_number - 短信提醒次数
     */
    public Integer getRemindNumber() {
        return remindNumber;
    }

    /**
     * 设置短信提醒次数
     *
     * @param remindNumber 短信提醒次数
     */
    public void setRemindNumber(Integer remindNumber) {
        this.remindNumber = remindNumber;
    }

    /**
     * 获取是否已接诊
     *
     * @return is_reception - 是否已接诊
     */
    public Boolean getIsReception() {
        return isReception;
    }

    /**
     * 设置是否已接诊
     *
     * @param isReception 是否已接诊
     */
    public void setIsReception(Boolean isReception) {
        this.isReception = isReception;
    }

    /**
     * 获取是否已检查
     *
     * @return is_check - 是否已检查
     */
    public Boolean getIsCheck() {
        return isCheck;
    }

    /**
     * 设置是否已检查
     *
     * @param isCheck 是否已检查
     */
    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    /**
     * 获取是否已转诊
     *
     * @return is_transfer_treatment - 是否已转诊
     */
    public Boolean getIsTransferTreatment() {
        return isTransferTreatment;
    }

    /**
     * 设置是否已转诊
     *
     * @param isTransferTreatment 是否已转诊
     */
    public void setIsTransferTreatment(Boolean isTransferTreatment) {
        this.isTransferTreatment = isTransferTreatment;
    }

    /**
     * 获取是否治疗完成
     *
     * @return is_end_therapy - 是否治疗完成
     */
    public Boolean getIsEndTherapy() {
        return isEndTherapy;
    }

    /**
     * 设置是否治疗完成
     *
     * @param isEndTherapy 是否治疗完成
     */
    public void setIsEndTherapy(Boolean isEndTherapy) {
        this.isEndTherapy = isEndTherapy;
    }

    /**
     * 获取是否分诊
     *
     * @return is_triage - 是否分诊
     */
    public Boolean getIsTriage() {
        return isTriage;
    }

    /**
     * 设置是否分诊
     *
     * @param isTriage 是否分诊
     */
    public void setIsTriage(Boolean isTriage) {
        this.isTriage = isTriage;
    }

    /**
     * @return counselor_reception
     */
    public Boolean getCounselorReception() {
        return counselorReception;
    }

    /**
     * @param counselorReception
     */
    public void setCounselorReception(Boolean counselorReception) {
        this.counselorReception = counselorReception;
    }

    /**
     * 获取10待确认 20确认成功 30确认失败
     *
     * @return telephone_confirmation_status - 10待确认 20确认成功 30确认失败
     */
    public String getTelephoneConfirmationStatus() {
        return telephoneConfirmationStatus;
    }

    /**
     * 设置10待确认 20确认成功 30确认失败
     *
     * @param telephoneConfirmationStatus 10待确认 20确认成功 30确认失败
     */
    public void setTelephoneConfirmationStatus(String telephoneConfirmationStatus) {
        this.telephoneConfirmationStatus = telephoneConfirmationStatus;
    }

    /**
     * 获取大类ID
     *
     * @return class_id - 大类ID
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置大类ID
     *
     * @param classId 大类ID
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * 获取电话确认人
     *
     * @return telephone_confirmation_user - 电话确认人
     */
    public String getTelephoneConfirmationUser() {
        return telephoneConfirmationUser;
    }

    /**
     * 设置电话确认人
     *
     * @param telephoneConfirmationUser 电话确认人
     */
    public void setTelephoneConfirmationUser(String telephoneConfirmationUser) {
        this.telephoneConfirmationUser = telephoneConfirmationUser;
    }

    /**
     * 获取电话确认时间
     *
     * @return telephone_confirmation_time - 电话确认时间
     */
    public Date getTelephoneConfirmationTime() {
        return telephoneConfirmationTime;
    }

    /**
     * 设置电话确认时间
     *
     * @param telephoneConfirmationTime 电话确认时间
     */
    public void setTelephoneConfirmationTime(Date telephoneConfirmationTime) {
        this.telephoneConfirmationTime = telephoneConfirmationTime;
    }
}