package com.company.project.model;

import javax.persistence.*;

@Table(name = "medical_record_yw")
public class MedicalRecordYw {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 口腔检查
     */
    private String kqjc;

    /**
     * 辅助检查
     */
    private String fzjc;

    /**
     * 诊断
     */
    private String zd;

    /**
     * 治疗计划
     */
    private String zljh;

    /**
     * 处置
     */
    private String cz;

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
     * 获取口腔检查
     *
     * @return kqjc - 口腔检查
     */
    public String getKqjc() {
        return kqjc;
    }

    /**
     * 设置口腔检查
     *
     * @param kqjc 口腔检查
     */
    public void setKqjc(String kqjc) {
        this.kqjc = kqjc;
    }

    /**
     * 获取辅助检查
     *
     * @return fzjc - 辅助检查
     */
    public String getFzjc() {
        return fzjc;
    }

    /**
     * 设置辅助检查
     *
     * @param fzjc 辅助检查
     */
    public void setFzjc(String fzjc) {
        this.fzjc = fzjc;
    }

    /**
     * 获取诊断
     *
     * @return zd - 诊断
     */
    public String getZd() {
        return zd;
    }

    /**
     * 设置诊断
     *
     * @param zd 诊断
     */
    public void setZd(String zd) {
        this.zd = zd;
    }

    /**
     * 获取治疗计划
     *
     * @return zljh - 治疗计划
     */
    public String getZljh() {
        return zljh;
    }

    /**
     * 设置治疗计划
     *
     * @param zljh 治疗计划
     */
    public void setZljh(String zljh) {
        this.zljh = zljh;
    }

    /**
     * 获取处置
     *
     * @return cz - 处置
     */
    public String getCz() {
        return cz;
    }

    /**
     * 设置处置
     *
     * @param cz 处置
     */
    public void setCz(String cz) {
        this.cz = cz;
    }
}