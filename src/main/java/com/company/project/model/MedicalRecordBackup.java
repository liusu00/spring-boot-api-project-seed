package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "medical_record_backup")
public class MedicalRecordBackup {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 病历状态
     */
    private String status;

    /**
     * 病历号
     */
    private String blh;

    /**
     * 患者
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 就诊时间
     */
    private Date jzsj;

    /**
     * 诊所
     */
    private String clinic;

    /**
     * 医生
     */
    private String ys;

    /**
     * 助手
     */
    private String zs;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改时间
     */
    private Date xgsj;

    /**
     * 病历类型
     */
    private String bllx;

    @Column(name = "import_time")
    private Date importTime;

    @Column(name = "import_code")
    private Integer importCode;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "appointment_id")
    private String appointmentId;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
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
     * 获取病历状态
     *
     * @return status - 病历状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置病历状态
     *
     * @param status 病历状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取病历号
     *
     * @return blh - 病历号
     */
    public String getBlh() {
        return blh;
    }

    /**
     * 设置病历号
     *
     * @param blh 病历号
     */
    public void setBlh(String blh) {
        this.blh = blh;
    }

    /**
     * 获取患者
     *
     * @return name - 患者
     */
    public String getName() {
        return name;
    }

    /**
     * 设置患者
     *
     * @param name 患者
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
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取就诊时间
     *
     * @return jzsj - 就诊时间
     */
    public Date getJzsj() {
        return jzsj;
    }

    /**
     * 设置就诊时间
     *
     * @param jzsj 就诊时间
     */
    public void setJzsj(Date jzsj) {
        this.jzsj = jzsj;
    }

    /**
     * 获取诊所
     *
     * @return clinic - 诊所
     */
    public String getClinic() {
        return clinic;
    }

    /**
     * 设置诊所
     *
     * @param clinic 诊所
     */
    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    /**
     * 获取医生
     *
     * @return ys - 医生
     */
    public String getYs() {
        return ys;
    }

    /**
     * 设置医生
     *
     * @param ys 医生
     */
    public void setYs(String ys) {
        this.ys = ys;
    }

    /**
     * 获取助手
     *
     * @return zs - 助手
     */
    public String getZs() {
        return zs;
    }

    /**
     * 设置助手
     *
     * @param zs 助手
     */
    public void setZs(String zs) {
        this.zs = zs;
    }

    /**
     * 获取创建时间
     *
     * @return cjsj - 创建时间
     */
    public Date getCjsj() {
        return cjsj;
    }

    /**
     * 设置创建时间
     *
     * @param cjsj 创建时间
     */
    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    /**
     * 获取修改时间
     *
     * @return xgsj - 修改时间
     */
    public Date getXgsj() {
        return xgsj;
    }

    /**
     * 设置修改时间
     *
     * @param xgsj 修改时间
     */
    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    /**
     * 获取病历类型
     *
     * @return bllx - 病历类型
     */
    public String getBllx() {
        return bllx;
    }

    /**
     * 设置病历类型
     *
     * @param bllx 病历类型
     */
    public void setBllx(String bllx) {
        this.bllx = bllx;
    }

    /**
     * @return import_time
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * @param importTime
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    /**
     * @return import_code
     */
    public Integer getImportCode() {
        return importCode;
    }

    /**
     * @param importCode
     */
    public void setImportCode(Integer importCode) {
        this.importCode = importCode;
    }
}