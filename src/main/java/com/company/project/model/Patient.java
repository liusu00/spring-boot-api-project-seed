package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_patient")
public class Patient {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 1、普通 2、临时
     */
    @Column(name = "patient_type")
    private String patientType;

    /**
     * 所属诊所
     */
    @Column(name = "clinic_id")
    private String clinicId;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别,0未知， 1男， 2女
     */
    private String sex;

    /**
     * 国藉
     */
    private String country;

    /**
     * 身份证号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 发证机关
     */
    @Column(name = "certificate_authority")
    private String certificateAuthority;

    /**
     * 有效期
     */
    @Column(name = "period_day")
    private String periodDay;

    /**
     * 照片
     */
    private String photo;

    /**
     * 籍贯
     */
    @Column(name = "native_place")
    private String nativePlace;

    /**
     * 民族
     */
    @Column(name = "nation_name")
    private String nationName;

    /**
     * 婚姻状态
     */
    @Column(name = "marriage_status")
    private String marriageStatus;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 宗教信仰
     */
    private String religion;

    /**
     * 其它证件
     */
    @Column(name = "other_card")
    private String otherCard;

    /**
     * 医保卡号
     */
    @Column(name = "medical_card")
    private String medicalCard;

    /**
     * 文化程序
     */
    @Column(name = "education_level")
    private String educationLevel;

    /**
     * 手机类型
     */
    @Column(name = "telephone_type")
    private String telephoneType;

    /**
     * 手机
     */
    @Column(name = "telephone_no")
    private String telephoneNo;

    /**
     * 病历号
     */
    @Column(name = "card_number")
    private String cardNumber;

    /**
     * 电话
     */
    @Column(name = "tel_no")
    private String telNo;

    /**
     * 微信号
     */
    @Column(name = "wechat_no")
    private String wechatNo;

    /**
     * QQ
     */
    @Column(name = "qq_no")
    private String qqNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地域id
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 所在省
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 所在区县
     */
    private String district;

    /**
     * 详细地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 微信开放平台ID
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 微信小程序OPENID
     */
    @Column(name = "mini_open_id")
    private String miniOpenId;

    /**
     * 微信公众平台唯一ID
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 苹果开放平台ID
     */
    @Column(name = "apple_open_id")
    private String appleOpenId;

    /**
     * 邀请人用户ID
     */
    @Column(name = "invite_user_id")
    private String inviteUserId;

    /**
     * 登录设备ID
     */
    @Column(name = "device_id")
    private String deviceId;

    /**
     * 推送唯一标识
     */
    @Column(name = "push_registration_id")
    private String pushRegistrationId;

    /**
     * 推送别名
     */
    @Column(name = "push_alias")
    private String pushAlias;

    /**
     * 推送标签
     */
    @Column(name = "push_tag")
    private String pushTag;

    /**
     * 学校ID
     */
    @Column(name = "school_id")
    private String schoolId;

    /**
     * 班级ID
     */
    @Column(name = "class_id")
    private String classId;

    /**
     * 一级来源
     */
    @Column(name = "one_level_source")
    private String oneLevelSource;

    /**
     * 二级来源
     */
    @Column(name = "two_level_source")
    private String twoLevelSource;

    /**
     * 三级来源
     */
    @Column(name = "three_level_source")
    private String threeLevelSource;

    /**
     * 患者标签
     */
    private String tag;

    /**
     * 初诊医生
     */
    @Column(name = "first_doctor_id")
    private String firstDoctorId;

    /**
     * 患者备注
     */
    private String remarks2;

    /**
     * 推荐人数
     */
    private Long referrals;

    /**
     * 初诊日期
     */
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * 主诉
     */
    @Column(name = "main_suit")
    private String mainSuit;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 初步判断
     */
    @Column(name = "first_symptomatic")
    private String firstSymptomatic;

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
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取1、普通 2、临时
     *
     * @return patient_type - 1、普通 2、临时
     */
    public String getPatientType() {
        return patientType;
    }

    /**
     * 设置1、普通 2、临时
     *
     * @param patientType 1、普通 2、临时
     */
    public void setPatientType(String patientType) {
        this.patientType = patientType;
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
     * 获取性别,0未知， 1男， 2女
     *
     * @return sex - 性别,0未知， 1男， 2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别,0未知， 1男， 2女
     *
     * @param sex 性别,0未知， 1男， 2女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取国藉
     *
     * @return country - 国藉
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国藉
     *
     * @param country 国藉
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取身份证号
     *
     * @return card_no - 身份证号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置身份证号
     *
     * @param cardNo 身份证号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取发证机关
     *
     * @return certificate_authority - 发证机关
     */
    public String getCertificateAuthority() {
        return certificateAuthority;
    }

    /**
     * 设置发证机关
     *
     * @param certificateAuthority 发证机关
     */
    public void setCertificateAuthority(String certificateAuthority) {
        this.certificateAuthority = certificateAuthority;
    }

    /**
     * 获取有效期
     *
     * @return period_day - 有效期
     */
    public String getPeriodDay() {
        return periodDay;
    }

    /**
     * 设置有效期
     *
     * @param periodDay 有效期
     */
    public void setPeriodDay(String periodDay) {
        this.periodDay = periodDay;
    }

    /**
     * 获取照片
     *
     * @return photo - 照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置照片
     *
     * @param photo 照片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取民族
     *
     * @return nation_name - 民族
     */
    public String getNationName() {
        return nationName;
    }

    /**
     * 设置民族
     *
     * @param nationName 民族
     */
    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    /**
     * 获取婚姻状态
     *
     * @return marriage_status - 婚姻状态
     */
    public String getMarriageStatus() {
        return marriageStatus;
    }

    /**
     * 设置婚姻状态
     *
     * @param marriageStatus 婚姻状态
     */
    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    /**
     * 获取职业
     *
     * @return occupation - 职业
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 设置职业
     *
     * @param occupation 职业
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 获取宗教信仰
     *
     * @return religion - 宗教信仰
     */
    public String getReligion() {
        return religion;
    }

    /**
     * 设置宗教信仰
     *
     * @param religion 宗教信仰
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * 获取其它证件
     *
     * @return other_card - 其它证件
     */
    public String getOtherCard() {
        return otherCard;
    }

    /**
     * 设置其它证件
     *
     * @param otherCard 其它证件
     */
    public void setOtherCard(String otherCard) {
        this.otherCard = otherCard;
    }

    /**
     * 获取医保卡号
     *
     * @return medical_card - 医保卡号
     */
    public String getMedicalCard() {
        return medicalCard;
    }

    /**
     * 设置医保卡号
     *
     * @param medicalCard 医保卡号
     */
    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    /**
     * 获取文化程序
     *
     * @return education_level - 文化程序
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 设置文化程序
     *
     * @param educationLevel 文化程序
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 获取手机类型
     *
     * @return telephone_type - 手机类型
     */
    public String getTelephoneType() {
        return telephoneType;
    }

    /**
     * 设置手机类型
     *
     * @param telephoneType 手机类型
     */
    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }

    /**
     * 获取手机
     *
     * @return telephone_no - 手机
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * 设置手机
     *
     * @param telephoneNo 手机
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * 获取病历号
     *
     * @return card_number - 病历号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置病历号
     *
     * @param cardNumber 病历号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 获取电话
     *
     * @return tel_no - 电话
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * 设置电话
     *
     * @param telNo 电话
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * 获取微信号
     *
     * @return wechat_no - 微信号
     */
    public String getWechatNo() {
        return wechatNo;
    }

    /**
     * 设置微信号
     *
     * @param wechatNo 微信号
     */
    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    /**
     * 获取QQ
     *
     * @return qq_no - QQ
     */
    public String getQqNo() {
        return qqNo;
    }

    /**
     * 设置QQ
     *
     * @param qqNo QQ
     */
    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
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
     * 获取地域id
     *
     * @return area_id - 地域id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置地域id
     *
     * @param areaId 地域id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取所在省
     *
     * @return province - 所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在市
     *
     * @return city - 所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在区县
     *
     * @return district - 所在区县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置所在区县
     *
     * @param district 所在区县
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取详细地址
     *
     * @return detail_address - 详细地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置详细地址
     *
     * @param detailAddress 详细地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    /**
     * 获取微信开放平台ID
     *
     * @return open_id - 微信开放平台ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信开放平台ID
     *
     * @param openId 微信开放平台ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取微信小程序OPENID
     *
     * @return mini_open_id - 微信小程序OPENID
     */
    public String getMiniOpenId() {
        return miniOpenId;
    }

    /**
     * 设置微信小程序OPENID
     *
     * @param miniOpenId 微信小程序OPENID
     */
    public void setMiniOpenId(String miniOpenId) {
        this.miniOpenId = miniOpenId;
    }

    /**
     * 获取微信公众平台唯一ID
     *
     * @return union_id - 微信公众平台唯一ID
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置微信公众平台唯一ID
     *
     * @param unionId 微信公众平台唯一ID
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取苹果开放平台ID
     *
     * @return apple_open_id - 苹果开放平台ID
     */
    public String getAppleOpenId() {
        return appleOpenId;
    }

    /**
     * 设置苹果开放平台ID
     *
     * @param appleOpenId 苹果开放平台ID
     */
    public void setAppleOpenId(String appleOpenId) {
        this.appleOpenId = appleOpenId;
    }

    /**
     * 获取邀请人用户ID
     *
     * @return invite_user_id - 邀请人用户ID
     */
    public String getInviteUserId() {
        return inviteUserId;
    }

    /**
     * 设置邀请人用户ID
     *
     * @param inviteUserId 邀请人用户ID
     */
    public void setInviteUserId(String inviteUserId) {
        this.inviteUserId = inviteUserId;
    }

    /**
     * 获取登录设备ID
     *
     * @return device_id - 登录设备ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置登录设备ID
     *
     * @param deviceId 登录设备ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取推送唯一标识
     *
     * @return push_registration_id - 推送唯一标识
     */
    public String getPushRegistrationId() {
        return pushRegistrationId;
    }

    /**
     * 设置推送唯一标识
     *
     * @param pushRegistrationId 推送唯一标识
     */
    public void setPushRegistrationId(String pushRegistrationId) {
        this.pushRegistrationId = pushRegistrationId;
    }

    /**
     * 获取推送别名
     *
     * @return push_alias - 推送别名
     */
    public String getPushAlias() {
        return pushAlias;
    }

    /**
     * 设置推送别名
     *
     * @param pushAlias 推送别名
     */
    public void setPushAlias(String pushAlias) {
        this.pushAlias = pushAlias;
    }

    /**
     * 获取推送标签
     *
     * @return push_tag - 推送标签
     */
    public String getPushTag() {
        return pushTag;
    }

    /**
     * 设置推送标签
     *
     * @param pushTag 推送标签
     */
    public void setPushTag(String pushTag) {
        this.pushTag = pushTag;
    }

    /**
     * 获取学校ID
     *
     * @return school_id - 学校ID
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校ID
     *
     * @param schoolId 学校ID
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取班级ID
     *
     * @return class_id - 班级ID
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * 获取一级来源
     *
     * @return one_level_source - 一级来源
     */
    public String getOneLevelSource() {
        return oneLevelSource;
    }

    /**
     * 设置一级来源
     *
     * @param oneLevelSource 一级来源
     */
    public void setOneLevelSource(String oneLevelSource) {
        this.oneLevelSource = oneLevelSource;
    }

    /**
     * 获取二级来源
     *
     * @return two_level_source - 二级来源
     */
    public String getTwoLevelSource() {
        return twoLevelSource;
    }

    /**
     * 设置二级来源
     *
     * @param twoLevelSource 二级来源
     */
    public void setTwoLevelSource(String twoLevelSource) {
        this.twoLevelSource = twoLevelSource;
    }

    /**
     * 获取三级来源
     *
     * @return three_level_source - 三级来源
     */
    public String getThreeLevelSource() {
        return threeLevelSource;
    }

    /**
     * 设置三级来源
     *
     * @param threeLevelSource 三级来源
     */
    public void setThreeLevelSource(String threeLevelSource) {
        this.threeLevelSource = threeLevelSource;
    }

    /**
     * 获取患者标签
     *
     * @return tag - 患者标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置患者标签
     *
     * @param tag 患者标签
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取初诊医生
     *
     * @return first_doctor_id - 初诊医生
     */
    public String getFirstDoctorId() {
        return firstDoctorId;
    }

    /**
     * 设置初诊医生
     *
     * @param firstDoctorId 初诊医生
     */
    public void setFirstDoctorId(String firstDoctorId) {
        this.firstDoctorId = firstDoctorId;
    }

    /**
     * 获取患者备注
     *
     * @return remarks2 - 患者备注
     */
    public String getRemarks2() {
        return remarks2;
    }

    /**
     * 设置患者备注
     *
     * @param remarks2 患者备注
     */
    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    /**
     * 获取推荐人数
     *
     * @return referrals - 推荐人数
     */
    public Long getReferrals() {
        return referrals;
    }

    /**
     * 设置推荐人数
     *
     * @param referrals 推荐人数
     */
    public void setReferrals(Long referrals) {
        this.referrals = referrals;
    }

    /**
     * 获取初诊日期
     *
     * @return begin_date - 初诊日期
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置初诊日期
     *
     * @param beginDate 初诊日期
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取主诉
     *
     * @return main_suit - 主诉
     */
    public String getMainSuit() {
        return mainSuit;
    }

    /**
     * 设置主诉
     *
     * @param mainSuit 主诉
     */
    public void setMainSuit(String mainSuit) {
        this.mainSuit = mainSuit;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取症状
     *
     * @return symptom - 症状
     */
    public String getSymptom() {
        return symptom;
    }

    /**
     * 设置症状
     *
     * @param symptom 症状
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    /**
     * 获取初步判断
     *
     * @return first_symptomatic - 初步判断
     */
    public String getFirstSymptomatic() {
        return firstSymptomatic;
    }

    /**
     * 设置初步判断
     *
     * @param firstSymptomatic 初步判断
     */
    public void setFirstSymptomatic(String firstSymptomatic) {
        this.firstSymptomatic = firstSymptomatic;
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