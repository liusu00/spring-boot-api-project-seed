package com.company.project.model;

import javax.persistence.*;

@Table(name = "clc_counsel_items_rel")
public class CounselItemsRel {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 预约挂号id
     */
    @Column(name = "counsel_id")
    private String counselId;

    /**
     * 咨询项目
     */
    @Column(name = "item_name")
    private String itemName;

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
     * 获取预约挂号id
     *
     * @return counsel_id - 预约挂号id
     */
    public String getCounselId() {
        return counselId;
    }

    /**
     * 设置预约挂号id
     *
     * @param counselId 预约挂号id
     */
    public void setCounselId(String counselId) {
        this.counselId = counselId;
    }

    /**
     * 获取咨询项目
     *
     * @return item_name - 咨询项目
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置咨询项目
     *
     * @param itemName 咨询项目
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}