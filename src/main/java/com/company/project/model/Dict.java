package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dict_value")
public class Dict {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 标签名
     */
    @Column(name = "dict_type_id")
    private String dictTypeId;

    /**
     * 键值
     */
    private String label;

    /**
     * 排序
     */
    private String value;

    /**
     * 外键
     */
    private Integer sort;

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
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取标签名
     *
     * @return dict_type_id - 标签名
     */
    public String getDictTypeId() {
        return dictTypeId;
    }

    /**
     * 设置标签名
     *
     * @param dictTypeId 标签名
     */
    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    /**
     * 获取键值
     *
     * @return label - 键值
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置键值
     *
     * @param label 键值
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取排序
     *
     * @return value - 排序
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置排序
     *
     * @param value 排序
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取外键
     *
     * @return sort - 外键
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置外键
     *
     * @param sort 外键
     */
    public void setSort(Integer sort) {
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
     * 获取逻辑删除标记（0：显示；1：隐藏）
     *
     * @return del_flag - 逻辑删除标记（0：显示；1：隐藏）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记（0：显示；1：隐藏）
     *
     * @param delFlag 逻辑删除标记（0：显示；1：隐藏）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}