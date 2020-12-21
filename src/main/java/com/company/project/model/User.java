package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class User {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 归属公司
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 归属部门
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 最后登陆IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 是否可登录
     */
    @Column(name = "login_flag")
    private String loginFlag;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 个性签名
     */
    private String sign;

    private String appid;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 所属诊所
     */
    @Column(name = "clinic_id")
    private String clinicId;

    /**
     * 岗位
     */
    private String poster;

    /**
     * 科室
     */
    @Column(name = "department_id")
    private String departmentId;

    /**
     * 联系手机
     */
    private String telno;

    /**
     * 身份证
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 职称
     */
    @Column(name = "positional_title")
    private String positionalTitle;

    /**
     * 执业证书号
     */
    @Column(name = "certificate_no")
    private String certificateNo;

    /**
     * 家庭住址
     */
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 工作诊所
     */
    @Column(name = "work_clinic")
    private String workClinic;

    /**
     * 在职状态，0：离职，1：在职
     */
    @Column(name = "work_staus")
    private String workStaus;

    /**
     * 医师照片
     */
    @Column(name = "doctor_photo")
    private String doctorPhoto;

    /**
     * 医师执业证首页
     */
    @Column(name = "certificate_index")
    private String certificateIndex;

    /**
     * 医师执业证个人信息
     */
    @Column(name = "certificate_info")
    private String certificateInfo;

    /**
     * 绑定手机
     */
    @Column(name = "bind_tel")
    private String bindTel;

    /**
     * 所属角色
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 手机验证
     */
    @Column(name = "tel_verify")
    private String telVerify;

    /**
     * 验证手机
     */
    @Column(name = "verify_telno")
    private String verifyTelno;

    /**
     * 设备验证
     */
    @Column(name = "device_verify")
    private String deviceVerify;

    /**
     * 登录App
     */
    @Column(name = "login_app")
    private String loginApp;

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
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取归属公司
     *
     * @return company_id - 归属公司
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置归属公司
     *
     * @param companyId 归属公司
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取归属部门
     *
     * @return office_id - 归属部门
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 设置归属部门
     *
     * @param officeId 归属部门
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取工号
     *
     * @return no - 工号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置工号
     *
     * @param no 工号
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户头像
     *
     * @return photo - 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置用户头像
     *
     * @param photo 用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取最后登陆IP
     *
     * @return login_ip - 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置最后登陆IP
     *
     * @param loginIp 最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取最后登陆时间
     *
     * @return login_date - 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置最后登陆时间
     *
     * @param loginDate 最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取是否可登录
     *
     * @return login_flag - 是否可登录
     */
    public String getLoginFlag() {
        return loginFlag;
    }

    /**
     * 设置是否可登录
     *
     * @param loginFlag 是否可登录
     */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    /**
     * 获取二维码
     *
     * @return qrcode - 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置二维码
     *
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 获取个性签名
     *
     * @return sign - 个性签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置个性签名
     *
     * @param sign 个性签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
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
     * 获取所属诊所
     *
     * @return clinic_id - 所属诊所
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 设置所属诊所
     *
     * @param clinicId 所属诊所
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    /**
     * 获取岗位
     *
     * @return poster - 岗位
     */
    public String getPoster() {
        return poster;
    }

    /**
     * 设置岗位
     *
     * @param poster 岗位
     */
    public void setPoster(String poster) {
        this.poster = poster;
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
     * 获取联系手机
     *
     * @return telno - 联系手机
     */
    public String getTelno() {
        return telno;
    }

    /**
     * 设置联系手机
     *
     * @param telno 联系手机
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * 获取身份证
     *
     * @return card_no - 身份证
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置身份证
     *
     * @param cardNo 身份证
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取职称
     *
     * @return positional_title - 职称
     */
    public String getPositionalTitle() {
        return positionalTitle;
    }

    /**
     * 设置职称
     *
     * @param positionalTitle 职称
     */
    public void setPositionalTitle(String positionalTitle) {
        this.positionalTitle = positionalTitle;
    }

    /**
     * 获取执业证书号
     *
     * @return certificate_no - 执业证书号
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * 设置执业证书号
     *
     * @param certificateNo 执业证书号
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    /**
     * 获取家庭住址
     *
     * @return home_address - 家庭住址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param homeAddress 家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取工作诊所
     *
     * @return work_clinic - 工作诊所
     */
    public String getWorkClinic() {
        return workClinic;
    }

    /**
     * 设置工作诊所
     *
     * @param workClinic 工作诊所
     */
    public void setWorkClinic(String workClinic) {
        this.workClinic = workClinic;
    }

    /**
     * 获取在职状态，0：离职，1：在职
     *
     * @return work_staus - 在职状态，0：离职，1：在职
     */
    public String getWorkStaus() {
        return workStaus;
    }

    /**
     * 设置在职状态，0：离职，1：在职
     *
     * @param workStaus 在职状态，0：离职，1：在职
     */
    public void setWorkStaus(String workStaus) {
        this.workStaus = workStaus;
    }

    /**
     * 获取医师照片
     *
     * @return doctor_photo - 医师照片
     */
    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    /**
     * 设置医师照片
     *
     * @param doctorPhoto 医师照片
     */
    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    /**
     * 获取医师执业证首页
     *
     * @return certificate_index - 医师执业证首页
     */
    public String getCertificateIndex() {
        return certificateIndex;
    }

    /**
     * 设置医师执业证首页
     *
     * @param certificateIndex 医师执业证首页
     */
    public void setCertificateIndex(String certificateIndex) {
        this.certificateIndex = certificateIndex;
    }

    /**
     * 获取医师执业证个人信息
     *
     * @return certificate_info - 医师执业证个人信息
     */
    public String getCertificateInfo() {
        return certificateInfo;
    }

    /**
     * 设置医师执业证个人信息
     *
     * @param certificateInfo 医师执业证个人信息
     */
    public void setCertificateInfo(String certificateInfo) {
        this.certificateInfo = certificateInfo;
    }

    /**
     * 获取绑定手机
     *
     * @return bind_tel - 绑定手机
     */
    public String getBindTel() {
        return bindTel;
    }

    /**
     * 设置绑定手机
     *
     * @param bindTel 绑定手机
     */
    public void setBindTel(String bindTel) {
        this.bindTel = bindTel;
    }

    /**
     * 获取所属角色
     *
     * @return role_id - 所属角色
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置所属角色
     *
     * @param roleId 所属角色
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取手机验证
     *
     * @return tel_verify - 手机验证
     */
    public String getTelVerify() {
        return telVerify;
    }

    /**
     * 设置手机验证
     *
     * @param telVerify 手机验证
     */
    public void setTelVerify(String telVerify) {
        this.telVerify = telVerify;
    }

    /**
     * 获取验证手机
     *
     * @return verify_telno - 验证手机
     */
    public String getVerifyTelno() {
        return verifyTelno;
    }

    /**
     * 设置验证手机
     *
     * @param verifyTelno 验证手机
     */
    public void setVerifyTelno(String verifyTelno) {
        this.verifyTelno = verifyTelno;
    }

    /**
     * 获取设备验证
     *
     * @return device_verify - 设备验证
     */
    public String getDeviceVerify() {
        return deviceVerify;
    }

    /**
     * 设置设备验证
     *
     * @param deviceVerify 设备验证
     */
    public void setDeviceVerify(String deviceVerify) {
        this.deviceVerify = deviceVerify;
    }

    /**
     * 获取登录App
     *
     * @return login_app - 登录App
     */
    public String getLoginApp() {
        return loginApp;
    }

    /**
     * 设置登录App
     *
     * @param loginApp 登录App
     */
    public void setLoginApp(String loginApp) {
        this.loginApp = loginApp;
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