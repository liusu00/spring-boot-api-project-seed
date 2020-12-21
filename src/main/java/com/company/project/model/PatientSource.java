package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "clc_patient_source")
public class PatientSource {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

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
     * 类型：1：外部来源，2： 员工推荐，3： 朋友介绍
     */
    private Byte type;

    /**
     * 外部联系人
     */
    @Column(name = "outside_linkman")
    private String outsideLinkman;

    /**
     * 内部联系人
     */
    @Column(name = "inside_linkman")
    private String insideLinkman;

    /**
     * 外部联系人电话号码
     */
    @Column(name = "outside_phone")
    private String outsidePhone;

    /**
     * 内部联系人电话号码
     */
    @Column(name = "inside_phone")
    private String insidePhone;

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
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_ids - 所有父级编号
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有父级编号
     *
     * @param parentIds 所有父级编号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
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
     * 获取类型：1：外部来源，2： 员工推荐，3： 朋友介绍
     *
     * @return type - 类型：1：外部来源，2： 员工推荐，3： 朋友介绍
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型：1：外部来源，2： 员工推荐，3： 朋友介绍
     *
     * @param type 类型：1：外部来源，2： 员工推荐，3： 朋友介绍
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取外部联系人
     *
     * @return outside_linkman - 外部联系人
     */
    public String getOutsideLinkman() {
        return outsideLinkman;
    }

    /**
     * 设置外部联系人
     *
     * @param outsideLinkman 外部联系人
     */
    public void setOutsideLinkman(String outsideLinkman) {
        this.outsideLinkman = outsideLinkman;
    }

    /**
     * 获取内部联系人
     *
     * @return inside_linkman - 内部联系人
     */
    public String getInsideLinkman() {
        return insideLinkman;
    }

    /**
     * 设置内部联系人
     *
     * @param insideLinkman 内部联系人
     */
    public void setInsideLinkman(String insideLinkman) {
        this.insideLinkman = insideLinkman;
    }

    /**
     * 获取外部联系人电话号码
     *
     * @return outside_phone - 外部联系人电话号码
     */
    public String getOutsidePhone() {
        return outsidePhone;
    }

    /**
     * 设置外部联系人电话号码
     *
     * @param outsidePhone 外部联系人电话号码
     */
    public void setOutsidePhone(String outsidePhone) {
        this.outsidePhone = outsidePhone;
    }

    /**
     * 获取内部联系人电话号码
     *
     * @return inside_phone - 内部联系人电话号码
     */
    public String getInsidePhone() {
        return insidePhone;
    }

    /**
     * 设置内部联系人电话号码
     *
     * @param insidePhone 内部联系人电话号码
     */
    public void setInsidePhone(String insidePhone) {
        this.insidePhone = insidePhone;
    }

    @Override
    public String toString() {
        return "PatientSource{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", type=" + type +
                '}';
    }
}